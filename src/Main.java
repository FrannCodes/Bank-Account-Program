import java.util.Scanner;

public class Main {
    //Main method

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // Password for the program
        final String password = "MyBank123";

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
            System.out.println();
            Run run = new Run();
            run.run();
        }
    }
}

