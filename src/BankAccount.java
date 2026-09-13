import java.util.Scanner;

public abstract class BankAccount implements Account{
    Scanner scan = new Scanner(System.in);

    static int accountCount = 0;
    double balance;

    public BankAccount(double balanceAmt){
        balance = balanceAmt;
        accountCount++;
    }

    @Override
    public void deposit() {
        double amount;

        System.out.print("Enter the amount you would like to deposit: $");
        amount = scan.nextDouble();

        balance += amount;
    }

    @Override
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

    }
}
