package src.strategy;

import src.employees.*;
import src.payment.*;
import java.time.LocalDate;

import java.util.ArrayList;

public class StrategyCommisioned implements StrategyPayment{
    ArrayList<Employees> employeesList = new ArrayList<Employees>();
    Payroll payroll = new Payroll();
    
    public StrategyCommisioned() {
    }

    public void addCommisioned(Employees employees) {
        employeesList.add(employees);
    }
    public void payroll(boolean testing) {
		LocalDate today = LocalDate.now();

        if(payroll.getFridays() % 2 == 0 || testing){
            // pay commissioned
            System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay commissioned employees.\n");
            System.out.println("These are the employees that got paid today:\n");
            payroll.paidEmployees(employeesList);
        }
        payroll.incrementFridays();
    }
}
