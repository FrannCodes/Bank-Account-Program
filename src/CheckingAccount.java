public class CheckingAccount extends BankAccount{
    int accountNum = 0;

    public CheckingAccount(double balanceAmt){
        super(balanceAmt);
        accountNum = BankAccount.accountCount;
    }

    public void processCheck(){
        int checkNum;
        System.out.print("Enter the check number: #");
        checkNum = scan.nextInt();

        double amount;
        System.out.print("Enter the amount you would like to check: $");
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

        System.out.println("Check #" + checkNum + " with the amount of " + amount + " has been cached.");
    }
}
