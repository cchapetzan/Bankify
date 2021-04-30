package grpc.bank.bankify;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
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
import io.grpc.stub.StreamObserver;

public class BankifyTransactionsClient {

	private static ServiceInfo bankServiceInfo;
	
	private static final Logger logger = Logger.getLogger(BankifyTransactionsClient.class.getName());


	public static void main(String[] args) throws Exception {
		//String host = "localhost";
		//int port = 50051;
		
		String bankify_service_type = "_bankify._tcp.local.";
		discoverBankifyService(bankify_service_type);
		String host;
		int port; 
		try {
			host = bankServiceInfo.getHostAddresses()[0];
			port = bankServiceInfo.getPort();
		} catch (NullPointerException e){
			logger.info("Cannot find server");
			return;
		}
		
		System.out.println(host+" "+port);

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		BankTransactionsBlockingStub  blockingStub = BankTransactionsGrpc.newBlockingStub(channel);

		BankifyTransactionsClient client = new BankifyTransactionsClient();

	    try {
	    	 String email = "camila@camila.com";
	    	 String password = "1234";
	    	 //BankRequest request = BankRequest.newBuilder().setName(name).build();
	    	 LoginData request = LoginData.newBuilder().setEmail(email).setPassword(password).build();

	    	 LoginReply response = blockingStub.userLogin(request);

	    	 logger.info("Login Status: " + response.getLoginMessage() + " " + response.getFirstName() + response.getEmail());
	    	 
	    	 Iterator<MovementData> responseMov = blockingStub.accountMovement(request);
	    	 
	    	 while(responseMov.hasNext()) {
	    		 MovementData mov = responseMov.next();
	    		 logger.info("Movement: " + mov.getMovement());
	    	 }
	    	 
	    	 int accountNumber = 111111;
	    	 int toAccountNumber = 111112;	    	 
	    	 int pin = 123;
	    	 float value = 125;
	    	 //BankRequest request = BankRequest.newBuilder().setName(name).build();
	    	 AccountData request2 = AccountData.newBuilder().setAccountNumber(accountNumber).setPin(pin).build();

	    	 FloatReply response2 = blockingStub.getBalance(request2);
	    	 
	    	 if(response2.getBalance() == -1) {
	    		 logger.info("Balance Status: " + response2.getMessage());
	    	 } else {
	    		 logger.info("Balance Status: " + response2.getMessage() + " " + response2.getBalance());
	    	 }
	    	 
	    	 AccountTransfer request3 = AccountTransfer.newBuilder().setAccountNumber(accountNumber).setPin(pin).setToAccountNumber(toAccountNumber).setValue(value).build();

	    	 FloatReply response3 = blockingStub.transferBalance(request3);
	    	 
	    	 if(response3.getBalance() == -1) {
	    		 logger.info("Balance Status: " + response3.getMessage());
	    	 } else {
	    		 logger.info("Balance Status: " + response3.getMessage() + " " + response3.getBalance());
	    	 }
	    	 
	    	 Iterator<MovementData> responseObserver = blockingStub.accountMovement(request);
	    	 while(responseObserver.hasNext()) {
	    		 MovementData mov = responseObserver.next();
	    		 logger.info("Movement: " + mov.getMovement());
	    	 }
	    	 
	    	 LogoutData request4 = LogoutData.newBuilder().setEmail(email).build();
	    	 
	    	 BankReply response4 = blockingStub.userLogout(request4);
	    	 
	    	 logger.info("Logout Status: " + response4.getMessage());

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
