package grpc.bank.bankify;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.bank.bankify.BankPayGrpc.BankPayBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BankifyPayClient {

	private static final Logger logger = Logger.getLogger(BankifyPayClient.class.getName());


	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50053;

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		BankPayBlockingStub  blockingStub = BankPayGrpc.newBlockingStub(channel);

		BankifyPayClient client = new BankifyPayClient();

	    try {
	    	 String email = "mister@business.ie";
	    	 String password = "1234";
	    	 String card = "4321-2345";
	    	 int pin = 123;
	    	 int holderAcc;
	    	 float value = 130;
	    	 LoginData request = LoginData.newBuilder().setEmail(email).setPassword(password).build();

	    	 LoginPayReply response = blockingStub.holderLogin(request);

	    	 logger.info("Login Status: " + response.getLoginMessage() + " " + response.getFirstName() + " " +  response.getAccountNumber());
	    	 
	    	 holderAcc = response.getAccountNumber();
	    	 
	    	 PayRequest request2 = PayRequest.newBuilder().setCardNumber(card).setPin(pin).setHolderAcc(holderAcc).setValue(value).build();
	    	 
	    	 PayReply response2 = blockingStub.pay(request2);
	    	 
	    	 if(response2.getValue() == -1) {
	    		 logger.info("Payment Status: " + response2.getDetails());
	    	 } else {
	    		 logger.info("Balance Status: " + response2.getDetails() + " " + response2.getDate() + " " + response2.getName() + " " + response2.getValue());
	    	 }
	    			 
	    	 LogoutData request3 = LogoutData.newBuilder().setEmail(email).build();
	    	 
	    	 BankReply response3 = blockingStub.userLogout(request3);
	    	 
	    	 logger.info("Logout Status: " + response3.getMessage());

	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

		    return;

	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }


}
