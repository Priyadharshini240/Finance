package personal_Finance_and_Budgettracker;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ====== OTP Login Section ======
        System.out.println("===== Welcome to Personal Finance Tracker =====");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Random rand = new Random();
        int otp = 1000 + rand.nextInt(9000);

        System.out.println("Sending OTP to your registered mobile number...");
        System.out.println("👉 Your OTP is: " + otp);  // In real-world, OTP would be sent via SMS/Email

        System.out.print("Enter the OTP to continue: ");
        int enteredOtp = scanner.nextInt();
        scanner.nextLine(); // clear newline

        if (enteredOtp != otp) {
            System.out.println("❌ Invalid OTP. Access denied.");
            return;
        }

        System.out.println("✅ Login Successful! Hello, " + name + "!\n");

        // ====== Setup Budget and Tracker ======
        System.out.print("Enter your monthly budget limit: ₹");
        double userBudget = scanner.nextDouble();
        scanner.nextLine(); // clear newline

        BudgetManager budget = new BudgetManager(userBudget);
        SavingsTracker savings = new SavingsTracker();

        // ====== Main Menu ======
        while (true) {
            System.out.println("\n=== Personal Finance Tracker ===");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Check Savings");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter income amount: ₹");
                    double income = scanner.nextDouble();
                    scanner.nextLine();

                    if (income <= 0) {
                        System.out.println("⚠️ Income must be greater than ₹0.");
                        break;
                    }

                    savings.addIncome(income);
                    System.out.println("✅ Income added successfully.");
                    break;

                case 2:
                    System.out.print("Enter expense description (e.g. food, rent, etc.): ");
                    String description = scanner.nextLine();

                    System.out.print("Enter amount: ₹");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (amount <= 0) {
                        System.out.println("⚠️ Expense must be greater than ₹0.");
                        break;
                    }

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    budget.addExpense(date, description, amount);
                    savings.calculateSavings(budget.getTotalExpense());
                    System.out.println("✅ Expense added successfully.");
                    break;

                case 3:
                    budget.displayExpense();
                    break;

                case 4:
                    savings.calculateSavings(budget.getTotalExpense());
                    break;

                case 5:
                    System.out.println("👋 Exiting Finance Tracker... Goodbye, " + name + "!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}
