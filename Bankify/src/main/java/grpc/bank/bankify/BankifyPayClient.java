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

import grpc.bank.bankify.BankPayGrpc.BankPayBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BankifyPayClient {
	
	private static ServiceInfo bankServiceInfo;

	private static final Logger logger = Logger.getLogger(BankifyPayClient.class.getName());


	public static void main(String[] args) throws Exception {
		//String host = "localhost";
		//int port = 50053;

		String bankify_service_type = "_bankify._tcp.local.";
		discoverBankifyService(bankify_service_type);
		
		String host = bankServiceInfo.getHostAddresses()[0];
		int port = bankServiceInfo.getPort();
		
		System.out.println(host+" "+port);
		
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

	private static void discoverBankifyService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Bankify Service resolved: " + event.getInfo());

					bankServiceInfo = jmdns.getServiceInfo(service_type, "bankify_pay");

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
