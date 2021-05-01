package grpc.bank.bankify;

import java.time.LocalDateTime;

/**
*
* @author Camila Chapetzan Antunes
* Class AccountMovement
* - object with all the data for an account movement
*/
public class AccountMovement {
	private int id;
	private String description;
	private LocalDateTime date;
	private float value;
	
	//constructor
	public AccountMovement(int id, String description, float value) {
		this.id = id;
		this.description = description;
		this.date = LocalDateTime.now();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction " + id + ": " + date + ", " + description + ", " + value
				+ " euros";
	}

	//getters
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public String getDate() {
		return date.toString();
	}

	public float getValue() {
		return value;
	}
	
}

