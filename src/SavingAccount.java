public class SavingAccount extends BankAccount{
    // Interest rate
    double interestRate;

    public SavingAccount(double balanceAmt, double rate) {
        super(balanceAmt);
        interestRate = rate;
    }

    // ToString Method:
    @Override
    public String toString(){
        String accType = String.format("%-15s", "Savings");
        String accNum = String.format("%-15s", accountNum);
        String rate = String.format("%-15s", (interestRate + "%"));

        return accType + accNum + rate;
    }
}
