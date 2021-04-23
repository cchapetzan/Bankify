package grpc.bank.bankify;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

import grpc.bank.bankify.BankTransactionsGrpc.BankTransactionsImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BankifyTransactionsServer extends BankTransactionsImplBase {
	
	static Bankify bank;
	
	public void setBank(Bankify bank) {
		this.bank = bank;
	}

	@Override
	public void sendData(BankRequest request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving bank data request");

		 BankReply reply = BankReply.newBuilder().setMessage(request.getName() + " Bankify User: " + bank.users.get(0).toString()).build();

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	@Override
	public void addUser(NewUserData request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving add user request");
		
		bank.addUser(request.getFirstName(), request.getLastName(), request.getId(), request.getGender().charAt(0), request.getEmail(), request.getPassword(), request.getPin(), request.getPhone(), request.getAddress());

		 BankReply reply = BankReply.newBuilder().setMessage("New Bankify User: " + bank.users.get(bank.users.size()-1).toString()).build();

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	@Override
	public void userLogin(LoginData request,  StreamObserver<LoginReply> responseObserver) {

		System.out.println("receiving login request");
		BankUser user;
		LoginReply reply;
		user = bank.searchUser(request.getEmail());
		if(Objects.isNull(user)) {
			 reply = LoginReply.newBuilder().setLoginMessage("Bank User not found").setFirstName("").build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.login(request.getEmail(), request.getPassword())) {		
			reply = LoginReply.newBuilder().setLoginMessage("User is logged in:").setFirstName(user.getFirstName()).setEmail(user.getEmail()).build();
		} else {
			reply = LoginReply.newBuilder().setLoginMessage("Password missmatch").setFirstName("").setEmail("").build();
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
	public void getBalance(AccountData request,  StreamObserver<FloatReply> responseObserver) {

		System.out.println("receiving balance request");
		BankUser user;
		FloatReply reply;
		user = bank.searchAccount(request.getAccountNumber());
		if(Objects.isNull(user)) {
			 reply = FloatReply.newBuilder().setMessage("Bank User not found").setBalance(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.isLogged()) {
			if(user.account.validateAccountTransaction(request.getPin())) {
				reply = FloatReply.newBuilder().setMessage("Account verified. Your balance is: ").setBalance(user.account.getBalance()).build();
			}else {
				reply = FloatReply.newBuilder().setMessage("Your pin is incorrect. Try again").setBalance(-1).build();
			}
		} else {
			reply = FloatReply.newBuilder().setMessage("User not logged in").setBalance(-1).build();
		}

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	@Override
	public void transferBalance(AccountTransfer request,  StreamObserver<FloatReply> responseObserver) {

		System.out.println("receiving transfer request");
		BankUser user;
		BankUser toUser;
		FloatReply reply;
		user = bank.searchAccount(request.getAccountNumber());
		if(Objects.isNull(user)) {
			 reply = FloatReply.newBuilder().setMessage("Bank User not found").setBalance(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		toUser = bank.searchAccount(request.getToAccountNumber());
		if(Objects.isNull(toUser)) {
			 reply = FloatReply.newBuilder().setMessage("Destination bank account not found").setBalance(-1).build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		//System.out.println(user.account.getBalance() + " " + toUser.account.getBalance());
		
		if(user.isLogged()) {
			if(user.account.transfer(request.getPin(), toUser.account, request.getValue())) {
				reply = FloatReply.newBuilder().setMessage("Value transfered successfully. Your balance is: ").setBalance(user.account.getBalance()).build();
			}else {
				reply = FloatReply.newBuilder().setMessage("Your pin is incorrect or you don't have balance.").setBalance(-1).build();
			}
		} else {
			reply = FloatReply.newBuilder().setMessage("User not logged in").setBalance(-1).build();
		}
		
		//System.out.println(user.account.getBalance() + " " + toUser.account.getBalance());

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	@Override
	public void accountMovement(LoginData request,  StreamObserver<MovementData> responseObserver) {

		System.out.println("receiving movement request");
		BankUser user;
		MovementData reply;
		user = bank.searchUser(request.getEmail());
		if(Objects.isNull(user)) {
			 reply = MovementData.newBuilder().setMovement("Bank User not found").build();

			 responseObserver.onNext(reply);

		     responseObserver.onCompleted();
		     
		     return;
		}
		
		if(user.isLogged()) {
			for(AccountMovement mov: user.account.getHistory()) {
				reply = MovementData.newBuilder().setMovement(mov.toString()).build();
				responseObserver.onNext(reply);
			}
		} else {
			reply = MovementData.newBuilder().setMovement("User not logged in").build();
		}

	     responseObserver.onCompleted();
	}

}
