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

import grpc.bank.bankify.BankSocialGrpc.BankSocialBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

/**
*
* @author Camila Chapetzan Antunes
* Class BankifySocialClient
* - client-side implementation/test of gRPC service BankifySocial
*/
public class BankifySocialClient {
	
	private static ServiceInfo bankServiceInfo; //jmdns service info

	private static final Logger logger2 = Logger.getLogger(BankifySocialClient.class.getName());


	public static void main(String[] args) throws Exception {
		//String host = "localhost";
		//int port = 50052;
		
		//jmDNS discovery
		String bankify_service_type = "_bankify._tcp.local.";
		discoverBankifyService(bankify_service_type);
		
		String host;
		int port; 
		try { //server found
			host = bankServiceInfo.getHostAddresses()[0];
			port = bankServiceInfo.getPort();
		} catch (NullPointerException e){
			logger2.info("Cannot find server");
			return;
		}
		
		System.out.println(host+" "+port);

		//channel creating for service
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();

		//gRPC service connection
		BankSocialBlockingStub  blockingStub = BankSocialGrpc.newBlockingStub(channel);

		BankifySocialClient client = new BankifySocialClient();

		//Service test: addSocialUser
	    try {
	    	 String firstName = "Britney Social";
	    	 String lastName = "Spears";
	    	 String id = "US123";
	    	 String gender = "F";
	    	 String email = "britney@spears.com";
	    	 String password = "321654";
	    	 String phone = "083-1234567";
	    	 String address = "Dublin street";
	    	 
	    	 //gRPC method
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
	
	//method discoverBankifyService
	//this method uses jmDNS to find service host and port
	private static void discoverBankifyService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() { //ServiceListener implementation
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Bankify Service resolved: " + event.getInfo());

					bankServiceInfo = jmdns.getServiceInfo(service_type, "bankify_social"); //find service info

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