package personal_Finance_and_Budgettracker;

import java.util.Scanner;

public class Transaction {

	private String type;
	private String date;
	private String description;
	private double amount;
	
	//constructor
	public Transaction(String type,String date,String description,double amount) {
		
		this.type=type;
		this.date=date;
		this.description=description;
		this.amount=amount;
		
	}
	
	//getter method
	
	public String getType() {
		return type;
	}

	public String getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	
	
	
	
}
