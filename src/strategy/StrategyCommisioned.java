package src.strategy;

import src.employees.*;
import src.payment.*;
import java.time.LocalDate;

import java.util.ArrayList;

public class StrategyCommisioned implements StrategyPayment{
    ArrayList<Employees> employeesList = null;
    Payroll payroll = new Payroll();
    
    public StrategyCommisioned(Employees employees) {
        employeesList.add(employees);
    }

    public void payroll(boolean testing) {
		LocalDate today = LocalDate.now();
		//ArrayList<Employees> employeesToPay = new ArrayList();

        if(payroll.getFridays() % 2 == 0){
            // pay commissioned
            System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay commissioned employees.\n");
            System.out.println("These are the employees that got paid today:\n");
            /*
            for(Employees employees : employeesList){
				if(employees instanceof Commissioned){
					employeesToPay.add(employees);
					System.out.println(employees.getName());
					System.out.println("\n");
				}
			}*/
            if(employeesList.isEmpty()) {
                System.out.println("None\n");
            }
        }
        payroll.incrementFridays();
    }
}
