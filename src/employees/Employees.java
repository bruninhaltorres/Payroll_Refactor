package src.employees;

import java.util.ArrayList;
import java.lang.String;

public abstract class Employees {
    private String name;
    private String adress;
    private String methodPayment;
    private int id;

    public abstract void addTimeCard();
    public abstract void addSale();
    
    public String getName(){
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress(){
        return adress;
    }

    public void setAdress(String setAdress) {
        this.adress = setAdress;
    }

    public String getMethodPayment(){
        return methodPayment;
    }

    public void setMethodPayment (String methodPayment){
        this.methodPayment = methodPayment;
    }
    
    public int getId(){
        return id;
    }

    public Employees(String name, String adress, int id) { 
        this.setName(name);
        this.setAdress(adress);
        this.id = id;
    }

    public void employeeInfos(){
        System.out.println("Name: " + this.getName());
        System.out.println("ID: " + this.getId());
        System.out.println("Adress: " + getAdress());
        System.out.println("Type Payment: " + getMethodPayment());
        System.out.println("Type: " + getClass());
        //return "Payment Day: " + getPaymentDay();
    }

    public void printEmployees(ArrayList<Employees> employeeList) {
        System.out.println("Lista de todos os empregados:\n\n");
        for(Employees employee : employeeList){
            employee.employeeInfos();
            System.out.println("\n\n");
        }
    }
}
