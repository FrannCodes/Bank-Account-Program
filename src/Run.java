import java.util.Scanner;

public class Run {
    Scanner scan = new Scanner(System.in);
    BankAccount[] accounts = new BankAccount[30];
    boolean run = true;

    public void run(){
        // Makes the run a loop until the "Exit" option is chosen
        do{
            // Choices
            System.out.println("1. Get account summary \n" +
                    "2. Create a new account \n" +
                    "3. Make deposit \n" +
                    "4. Withdraw \n" +
                    "5. Process check \n" +
                    "6. Exit");

            int choice;

            // Loop if choice is not within the choices
            do{
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();

                if (choice > 6 || choice < 1){
                    System.out.println("Not a valid choice.");
                }
            }
            while(choice > 6 || choice < 1);

            System.out.println();

            switch (choice){
                case 1:
                    System.out.println("Accounts Summary:");
                    displayAccounts();
                    break;

                case 2:
                    if (accounts[accounts.length - 1] != null){
                        System.out.println("Max amount of accounts reached");
                        System.out.println();
                    }
                    else{
                        newAccount();
                        System.out.println();
                    }
                    break;



                case 6:
                    System.out.println("Thank you for using YourBank Bank. Goodbye!");
                    run = false;
                    break;
            }
        }
        while(run);
    }

    // Displays account information
    public void displayAccounts(){
        System.out.printf("%-15s%-15s%-15s%-15s%n",
                "Account #", "Type", "Balance", "Interest Rate");

        for (BankAccount account : accounts){
            if (account != null){
                System.out.println(account);
            }
        }
    }

    // Method for creating new account
    public void newAccount(){

        System.out.println("Create a new:");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");

        int choice;
        char choiceIR;
        double deposit;
        double interestRate;

        // Loops until correct choice is chosen
        do{
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            if (choice > 2 || choice < 1){
                System.out.print("Invalid choice.");
            }
        }
        while (choice > 2 || choice < 1);

        System.out.print("Enter the starting deposit: ");
        deposit = scan.nextDouble();

        // Loops through accounts and checks the lowest index with "null"
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i] == null){
                switch (choice){
                    case 1:
                        accounts[i] = new CheckingAccount(deposit);
                        System.out.println("A Checking account has been created.");
                        break;

                    case 2:
                        System.out.print("Use the default interest rate (0.3%)? Y/N: ");

                        do{
                            scan.nextLine();
                            choiceIR = scan.nextLine().toLowerCase().charAt(0);

                            if (choiceIR != 'y' && choiceIR != 'n'){
                                System.out.print("Invalid answer, Enter again: ");
                            }
                        }
                        while(choiceIR != 'y' && choiceIR != 'n');

                        switch (choiceIR){
                            case 'y':
                                accounts[i] = new SavingAccount(deposit);
                                break;

                            case 'n':
                                System.out.print("Enter the interest rate (%): ");
                                interestRate = scan.nextDouble();

                                accounts[i] = new SavingAccount(deposit, interestRate);
                        }

                        break;
                }
                break;
            }
        }
    }
}
