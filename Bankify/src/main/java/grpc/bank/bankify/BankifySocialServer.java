package grpc.bank.bankify;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.bank.bankify.BankSocialGrpc.BankSocialImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
*
* @author Camila Chapetzan Antunes
* Class BankifySocialServer
* - server-side implementation of gRPC service BankifySocial
*/
public class BankifySocialServer extends BankSocialImplBase {
	
	static Bankify bank;
	
	//constructor
	public void setBank(Bankify bank) {
		this.bank = bank;
	}
	
	/*
	 * gRPC method addSocialUser implementation
	 * - NewSocialUserData request: all the necessary data for social list registry
	 * message NewSocialUserData {
	 *   string firstName = 1;
  	 *   string lastName = 2;
  	 *   string id = 3;
  	 *   string gender = 4;
  	 *   string email = 5;
  	 *   string password = 6;
  	 *   string phone = 8;
  	 *   string address = 9;
  	 * }
  	 * - BankReply response: message with added user confirmation
  	 * 
	 */
	@Override
	public void addSocialUser(NewSocialUserData request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving add social user request");
		
		//internal method addSocial for registry
		bank.addSocial(request.getFirstName(), request.getLastName(), request.getId(), request.getGender().charAt(0), request.getEmail(), request.getPassword(), request.getPhone(), request.getAddress());

		 BankReply reply = BankReply.newBuilder().setMessage("New Bankify Social List User: " + bank.socialList.get(bank.socialList.size()-1).toString()).build();

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
			System.out.println("add social user request completed");
	}


}
