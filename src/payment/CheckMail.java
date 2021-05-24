package src.payment;

import src.employees.Employees;

public class CheckMail extends Payment {
    private String nameEmployee; // Destinatario

    public String getNameEmployee() {
        return nameEmployee;
    }
    public void setNameEmployee(String name) {
        this.nameEmployee = name;
    }

    public CheckMail(Employees employees, String adress, String method){
        setIdEmployee(employees.getId());
        setNameEmployee(employees.getName());
        employees.setMethodPayment(method);
        employees.setAdress(adress);
    }
}