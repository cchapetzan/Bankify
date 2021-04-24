package grpc.bank.bankify;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import grpc.bank.bankify.BankTransactionsGrpc.BankTransactionsBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BankifyClientTransactions {
	
	private static ServiceInfo bankServiceInfo;

	private static final Logger logger = Logger.getLogger(BankifyClientTransactions.class.getName());


	public static void main(String[] args) throws Exception {
		//String host = "localhost";
		//int port = 50051;
		
		String bankify_service_type = "_bankify._tcp.local.";
		discoverBankifyService(bankify_service_type);
		
		String host = bankServiceInfo.getHostAddresses()[0];
		int port = bankServiceInfo.getPort();
		
		System.out.println(host+" "+port);

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		BankTransactionsBlockingStub  blockingStub = BankTransactionsGrpc.newBlockingStub(channel);

	    BankifyClientTransactions client = new BankifyClientTransactions();

	    try {
	    	 int accountNumber = 111111;
	    	 int toAccountNumber = 111112;	    	 
	    	 int pin = 123;
	    	 float value = 125;
	    	 //BankRequest request = BankRequest.newBuilder().setName(name).build();
	    	 AccountData request = AccountData.newBuilder().setAccountNumber(accountNumber).setPin(pin).build();

	    	 FloatReply response = blockingStub.getBalance(request);
	    	 
	    	 if(response.getBalance() == -1) {
	    		 logger.info("Balance Status: " + response.getMessage());
	    	 } else {
	    		 logger.info("Balance Status: " + response.getMessage() + " " + response.getBalance());
	    	 }
	    	 
	    	 AccountTransfer request2 = AccountTransfer.newBuilder().setAccountNumber(accountNumber).setPin(pin).setToAccountNumber(toAccountNumber).setValue(value).build();

	    	 FloatReply response2 = blockingStub.transferBalance(request2);
	    	 
	    	 if(response2.getBalance() == -1) {
	    		 logger.info("Balance Status: " + response2.getMessage());
	    	 } else {
	    		 logger.info("Balance Status: " + response2.getMessage() + " " + response2.getBalance());
	    	 }

	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

		    return;

	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }

	private static void discoverBankifyService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Bankify Service resolved: " + event.getInfo());

					bankServiceInfo = jmdns.getServiceInfo(service_type, "bankify_transactions");

					int port = bankServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + bankServiceInfo.getNiceTextString());
					System.out.println("\t host: " + bankServiceInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Bank Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Bank Service added: " + event.getInfo());

					
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
