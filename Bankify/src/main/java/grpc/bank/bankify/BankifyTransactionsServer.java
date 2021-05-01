package grpc.bank.bankify;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

import grpc.bank.bankify.BankTransactionsGrpc.BankTransactionsImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
*
* @author Camila Chapetzan Antunes
* Class BankifyTransactionsServer
* - server-side implementation of gRPC service BankifyTransactions
*/
public class BankifyTransactionsServer extends BankTransactionsImplBase {
	
	static Bankify bank;
	
	//constructor
	public void setBank(Bankify bank) {
		this.bank = bank;
	}

	/*
	 * gRPC method addUser implementation
	 * - NewUserData request: all the necessary data for bank user registry
	 * message NewUserData {
	 *   string firstName = 1;
  	 *   string lastName = 2;
  	 *   string id = 3;
  	 *   string gender = 4;
  	 *   string email = 5;
  	 *   string password = 6;
  	 *   int32 pin = 7;
  	 *   string phone = 8;
  	 *   string address = 9;
  	 * }
  	 * - BankReply response: message with added user confirmation
  	 * 
	 */
	@Override
	public void addUser(NewUserData request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving add user request");
		
		bank.addUser(request.getFirstName(), request.getLastName(), request.getId(), request.getGender().charAt(0), request.getEmail(), request.getPassword(), request.getPin(), request.getPhone(), request.getAddress());

		 BankReply reply = BankReply.newBuilder().setMessage("New Bankify User: " + bank.users.get(bank.users.size()-1).toString()).build();

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	/*
	 * gRPC method userLogin implementation
	 * - LoginData request: email and passwordfor user login
	 * message LoginData {
	 *   string email = 1;
  	 *   string password = 2;
  	 * }
  	 * - LoginReply response: message if login was successfull, with user's first name, email and account number
  	 * message LoginReply {
  	 *   string LoginMessage = 1;
  	 *   string FirstName = 2;
  	 *   string email = 3;
  	 *   int32 accountNumber = 4;
  	 * }
	 */
	@Override
	public void userLogin(LoginData request,  StreamObserver<LoginReply> responseObserver) {

		System.out.println("receiving login request");
		BankUser user;
		LoginReply reply;
		//search if user exists in the bank data
		user = bank.searchUser(request.getEmail());
		if(Objects.isNull(user)) { //if user not found return answer
			 reply = LoginReply.newBuilder().setLoginMessage("Bank User not found").setFirstName("").setEmail("").build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.login(request.getEmail(), request.getPassword())) {	//login ok, return answer with data	
			reply = LoginReply.newBuilder().setLoginMessage("User is logged in:").setFirstName(user.getFirstName()).setEmail(user.getEmail()).setAccountNumber(user.account.getAccountNumber()).build();
		} else { //if the password was wrong, return answer
			reply = LoginReply.newBuilder().setLoginMessage("Password missmatch").setFirstName("").setEmail("").build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
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
	}
	
	/*
	 * gRPC method getBalance implementation
	 * - AccountData request: account number and pin for validation
	 * message AccountData {
	 *   int32 accountNumber = 1;
  	 *   int32 pin = 2;
  	 * }
  	 * - FloatReply response: if validation was successfull, return user balance
  	 * message FloatReply {
  	 *   string message = 1;
  	 *   float balance = 2;
  	 * }
	 */
	@Override
	public void getBalance(AccountData request,  StreamObserver<FloatReply> responseObserver) {

		System.out.println("receiving balance request");
		BankUser user;
		FloatReply reply;
		//search if user account exists in the bank data
		user = bank.searchAccount(request.getAccountNumber());
		if(Objects.isNull(user)) { //account not fount
			 reply = FloatReply.newBuilder().setMessage("Bank User not found").setBalance(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.isLogged()) {
			//user logged in and valid pin: balance response
			if(user.account.validateAccountTransaction(request.getPin())) {
				reply = FloatReply.newBuilder().setMessage("Account verified. Your balance is: ").setBalance(user.account.getBalance()).build();
			}else {//pin incorrect response
				reply = FloatReply.newBuilder().setMessage("Your pin is incorrect. Try again").setBalance(-1).build();
			}
		} else { //user not logged in response
			reply = FloatReply.newBuilder().setMessage("User not logged in").setBalance(-1).build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	/*
	 * gRPC method transferBalance implementation
	 * - AccountTransfer request: account number and pin for validation, account destination and value
	 * message AccountTransfer {
	 *   int32 accountNumber = 1;
  	 *   int32 pin = 2;
  	 *   int32 toAccountNumber = 3;
  	 *   float value = 4;
  	 * }
  	 * - FloatReply response: if validation was successfull, pay and return user balance
  	 * message FloatReply {
  	 *   string message = 1;
  	 *   float balance = 2;
  	 * }
	 */
	@Override
	public void transferBalance(AccountTransfer request,  StreamObserver<FloatReply> responseObserver) {

		System.out.println("receiving transfer request");
		BankUser user;
		BankUser toUser;
		FloatReply reply;
		//search if user account exists in the bank data
		user = bank.searchAccount(request.getAccountNumber());
		if(Objects.isNull(user)) { //account not fount
			 reply = FloatReply.newBuilder().setMessage("Bank User not found").setBalance(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		//search if user destination account exists in the bank data
		toUser = bank.searchAccount(request.getToAccountNumber());
		if(Objects.isNull(toUser)) { //destination account not fount
			 reply = FloatReply.newBuilder().setMessage("Destination bank account not found").setBalance(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.isLogged()) {
			//user logged in and valid pin: balance response
			if(user.account.transfer(request.getPin(), toUser.account, request.getValue())) {
				reply = FloatReply.newBuilder().setMessage("Value transfered successfully. Your balance is: ").setBalance(user.account.getBalance()).build();
			}else { //invalid pin or insufficient balance
				reply = FloatReply.newBuilder().setMessage("Your pin is incorrect or you don't have balance.").setBalance(-1).build();
			}
		} else { //user not logged in response
			reply = FloatReply.newBuilder().setMessage("User not logged in").setBalance(-1).build();
		}
		
		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	/*
	 * gRPC method accountMovement implementation
	 * - AccountData request: account number and pin for validation
	 * message AccountData {
	 *   int32 accountNumber = 1;
  	 *   int32 pin = 2;
  	 * }
  	 * - MovementData response: if validation was successfull, return all movement data (in stream format)
  	 * message MovementData {
  	 *   string movement = 1;
  	 * }
	 */
	@Override
	public void accountMovement(AccountData request,  StreamObserver<MovementData> responseObserver) {

		System.out.println("receiving movement request");
		BankUser user;
		MovementData reply;
		//search if user account exists in the bank data
		user = bank.searchAccount(request.getAccountNumber());
		if(Objects.isNull(user)) { //account not fount
			 reply = MovementData.newBuilder().setMovement("Bank User not found").build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		//user logged in and pin validated: save allmovements on stream responseObserver
		if(user.isLogged()&&user.account.validateAccountTransaction(request.getPin())) {
			for(AccountMovement mov: user.account.getHistory()) {
				reply = MovementData.newBuilder().setMovement(mov.toString()).build();
				responseObserver.onNext(reply);
			}
		} else {
			if (!user.isLogged()) //user not logged in response
				reply = MovementData.newBuilder().setMovement("User not logged in ").build();
			else //invalid pin response
				reply = MovementData.newBuilder().setMovement("Invalid pin").build();
		}

	     responseObserver.onCompleted();
	}

}
