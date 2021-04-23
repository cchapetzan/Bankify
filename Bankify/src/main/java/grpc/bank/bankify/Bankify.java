/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpc.bank.bankify;

import java.util.*;

/**
 *
 * @author Camila Chapetzan Antunes
 */
public class Bankify {
    ArrayList<BankUser> users;
    ArrayList<BankUser> socialList;
    ArrayList<PaymentTransaction> paymentHistory;

    public Bankify() {
        this.users = new ArrayList<>();
        this.socialList = new ArrayList<>();
        this.paymentHistory = new ArrayList<>();
    }
    
    public void addSocial(String firstName, String lastName, String idCard, char sex, String email, String password, String phone, String address){
        socialList.add(new BankUser(firstName, lastName, idCard, sex, email, password, phone, address));
    }
    
    public void addUser(String firstName, String lastName, String idCard, char sex, String email, String password, int pin, String phone, String address){
        int accNumber;
        if(users.isEmpty()) accNumber = 111111;
        else accNumber = 1 + users.get(users.size()-1).account.getAccountNumber();
        if(!socialList.isEmpty()) {
        	BankUser social = socialList.remove(0);
        	social.createBankAccount(accNumber, 1234);
        	social.account.setAccountType(1);
        	social.account.deposit(100);
        	users.add(social);
        	accNumber++;
        }
        BankUser temp = new BankUser(firstName, lastName, idCard, sex, email, password, phone, address);
        temp.createBankAccount(accNumber, pin);
        temp.account.deposit(100); //initial credit for new accounts
        users.add(temp);
    }
    
    //addUser method for mock data csv data filling
    public void addUser(String firstName, String lastName, String idCard, char sex, String email, String password, int pin, String phone, String address, float value, int accType){
        int accNumber;
        if(users.isEmpty()) accNumber = 111111;
        else accNumber = 1 + users.get(users.size()-1).account.getAccountNumber();
        BankUser temp = new BankUser(firstName, lastName, idCard, sex, email, password, phone, address);
        temp.createBankAccount(accNumber, pin);
        temp.account.setAccountType(accType);
        temp.account.deposit(value);
        users.add(temp);
    }
    
    public void addPaymentHistory(String cardPay, int toAccount, String date, float value) {
    	paymentHistory.add(new PaymentTransaction(cardPay, toAccount, date, value));
    }
    
    public BankUser searchUser(String username){
    	for(BankUser user: users) {
    		if (user.checkUserName(username))
    			return user;
    	}
		return null;
    }
    
    public BankUser searchAccount(int accountNumber){
    	for(BankUser user: users) {
    		if (user.account.checkAccountNumber(accountNumber))
    			return user;
    	}
		return null;
    }
    
    public BankUser searchCard(String card){
    	for(BankUser user: users) {
    		if (user.account.getCardNumber().equals(card))
    			return user;
    	}
		return null;
    }
    
}
