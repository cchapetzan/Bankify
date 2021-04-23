package grpc.bank.bankify;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.bank.bankify.BankSocialGrpc.BankSocialBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BankifySocialClient {

	private static final Logger logger2 = Logger.getLogger(BankifySocialClient.class.getName());


	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50052;

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		BankSocialBlockingStub  blockingStub = BankSocialGrpc.newBlockingStub(channel);

		BankifySocialClient client = new BankifySocialClient();

	    try {
	    	 //String name = "Adding User: ";
	    	 String firstName = "Britney Social";
	    	 String lastName = "Spears";
	    	 String id = "US123";
	    	 String gender = "F";
	    	 String email = "britney@spears.com";
	    	 String password = "321654";
	    	 String phone = "083-1234567";
	    	 String address = "Dublin street";
	    	 NewSocialUserData request = NewSocialUserData.newBuilder().setFirstName(firstName).setLastName(lastName).setId(id).setGender(gender).setEmail(email).setPassword(password).setPhone(phone).setAddress(address).build();

	    	 BankReply response = blockingStub.addSocialUser(request);

	    	 logger2.info("Added User: " + response.getMessage());

	    } catch (StatusRuntimeException e) {
		    logger2.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

		    return;

	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }


}