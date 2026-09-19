import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BankAccount implements Account{
    Scanner scan = new Scanner(System.in);

    // "accountCount" is static to keep track of all the initialized accounts
    static int accountCount = 0;
    // "accountNum" shows the account number
    int accountNum;
    double balance;

    //Constructor
    public BankAccount(double balanceAmt){
        balance = balanceAmt;
        accountCount++;
        accountNum = accountCount;
    }

    @Override
    // Deposit method
    public void deposit() {
        double amount;
        boolean isNotNum = true;

        // Loops until a number is typed in
        do{
            try{
                // Loops until a valid number is typed in
                do{
                    System.out.print("Enter the amount you would like to deposit: $");
                    amount = scan.nextDouble();

                    if (amount < 0){
                        System.out.println("Must enter a valid amount!");
                    }
                }
                while (amount < 0);

                balance += amount;
                System.out.println("$" + amount + " has been deposited to account #" + accountNum);
                isNotNum = false;
            }

            catch (InputMismatchException e){
                System.out.println("Must enter a number!");
                scan.nextLine(); // Removes invalid input
            }
        }
        while (isNotNum);
    }

    @Override
    // Withdraw Method
    public void withdraw() {
        double amount;
        boolean isNotNum = true;

        do{
            try{
                // Loops until valid amount is entered
                do{
                    System.out.print("Enter the amount you would like to withdraw: $");
                    amount = scan.nextDouble();

                    if (amount > balance){
                        System.out.println("Insufficient funds!");
                    }
                    else if (amount < 0) {
                        System.out.println("Must enter a valid amount!");
                    }
                }
                while (amount > balance || amount < 0);

                balance -= amount;
                System.out.println("$" + amount + " has been withdrawn from account #" + accountNum);
                isNotNum = false;
            }

            catch (InputMismatchException e){
                System.out.println("Must enter a number!");
                scan.nextLine();
            }
        } while(isNotNum);
    }
}
