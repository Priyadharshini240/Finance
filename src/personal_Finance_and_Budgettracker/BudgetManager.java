package personal_Finance_and_Budgettracker;

import java.util.ArrayList;

public class BudgetManager {

	private double Budgetlimit;
	private double totalExpense;
	private ArrayList<Transaction> trans=new ArrayList<>();
	
	//getter methods
	
	public double getTotalExpense() {
		return totalExpense;
	}
	
	//Constructor
	public BudgetManager(double Budgetlimit) {
		this.Budgetlimit=Budgetlimit;
	}
	
	//Add the expense values
	public void addExpense(String date,String description,double amount) {
		trans.add(new Transaction("Expense",date,description,amount));
		this.totalExpense +=amount;
		checkBudget();
		
	}
	public void checkBudget() {
		if(totalExpense>Budgetlimit) {
			System.out.println("Warning : You have exceed your budget limit !...");
		}
		else {
			System.out.println("Remaining of BudgetLimit is : "+(Budgetlimit-totalExpense));
		}
	}
	
	//Display Expense Summary
	public void displayExpense() {
		System.out.println("The Expense Summary : ");
		for(Transaction t : trans) {
			System.out.println(t.getDate()+" - $"+t.getAmount()+"("+t.getDescription()+")");
		}
	}
	
	
}
