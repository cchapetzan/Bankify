package grpc.bank.bankify;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Logger;

import grpc.bank.bankify.BankPayGrpc.BankPayImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BankifyPayServer extends BankPayImplBase {
	
	static Bankify bank;
	
	public void setBank(Bankify bank) {
		this.bank = bank;
	}

	@Override
	public void holderLogin(LoginData request,  StreamObserver<LoginPayReply> responseObserver) {

		System.out.println("receiving holder login request");
		BankUser user;
		LoginPayReply reply;
		user = bank.searchUser(request.getEmail());
		if(Objects.isNull(user)) {
			 reply = LoginPayReply.newBuilder().setLoginMessage("Bank User not found").setFirstName("").setAccountNumber(0).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.login(request.getEmail(), request.getPassword())) {		
			reply = LoginPayReply.newBuilder().setLoginMessage("User is logged in:").setFirstName(user.getFirstName()).setAccountNumber(user.account.getAccountNumber()).build();
		} else {
			reply = LoginPayReply.newBuilder().setLoginMessage("Password missmatch").setFirstName("").setFirstName("").setAccountNumber(0).build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	@Override
	public void userLogout(LogoutData request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving logout request");
		BankUser user;
		BankReply reply;
		user = bank.searchUser(request.getEmail());
		if(Objects.isNull(user)) {
			 reply = BankReply.newBuilder().setMessage("Bank User not found").build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.isLogged()) {
			user.logout();
			reply = BankReply.newBuilder().setMessage("User logged out").build();
		} else {
			reply = BankReply.newBuilder().setMessage("User was not logged in").build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	@Override
	public void pay(PayRequest request,  StreamObserver<PayReply> responseObserver) {

		System.out.println("receiving transfer request");
		BankUser user;
		BankUser toUser;
		PayReply reply;
		user = bank.searchCard(request.getCardNumber());
		if(Objects.isNull(user)) {
			 reply = PayReply.newBuilder().setDetails("Card not found").setDate("").setName("").setValue(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		toUser = bank.searchAccount(request.getHolderAcc());
		if(Objects.isNull(toUser)) {
			 reply = PayReply.newBuilder().setDetails("Holder account not found").setDate("").setName("").setValue(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(toUser.isLogged()) {
			if(user.account.pay(request.getCardNumber(), request.getPin(), request.getValue(), toUser.account)) {
				reply = PayReply.newBuilder().setDetails("Payment aproved").setName(user.getFirstName()+" "+user.getLastName()).setDate(LocalDateTime.now().toString()).setValue(request.getValue()).build();
			}else {
				reply = PayReply.newBuilder().setDetails("Payment not approved. Check with Bankify").setDate("").setName("").setValue(-1).build();
			}
		} else {
			reply = PayReply.newBuilder().setDetails("Holder not logged in").setDate("").setName("").setValue(-1).build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
}