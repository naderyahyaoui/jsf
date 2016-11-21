package tn.esprit.bean;

public class CreditCard {
	private String cardHolderName;
	private String cardNumber;
	private int cardExpMonth;
	private int cardExpYear;
	private int cardCvc;

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCardExpMonth() {
		return cardExpMonth;
	}

	public void setCardExpMonth(int cardExpMonth) {
		this.cardExpMonth = cardExpMonth;
	}

	public int getCardExpYear() {
		return cardExpYear;
	}

	public void setCardExpYear(int cardExpYear) {
		this.cardExpYear = cardExpYear;
	}

	public int getCardCvc() {
		return cardCvc;
	}

	public void setCardCvc(int cardCvc) {
		this.cardCvc = cardCvc;
	}
}