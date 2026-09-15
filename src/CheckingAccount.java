public class CheckingAccount extends BankAccount{

    public CheckingAccount(double balanceAmt){
        super(balanceAmt);
    }

    // Processing Check Method
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

    // ToString Method:
    @Override
    public String toString(){
        String accType = String.format("%-15s", "Checking");
        String accNum = String.format("%-15d", accountNum);
        String rate = String.format("%-15s", "0.0%");
        String accBalance = String.format("$%-14.2f", balance);

        return accNum + accType + accBalance + rate;
    }
}
