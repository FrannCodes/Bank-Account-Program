import java.util.Scanner;

public class Run {
    Scanner scan = new Scanner(System.in);
    BankAccount[] accounts = new BankAccount[30];


    public void run(){
        boolean run = true;

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
                // View Accounts
                case 1:
                    System.out.println("Accounts Summary:");
                    displayAccounts();
                    System.out.println();

                    break;

                // Create Account
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

                // Make Deposit
                case 3:
                    if (accounts[0] != null){
                        System.out.println("The summary of your accounts:");
                        displayAccounts();

                        System.out.println();
                        int option;

                        do{
                            System.out.print("Please input your choice: ");
                            option = scan.nextInt();

                            if (option < 1 || option > BankAccount.accountCount){
                                System.out.print("Invalid choice.");
                            }
                        }
                        while (option < 1 || option > BankAccount.accountCount);

                        // Chooses an account and runs the deposit method
                        accounts[option - 1].deposit();
                        System.out.println();
                    }

                    else{
                        System.out.println("No accounts to deposit to.");
                        System.out.println();
                    }
                    break;

                // Withdraw
                case 4:
                    if (accounts[0] != null){
                        System.out.println("The summary of your accounts:");
                        displayAccounts();

                        System.out.println();
                        int option1;

                        do{
                            System.out.print("Please input your choice: ");
                            option1 = scan.nextInt();

                            if (option1 < 1 || option1 > BankAccount.accountCount){
                                System.out.print("Invalid choice.");
                            }
                        }
                        while (option1 < 1 || option1 > BankAccount.accountCount);

                        // Chooses an account and runs the withdraw method
                        accounts[option1 - 1].withdraw();
                        System.out.println();
                    }

                    else{
                        System.out.println("No accounts to withdraw from.");
                        System.out.println();
                    }
                    break;

                // Process Check
                case 5:
                    if (accounts[0] != null){
                        System.out.println("The summary of your accounts:");
                        displayAccounts();

                        System.out.println();
                        int option2;
                        boolean isChecking = false;

                        do{
                            do{
                                System.out.print("Please input your choice: ");
                                option2 = scan.nextInt();

                                if (option2 < 1 || option2 > BankAccount.accountCount){
                                    System.out.print("Invalid choice. ");
                                }
                            }
                            while (option2 < 1 || option2 > BankAccount.accountCount);

                            if (!(accounts[option2 - 1] instanceof CheckingAccount)){
                                System.out.print("Invalid choice. ");
                            }
                            else{
                                isChecking = true;
                            }
                        }
                        while(!isChecking);

                        // Chooses an account and runs the process check method
                        ((CheckingAccount) accounts[option2 - 1]).processCheck();
                        System.out.println();
                    }

                    else{
                        System.out.println("No accounts to cash a check from.");
                        System.out.println();
                    }
                    break;

                // Exit
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

        // What will display when there are no accounts
        if (accounts[0] == null){
            System.out.printf("%-15s%-15s%-15s%-15s%n%n", "--", "--", "--", "--");
        }
        else{
            for (BankAccount account : accounts){
                if (account != null){
                    System.out.println(account);
                }
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
                System.out.print("Invalid choice. ");
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

                        scan.nextLine();
                        do{
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
