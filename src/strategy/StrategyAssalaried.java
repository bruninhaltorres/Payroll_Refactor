package src.strategy;

import src.employees.*;
import src.payment.*;
import java.time.LocalDate;

import java.util.ArrayList;

public class StrategyAssalaried implements StrategyPayment{
    ArrayList<Employees> employeesList = new ArrayList<Employees>();
    Payroll payroll = new Payroll();
    
    public StrategyAssalaried() {
    }

    public void addAssalaried(Employees employees) {
        employeesList.add(employees);
    }
    public void payroll(boolean testing) {
		LocalDate today = LocalDate.now();

        if(testing || today.getDayOfMonth() == 27 || today.getDayOfMonth() == 29 || today.getDayOfMonth() == 30 ||today.getDayOfMonth() == 31){
			// pay salaried
			System.out.println("Today is " + today.getDayOfMonth() + " of " + today.getMonth() + ". It's time to pay salaried employees.\n");
			System.out.println("These are the employees that got paid today:\n");
            payroll.paidEmployees(employeesList);
		}
        payroll.incrementFridays();
    }
}
