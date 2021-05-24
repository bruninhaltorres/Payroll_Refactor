package src.employees;

public class Assalaried extends Employees{

    private double salary;

    public void addTimeCard(){}
    public void addSale() {}

    public Assalaried(String name, String adress, int id, double salary) {
        super(name, adress, id);// chama o construtor da classe pai.
        this.salary = salary;
    }
}
