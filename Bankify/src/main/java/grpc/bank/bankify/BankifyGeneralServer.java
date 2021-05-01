package grpc.bank.bankify;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
*
* @author Camila Chapetzan Antunes
* Class BankifyGeneralServer - Bank general server for all 3 gRPC services
* - create bankify data
* - create servers for each service
* - get services properties from internal configuration file
* - register servers on jmDNS instance
* - start servers 
*/
public class BankifyGeneralServer {
	
	static Bankify bank = new Bankify();

	//loggers for each service
	private static final Logger logger = Logger.getLogger(BankifyTransactionsServer.class.getName());
	private static final Logger logger2 = Logger.getLogger(BankifySocialServer.class.getName());
	private static final Logger logger3 = Logger.getLogger(BankifyPayServer.class.getName());
	
	public static void main(String[] args) {
		
		//bank mock data
		bank.mockData();
		
		//create servers, one for each service
		BankifyTransactionsServer bankTransactionsServer = new BankifyTransactionsServer();
		bankTransactionsServer.setBank(bank);
		BankifySocialServer bankSocialServer = new BankifySocialServer();
		bankSocialServer.setBank(bank);
		BankifyPayServer bankPayServer = new BankifyPayServer();
		bankPayServer.setBank(bank);
		
		//get services properties from internal configuration file
		Properties prop = getProperties();
		
		//register servers on jmDNS instance
		registerService(prop);

		//get ports of all services
		int port1 = Integer.valueOf(prop.getProperty("service1_port") );// #.50051;
		int port2 = Integer.valueOf( prop.getProperty("service2_port") );// #.50052;
		int port3 = Integer.valueOf( prop.getProperty("service3_port") );// #.50053;

		//start servers
		try {
			Server server1 = ServerBuilder.forPort(port1)
			    .addService(bankTransactionsServer)
			    .build()
			    .start();
			 
			Server server2 = ServerBuilder.forPort(port2)
				 .addService(bankSocialServer)
				 .build()
				 .start();
			Server server3 = ServerBuilder.forPort(port3)
				 .addService(bankPayServer)
				 .build()
				 .start();

			System.out.println("All services started");
			
			//wait for clients
			server1.awaitTermination();
			server2.awaitTermination();
			server3.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    logger.info("Server started, listening on " + port1);
	    logger2.info("Server started, listening on " + port2);
	    logger3.info("Server started, listening on " + port3);


	}
	
	//method getProperties
	//this method will get services properties from internal file
	private static Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/bankify.properties")) { //load file

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);//properties loaded from input

	            // get the property value and print it out
	            System.out.println("Bankify Service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service1_name: " +prop.getProperty("service1_name"));
	            System.out.println("\t service1_description: " +prop.getProperty("service1_description"));
		        System.out.println("\t service1_port: " +prop.getProperty("service1_port"));
		        System.out.println("\t service2_name: " +prop.getProperty("service2_name"));
	            System.out.println("\t service2_description: " +prop.getProperty("service2_description"));
		        System.out.println("\t service2_port: " +prop.getProperty("service2_port"));
		        System.out.println("\t service3_name: " +prop.getProperty("service3_name"));
	            System.out.println("\t service3_description: " +prop.getProperty("service3_description"));
		        System.out.println("\t service3_port: " +prop.getProperty("service3_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}
	
	//method registerService
	//this method will register all servers in a jmDNS instance
	private static void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            //services properties
	            String service_type = prop.getProperty("service_type");//"_http._tcp.local.";
	            String service1_name = prop.getProperty("service1_name");
	            int service1_port = Integer.valueOf( prop.getProperty("service1_port") );// #.50051;
	            String service2_name = prop.getProperty("service2_name");
	            int service2_port = Integer.valueOf( prop.getProperty("service2_port") );// #.50052;
	            String service3_name = prop.getProperty("service3_name");
	            int service3_port = Integer.valueOf( prop.getProperty("service3_port") );// #.50053;

	            //services descriptions
	            String service1_description_properties = prop.getProperty("service1_description");
	            String service2_description_properties = prop.getProperty("service2_description");
	            String service3_description_properties = prop.getProperty("service3_description");
	            
	            // Register services
	            ServiceInfo service1Info = ServiceInfo.create(service_type, service1_name, service1_port, service1_description_properties);
	            ServiceInfo service2Info = ServiceInfo.create(service_type, service2_name, service2_port, service2_description_properties);
	            ServiceInfo service3Info = ServiceInfo.create(service_type, service3_name, service3_port, service3_description_properties);
	            jmdns.registerService(service1Info);
	            jmdns.registerService(service2Info);
	            jmdns.registerService(service3Info);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service1_name);
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service2_name);
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service3_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}

}
