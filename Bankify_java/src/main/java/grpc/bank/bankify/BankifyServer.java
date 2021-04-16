package grpc.bank.bankify;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.bank.bankify.GreeterGrpc.GreeterImplBase;
import grpc.bank.bankify.Bankify;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BankifyServer extends GreeterImplBase {
	
	static Bankify bank = new Bankify();

	private static final Logger logger = Logger.getLogger(BankifyServer.class.getName());

	public static void main(String[] args) {

		BankifyServer greeterserver = new BankifyServer();
		bank.addUser("Camila", "Antunes", "123", 'M', "camila@camila.com", "1234", 0, "12345", "Street");

		int port = 50051;

		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(greeterserver)
			    .build()
			    .start();

			 server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    logger.info("Server started, listening on " + port);


	}

	@Override
	public void sendData(BankRequest request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving bank data request");

		 BankReply reply = BankReply.newBuilder().setMessage(request.getName() + " Bankify User: " + bank.users.get(0).toString()).build();

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}


}
