package src.payment;

import java.util.ArrayList;

import src.employees.Employees;

public class Payroll{
	private int fridays;

	public int getFridays() {
		return fridays;
	}

	public void incrementFridays() {
		this.fridays += 1;
	}

	public Payroll() {
		this.fridays = 2;
	}

	public void paidEmployees(ArrayList<Employees> employeesList){
        if(employeesList.isEmpty()) {
            System.out.println("None\n");
        } else {
            for(Employees employees : employeesList){
                System.out.println(employees.getName());
                System.out.println("\n");
            }
        }
    }
}
