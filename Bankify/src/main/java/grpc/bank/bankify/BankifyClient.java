package grpc.bank.bankify;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.bank.bankify.GreeterGrpc.GreeterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BankifyClient {

	private static final Logger logger = Logger.getLogger(BankifyClient.class.getName());


	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		GreeterBlockingStub  blockingStub = GreeterGrpc.newBlockingStub(channel);

	    BankifyClient client = new BankifyClient();

	    try {
	    	 //String name = "Adding User: ";
	    	 String firstName = "Britney";
	    	 String lastName = "Spears";
	    	 String id = "US123";
	    	 String gender = "F";
	    	 String email = "britney@spears.com";
	    	 String password = "321654";
	    	 int pin = 2799;
	    	 String phone = "083-1234567";
	    	 String address = "Dublin street";
	    	 //BankRequest request = BankRequest.newBuilder().setName(name).build();
	    	 NewUserData request = NewUserData.newBuilder().setFirstName(firstName).setLastName(lastName).setId(id).setGender(gender).setEmail(email).setPassword(password).setPin(pin).setPhone(phone).setAddress(address).build();

	    	 BankReply response = blockingStub.addUser(request);

	    	 logger.info("Added User: " + response.getMessage());

	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

		    return;

	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }


}
