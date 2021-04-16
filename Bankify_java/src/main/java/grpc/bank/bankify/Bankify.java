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
    List<BankUser> users;
    Stack<BankUser> socialList;

    public Bankify() {
        this.users = new ArrayList<>();
        this.socialList = new Stack<>();
    }
    
    public void addSocial(String firstName, String lastName, String idCard, char sex, String email, String password, String phone, String address){
        socialList.add(new BankUser(firstName, lastName, idCard, sex, email, password, phone, address));
    }
    
    public void addUser(String firstName, String lastName, String idCard, char sex, String email, String password, int pin, String phone, String address){
        int accNumber;
        if(users.isEmpty()) accNumber = 111111;
        else accNumber = 1 + users.get(users.size()-1).account.getAccountNumber();
        BankUser temp = new BankUser(firstName, lastName, idCard, sex, email, password, phone, address);
        temp.createBankAccount(accNumber, pin);
        users.add(temp);
    }
    
    
    
    
}
