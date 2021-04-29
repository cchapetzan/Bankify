package grpc.bank.bankify;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.bank.bankify.BankSocialGrpc.BankSocialImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BankifySocialServer extends BankSocialImplBase {
	
	static Bankify bank;
	
	public void setBank(Bankify bank) {
		this.bank = bank;
	}

	@Override
	public void sendData(BankRequest request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving bank data request");

		 BankReply reply = BankReply.newBuilder().setMessage(request.getName() + " Bankify User: " + bank.users.get(0).toString()).build();

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
	}
	
	@Override
	public void addSocialUser(NewSocialUserData request,  StreamObserver<BankReply> responseObserver) {

		System.out.println("receiving add social user request");
		
		bank.addSocial(request.getFirstName(), request.getLastName(), request.getId(), request.getGender().charAt(0), request.getEmail(), request.getPassword(), request.getPhone(), request.getAddress());

		 BankReply reply = BankReply.newBuilder().setMessage("New Bankify Social List User: " + bank.socialList.get(bank.socialList.size()-1).toString()).build();

		 responseObserver.onNext(reply);

	     responseObserver.onCompleted();
			System.out.println("add social user request completed");
	}


}
