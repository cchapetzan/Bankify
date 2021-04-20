package grpc.bank.bankify;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.bank.bankify.GreeterGrpc.GreeterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BankifyClientTransactions {

	private static final Logger logger = Logger.getLogger(BankifyClientTransactions.class.getName());


	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		GreeterBlockingStub  blockingStub = GreeterGrpc.newBlockingStub(channel);

	    BankifyClientTransactions client = new BankifyClientTransactions();

	    try {
	    	 int accountNumber = 111111;
	    	 int pin = 123;
	    	 //BankRequest request = BankRequest.newBuilder().setName(name).build();
	    	 AccountData request = AccountData.newBuilder().setAccountNumber(accountNumber).setPin(pin).build();

	    	 FloatReply response = blockingStub.getBalance(request);
	    	 
	    	 if(response.getBalance() == -1) {
	    		 logger.info("Balance Status: " + response.getMessage());
	    	 } else {
	    		 logger.info("Balance Status: " + response.getMessage() + " " + response.getBalance());
	    	 }

	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

		    return;

	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }


}
