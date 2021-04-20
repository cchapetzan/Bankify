package grpc.bank.bankify;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.bank.bankify.GreeterGrpc.GreeterImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BankifyServer extends GreeterImplBase {
	
	static Bankify bank = new Bankify();

	private static final Logger logger = Logger.getLogger(BankifyServer.class.getName());

	public static void main(String[] args) {

		BankifyServer greeterserver = new BankifyServer();
		bank.addUser("Camila", "Antunes", "123", 'M', "camila@camila.com", "1234", 123, "12345", "Street");
		bank.addUser("Paulo", "Antunes", "123", 'M', "paulo@camila.com", "1234", 123, "12345", "Street");

		int port = 50051;

		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(greeterserver)
			    .build()
			    .start();

			 server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    logger.info("Server started, listening on " + port);


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
		try {
			user = bank.searchUser(request.getEmail());
		} catch (NullPointerException e) {
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
		try {
			user = bank.searchUser(request.getEmail());
		} catch (NullPointerException e) {
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
		try {
			user = bank.searchAccount(request.getAccountNumber());
		} catch (NullPointerException e) {
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

}
