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

        System.out.print("Enter the amount you would like to deposit: $");
        amount = scan.nextDouble();

        balance += amount;

        System.out.println("$" + amount + " has been deposited to account #" + accountNum);
    }

    @Override
    // Withdraw Method
    public void withdraw() {
        double amount;
        System.out.print("Enter the amount you would like to withdraw: $");
        do{
            amount = scan.nextDouble();

            if (amount > balance){
                System.out.print("Insufficient funds! Enter again: $");
            }
            else {
                balance -= amount;
            }
        }
        while (amount > balance);

        System.out.println("$" + amount + " has been withdrawn from account #" + accountNum);
    }
}
