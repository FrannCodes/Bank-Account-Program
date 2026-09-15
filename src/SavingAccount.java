public class SavingAccount extends BankAccount{
    // Interest rate
    double interestRate;

    // Overloaded constructor:
    public SavingAccount(double balanceAmt){
        super(balanceAmt);
        interestRate = 0.3;
    }

    public SavingAccount(double balanceAmt, double rate) {
        super(balanceAmt);
        interestRate = rate;
    }

    // ToString Method:
    @Override
    public String toString(){
        String accType = String.format("%-15s", "Savings");
        String accNum = String.format("%-15d", accountNum);
        String rate = String.format("%-14f%%", interestRate);
        String accBalance = String.format("$%-14.2f", balance);

        return accNum + accType + accBalance + rate;
    }
}
