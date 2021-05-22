package src.payment;

public class Deposit extends Payment {
    private int account;
    private int agency;
    private int bank;

    public int getAccount() {
        return account;
    }
    public int getBank() {
        return bank;
    }
    public void setBank(int bank) {
        this.bank = bank;
    }
    public int getAgency() {
        return agency;
    }
    public void setAgency(int agency) {
        this.agency = agency;
    }
    public void setAccount(int account) {
        this.account = account;
    }

    public Deposit(int idEmployee, int account, int agency, int bank) {
        this.setIdEmployee(idEmployee);
        this.setAccount(account);
        this.setAgency(agency);
        this.setBank(bank);
    }
}