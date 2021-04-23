package grpc.bank.bankify;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class BankifyGeneralServer {
	
	static Bankify bank = new Bankify();

	private static final Logger logger = Logger.getLogger(BankifyTransactionsServer.class.getName());
	private static final Logger logger2 = Logger.getLogger(BankifySocialServer.class.getName());
	
	public static void main(String[] args) {

		bank.addUser("Camila", "Antunes", "123", 'F', "camila@camila.com", "1234", 123, "12345", "Street");
		bank.addUser("Paulo", "Antunes", "123", 'M', "paulo@camila.com", "1234", 123, "12345", "Street");
		bank.addUser("Mister", "Entrepeneur", "45678", 'M', "mister@business.ie", "1234", 123, "083456", "Avenue");
		bank.users.get(0).account.deposit(250);
		bank.users.get(0).account.deposit(3000);
		bank.users.get(0).account.setCardNumber("4321-2345");
		BankifyTransactionsServer bankTransactionsServer = new BankifyTransactionsServer();
		bankTransactionsServer.setBank(bank);
		BankifySocialServer bankSocialServer = new BankifySocialServer();
		bankSocialServer.setBank(bank);
		BankifyPayServer bankPayServer = new BankifyPayServer();
		bankPayServer.setBank(bank);

		int port = 50051;
		int port2 = 50052;
		int port3 = 50053;

		try {
			Server server = ServerBuilder.forPort(port)
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

			server.awaitTermination();
			server2.awaitTermination();
			server3.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    logger.info("Server started, listening on " + port);
	    logger2.info("Server started, listening on " + port2);


	}

}
