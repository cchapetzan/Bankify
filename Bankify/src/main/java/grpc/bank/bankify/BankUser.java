/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpc.bank.bankify;

/**
 *
 * @author Camila Chapetzan Antunes
 * Class BankUser
 * - object with all the data and basic methods for a bank user and social list user
 */
public class BankUser {
    BankAccount account;
    private String firstName;
    private String lastName;
    private String idCard;
    private char sex;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean logged;

    //constructor
    public BankUser(String firstName, String lastName, String idCard, char sex, String email, String password, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.account = null;
        this.logged = false;
    }
    
    //create a bank account (used for bank users only, not social list users)
    public void createBankAccount(int accountNumber, int pin){
        account = new BankAccount(0, accountNumber);
        account.setCardPin(pin);
    }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //getters
    public BankAccount getBankAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdCard() {
        return idCard;
    }

    public char getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    
    //method to find the user based on his email
    public boolean checkUserName(String email){
        return this.email.equals(email);
    }
    
    //method to validate password
    public boolean validatePassword(String password){
        return this.password.equals(password);
    }
    
    //method to check if the user is logged
    public boolean isLogged() {
    	return logged;
    }
    
    //login method with email and password
    public boolean login(String email, String password) {
    	if(checkUserName(email)&&validatePassword(password)){
    		logged = true;
    		return true;
    	} else return false;
    }
    
    //logout method
    public void logout() {
    	logged = false;
    }
    
    @Override
    public String toString() {
    	return this.firstName + " " + this.lastName + ": " + this.idCard + " - " + this.email;
    }
}
