package com.akshu.pizzaApplication;

public class UserBean 
{
	private String name;
	private String crust;
	private String toppings[];
	private String appetizer;
	private String address ;
	private String cardType ;
	private String cardNumber;
	
	public String[] getToppings() {
		return toppings;
	}
	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	
	public String getAppetizer() {
		return appetizer;
	}
	public void setAppetizer(String appetizer) {
		this.appetizer = appetizer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) 
	{
		this.cardNumber = cardNumber;
	}
	
}
