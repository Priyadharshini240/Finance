package personal_Finance_and_Budgettracker;

public class SavingsTracker {

	private double totalIncome=0;
	private double savings=0;
	
	//just add amount in Income
	public void addIncome(double amount) {
		totalIncome +=amount;
		System.out.println("Added Income is : "+amount);
	}
	
	//display the savings
	public void calculateSavings(double expense) {
		savings=totalIncome-expense;
		System.out.println("Total  Savings is : $"+savings);
	} 
	

}
