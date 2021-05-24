package src.payment;

import src.employees.Employees;

public class CheckHand extends Payment{
    private String nameEmployee;
    
    public String getNameEmployee() {
        return nameEmployee;
    }
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public CheckHand(Employees employees, String method) {
        setIdEmployee(employees.getId());
        setNameEmployee(employees.getName());
        employees.setMethodPayment(method);
    }
}