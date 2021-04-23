/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpc.bank.bankify;

import java.util.ArrayList;

/**
 *
 * @author Camila Chapetzan Antunes
 */
public class BankAccount {
    private float balance;
    private String cardNumber;
    private int cardPin;
    private int accountType;
    private int accountNumber;
    private ArrayList<AccountMovement> history;

    public BankAccount(int accountType, int accountNumber) {
        this.balance = 0;
        this.cardNumber = "";
        this.cardPin = 0;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.history = new ArrayList<AccountMovement>();
    }

    public float getBalance() {
        return balance;
    }
    
    public void deposit(float amount){
        balance += amount;
        history.add(new AccountMovement(history.size()+1, "Deposit", amount));
    }
    
    public void withdraw(float amount){
        balance -= amount;
        history.add(new AccountMovement(history.size()+1, "Withdraw", amount*-1));
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPin(int cardPin) {
        this.cardPin = cardPin;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
    public boolean checkAccountNumber(int number){
        return (accountNumber == number);
    }
    
    public boolean validateAccountTransaction(int pin) {
        return (cardPin == pin);
    }
    
    public boolean validateCardTransaction(String card, int pin) {
        return (cardPin == pin) && cardNumber.equals(card);
    }
    
    public void pay (float amount) {
        balance -= amount;
    	history.add(new AccountMovement(history.size()+1, "Payment", amount*-1));
    }
    
    public boolean pay(String card, int pin, float amount, BankAccount acc){
        if(validateCardTransaction(card, pin) && balance >= amount){
            pay(amount);
            acc.deposit(amount);
            return true;
        }
        else return false;
    }
    
    public boolean transfer(int pin, BankAccount acc, float amount){
        if(validateAccountTransaction(pin) && balance >= amount){
            withdraw(amount);
            acc.deposit(amount);
            return true;
        }
        else return false;
    }
    
    public ArrayList<AccountMovement> getHistory(){
    	return history;
    }
    
}
