public abstract class BankAccount implements Account{
    int accountNum = 0;
    double balance;

    public BankAccount(double balanceAmt){
        balance = balanceAmt;
        accountNum++;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }
}
