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
* Class PaymentTransaction
* - main bankify object with all the transaction methods and data structures
*/
public class Bankify {
    ArrayList<BankUser> users;
    ArrayList<BankUser> socialList;
    ArrayList<PaymentTransaction> paymentHistory;

    //constructor
    public Bankify() {
        this.users = new ArrayList<>();
        this.socialList = new ArrayList<>();
        this.paymentHistory = new ArrayList<>();
    }
    
    //addSocial method to add a person to the social list
    public void addSocial(String firstName, String lastName, String idCard, char sex, String email, String password, String phone, String address){
        socialList.add(new BankUser(firstName, lastName, idCard, sex, email, password, phone, address));
    }
    
  //addUser method to add a person to the bank users
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
    
    //addUser method version for mock data filling
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
    
    //addPaymentHistory method to add a transaction to the bank general transactions history
    public void addPaymentHistory(String cardPay, int toAccount, String date, float value) {
    	paymentHistory.add(new PaymentTransaction(cardPay, toAccount, date, value));
    }
    
    //searchUser method to search a user by his username (email)
    public BankUser searchUser(String username){
    	for(BankUser user: users) {
    		if (user.checkUserName(username))
    			return user;
    	}
		return null;
    }
    
  //searchAccount method to search a user by his account number
    public BankUser searchAccount(int accountNumber){
    	for(BankUser user: users) {
    		if (user.account.checkAccountNumber(accountNumber))
    			return user;
    	}
		return null;
    }
    
  //searchCard method to search a user by his card number
    public BankUser searchCard(String card){
    	for(BankUser user: users) {
    		if (user.account.getCardNumber().equals(card))
    			return user;
    	}
		return null;
    }
    
    //mock data filling
    public void mockData() {
		addUser("Camila", "Antunes", "123abc", 'F', "camila@camila.com", "12345678", 1234, "12345", "Street", 3250, 0);
		users.get(0).account.setCardNumber("4321-2345");
		addUser("Paulo", "Antunes", "12rft3", 'M', "paulo@camila.com", "12341234", 4321, "12345", "Street", 300, 0);
		users.get(1).account.setCardNumber("1112-9876");
		addUser("Mister", "Entrepeneur", "45w678", 'M', "mister@business.ie", "abcdefgh", 8877, "083456", "Avenue", 2345, 0);
		users.get(2).account.setCardNumber("6578-6789");
		addUser("Thiago", "Ramalho", "456y78", 'M', "thiago@ramalho.br", "d4f5g6h7", 9988, "3424578", "Street", 788, 0);
		addUser("Brendan", "Fraser", "US1234", 'M', "brendan@holy.com", "87654321", 4444, "12345", "Avenue", 99977, 0);
		users.get(4).account.setCardNumber("9988-7766");
		addUser("Larissa", "Manuela", "BR123", 'F', "lari@love.com", "00000000", 5555, "42265583", "Street", 123, 0);
		addUser("Britney", "Avow", "EU34567", 'F', "avow@rte.ie", "meunome1", 1674, "2755978", "Avenue", 6543, 0);
		addUser("Kesha", "Liver", "UK34567", 'F', "kesha@liver.pool", "papai123", 1876, "98789635", "Avenue", 6789, 0);
		users.get(7).account.setCardNumber("4567-3245");
		addUser("Cassi", "Gauss", "34587it", 'F', "gauss@earth.ie", "bownamao", 9911, "2145698", "Dublin", 10000, 0);
		addUser("Sunny", "Garcia", "IN9876", 'M', "sunny@estate.ie", "loveJava", 3456, "5896321", "Street", 100, 0);
		users.get(9).account.setCardNumber("8721-6789");
		addSocial("Carmela", "Carcia", "EU11117", 'F', "carm@social.ie", "qwertyui", "7564231", "Village");
		addSocial("Uolov", "Mold", "MO11117", 'F', "uo@social.ie", "34567890", "2589231", "Village");
		addSocial("Rafaela", "Tacos", "MX1589", 'F', "tacos@social.ie", "clever12", "222224231", "Village");
		users.get(0).account.deposit(250);
		users.get(0).account.transfer(1234, users.get(3).account, 345);
		users.get(0).account.deposit(3000);
		users.get(0).account.transfer(1234, users.get(4).account, 65);
		users.get(1).account.deposit(350);
		users.get(2).account.deposit(675);
		users.get(3).account.transfer(9988, users.get(0).account, 65);
		users.get(5).account.deposit(111);
		users.get(6).account.transfer(1674, users.get(7).account, 10);
		users.get(8).account.deposit(55);
		users.get(9).account.transfer(3456, users.get(3).account, 65);
		

    }
    
}
