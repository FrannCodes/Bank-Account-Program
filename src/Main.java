import java.util.Scanner;

public class Main {
    //Main method

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //Create a password for the program
        String password = password();

        //Main Screen
        int wrongPasswordCount = 0;
        String userInput;

        System.out.println("------------------------");
        System.out.println("Welcome to YourBank Bank");
        System.out.println("------------------------");

        do{
            System.out.print("Enter password: ");
            userInput = scan.nextLine();

            if (!userInput.equals(password)){
                System.out.println("Wrong password!");
                wrongPasswordCount++;
            }
        }
        while ((wrongPasswordCount < 3) &&  (!userInput.equals(password)));

        if (wrongPasswordCount >= 3){
            //If the program exits loop and input the wrong password 3 times
            System.out.println("Reached max number of attempts");
        }
        else{
            //
            System.out.println("1. Get account summary \n" +
                    "2. Create a new account \n" +
                    "3. Make deposit \n" +
                    "4. Withdraw \n" +
                    "5. Process check \n" +
                    "6. Exit");
        }
    }

    //Method to create a password for the program
    public static String password(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Create a password: ");
        String password = scan.nextLine();

        return password;
    }
}

