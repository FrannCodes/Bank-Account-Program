import java.util.InputMismatchException;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(double balanceAmt){
        super(balanceAmt);
    }

    // Processing Check Method
    public void processCheck(){
        int checkNum = 1;
        double amount;
        boolean isNotNum = true;

        // Loops until a number is entered
        do{
            try{
                // Loops until valid check number is entered
                do{
                    System.out.print("Enter the check number: #");
                    checkNum = scan.nextInt();

                    if (checkNum <= 0){
                        System.out.println("Must enter a valid number greater than 0!");
                    }
                }
                while(checkNum <= 0);

                isNotNum = false;
            }
            catch (InputMismatchException e){
                System.out.println("Must enter a number!");
                scan.nextLine();
            }
        }
        while(isNotNum);

        isNotNum = true;

        // Loops until number is entered
        do{
            // Error handling in case user doesn't enter a number
            try{
                // Loops until valid number is entered
                do{
                    System.out.print("Enter the amount you would like to check: $");
                    amount = scan.nextDouble();

                    if (amount > balance){
                        System.out.print("Insufficient funds! ");
                    }
                    else if (amount < 0) {
                        System.out.println("Must enter a valid amount!");
                    }
                }
                while (amount > balance || amount < 0);

                balance -= amount;
                System.out.println("Check #" + checkNum + " with the amount of " + amount + " has been cached.");

                isNotNum = false;
            }
            catch (InputMismatchException e){
                System.out.println("Must enter a number!");
                scan.nextLine();
            }
        }
        while(isNotNum);
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
