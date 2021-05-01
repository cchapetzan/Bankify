package grpc.bank.bankify;


/**
*
* @author Camila Chapetzan Antunes
* Class PaymentTransaction
* - object with all the data for a PaymentTransaction
*/
public class PaymentTransaction {
	private String cardPay;
	private int toAccount;
	private String date;
	private float value;
	
	//constructor
	public PaymentTransaction(String cardPay, int toAccount, String date, float value) {
		super();
		this.cardPay = cardPay;
		this.toAccount = toAccount;
		this.date = date;
		this.value = value;
	}

	//getters
	public String getCardPay() {
		return cardPay;
	}

	public int getToAccount() {
		return toAccount;
	}

	public String getDate() {
		return date;
	}

	public float getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "PaymentTransaction [Card=" + cardPay + ", toAccount=" + toAccount + ", date=" + date + ", value="
				+ value + "]";
	}
	
	
}
