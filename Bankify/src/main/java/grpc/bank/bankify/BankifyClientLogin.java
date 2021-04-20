package grpc.bank.bankify;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.bank.bankify.GreeterGrpc.GreeterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BankifyClientLogin {

	private static final Logger logger = Logger.getLogger(BankifyClientLogin.class.getName());


	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		GreeterBlockingStub  blockingStub = GreeterGrpc.newBlockingStub(channel);

	    BankifyClientLogin client = new BankifyClientLogin();

	    try {
	    	 String email = "camila@camila.com";
	    	 String password = "1234";
	    	 //BankRequest request = BankRequest.newBuilder().setName(name).build();
	    	 LoginData request = LoginData.newBuilder().setEmail(email).setPassword(password).build();

	    	 LoginReply response = blockingStub.userLogin(request);

	    	 logger.info("Login Status: " + response.getLoginMessage() + " " + response.getFirstName() + response.getEmail());
	    	 
	    	 //LogoutData request2 = LogoutData.newBuilder().setEmail(email).build();
	    	 
	    	 //BankReply response2 = blockingStub.userLogout(request2);
	    	 
	    	 //logger.info("Logout Status: " + response2.getMessage());

	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

		    return;

	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }


}
