package grpc.bank.bankify;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Logger;

import grpc.bank.bankify.BankPayGrpc.BankPayImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.StatusRuntimeException;

/**
*
* @author Camila Chapetzan Antunes
* Class BankifyPayServer
* - server-side implementation of gRPC service BankifyPay
*/
public class BankifyPayServer extends BankPayImplBase {
	
	static Bankify bank;
	
	public void setBank(Bankify bank) {
		this.bank = bank;
	}

	/*
	 * gRPC method holderLogin implementation
	 * - LoginData request: email and passwordfor user login
	 * message LoginData {
	 *   string email = 1;
  	 *   string password = 2;
  	 * }
  	 * - LoginPayReply response: message if login was successfull, with user's first name and account number
  	 * message LoginReply {
  	 *   string LoginMessage = 1;
  	 *   string FirstName = 2;
  	 *   int32 accountNumber = 3;
  	 * }
	 */
	@Override
	public void holderLogin(LoginData request,  StreamObserver<LoginPayReply> responseObserver) {

		System.out.println("receiving holder login request");
		BankUser user;
		LoginPayReply reply;
		//search if user exists in the bank data
		user = bank.searchUser(request.getEmail());
		if(Objects.isNull(user)) { //user not found response
			 reply = LoginPayReply.newBuilder().setLoginMessage("Bank User not found").setFirstName("").setAccountNumber(0).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.login(request.getEmail(), request.getPassword())) {	//login ok, return answer with data		
			reply = LoginPayReply.newBuilder().setLoginMessage("User is logged in:").setFirstName(user.getFirstName()).setAccountNumber(user.account.getAccountNumber()).build();
		} else { //if the password was wrong, return answer
			reply = LoginPayReply.newBuilder().setLoginMessage("Password missmatch").setFirstName("").setFirstName("").setAccountNumber(0).build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	     System.out.println("login request successfull");
	}
	
	/*
	 * gRPC method userLogout implementation
	 * - LogoutData request: email user logout
	 * message LogoutData {
	 *   string email = 1;
  	 * }
  	 * - BankReply response: message if logout was successfull
	 */
	@Override
	public void userLogout(LogoutData request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving logout request");
		BankUser user;
		BankReply reply;
		//search for user
		user = bank.searchUser(request.getEmail());
		if(Objects.isNull(user)) {
			 reply = BankReply.newBuilder().setMessage("Bank User not found").build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.isLogged()) { //if user was logged in, performs logout
			user.logout();
			reply = BankReply.newBuilder().setMessage("User logged out").build();
		} else { //else answer user was not logged
			reply = BankReply.newBuilder().setMessage("User was not logged in").build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	     
	     System.out.println("logout request successfull");
	}
	
	/*
	 * gRPC method pay implementation
	 * - PayRequest request: account number and pin for validation, account destination and value
	 * message PayRequest {
	 *   string cardNumber = 1;
  	 *   int32 pin = 2;
  	 *   int32 holderAcc = 3;
  	 *   float value = 4;
  	 * }
  	 * - PayReply response: if validation was successfull, pay and return data for local history
  	 * message PayReply {
  	 *   string details = 1;
  	 *   string name = 2;
  	 *   float value = 3;
  	 *   string date = 4;
  	 * }
	 */
	@Override
	public void pay(PayRequest request,  StreamObserver<PayReply> responseObserver) {

		System.out.println("receiving pay request");
		BankUser user;
		BankUser toUser;
		PayReply reply;
		//search if user exists in the bank data
		user = bank.searchCard(request.getCardNumber());
		if(Objects.isNull(user)) { //user not found response
			 reply = PayReply.newBuilder().setDetails("Card not found").setDate("").setName("").setValue(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		//search if user destination account exists in the bank data
		toUser = bank.searchAccount(request.getHolderAcc());
		if(Objects.isNull(toUser)) { //destination not found
			 reply = PayReply.newBuilder().setDetails("Holder account not found").setDate("").setName("").setValue(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		//user logged in and valid pin: payment response with data
		if(toUser.isLogged()) {
			if(user.account.pay(request.getCardNumber(), request.getPin(), request.getValue(), toUser.account)) {
				reply = PayReply.newBuilder().setDetails("Payment aproved").setName(user.getFirstName()+" "+user.getLastName()).setDate(LocalDateTime.now().toString()).setValue(request.getValue()).build();
			}else { //payment not aproved response
				reply = PayReply.newBuilder().setDetails("Payment not approved. Check with Bankify").setDate("").setName("").setValue(-1).build();
			}
		} else { //holder not logged in response
			reply = PayReply.newBuilder().setDetails("Holder not logged in").setDate("").setName("").setValue(-1).build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	     System.out.println("transfer request successfull");
	}
	
	/*
	 * gRPC method payHistoryRegister implementation
	 * - PayHistory request: stream of all local history from pay client 
	 * message PayHistory {
	 *   string cardNumber = 1;
  	 *   int32 holderAcc = 2;
  	 *   float value = 3;
  	 *   string date = 4;
  	 * }
  	 * - BankReply response: message if history transfer was successfull
	 */
	@Override
	public StreamObserver<PayHistory> payHistoryRegister(StreamObserver<BankReply> responseObserver) {
		System.out.println("receiving payHistoryRegister request");
		return new StreamObserver<PayHistory>() { //history stream
			private int pHsize = bank.paymentHistory.size();
			private int requestSize = 0;
			@Override
            public void onNext(PayHistory request) { //onNext PayHistory implementation
				//get data
				String cardNumber = request.getCardNumber();
				int holderAcc = request.getHolderAcc();
				String date = request.getDate();
				float value = request.getValue();
				//add in the bank payment history
				bank.paymentHistory.add(new PaymentTransaction(cardNumber, holderAcc, date, value));
				requestSize++;
			}
			
			@Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }
			
			@Override
            public void onCompleted() { //onCompleted PayHistory implementation
				//check if all fields were saved
				if (bank.paymentHistory.size() == pHsize + requestSize) { //return successfull message
					System.out.println("Payments History transfered successfully");
					BankReply response = BankReply.newBuilder().setMessage("Payments History transfered successfully").build();
					responseObserver.onNext(response);
					responseObserver.onCompleted();
				} else { //error message
					BankReply response = BankReply.newBuilder().setMessage("Payments History error").build();
					responseObserver.onNext(response);
					responseObserver.onCompleted();
				}
            }
		};
	}
	
}