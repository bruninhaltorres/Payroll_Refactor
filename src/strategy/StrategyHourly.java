package src.strategy;

import src.employees.*;
import src.payment.*;
import java.time.LocalDate;
import java.time.DayOfWeek;



import java.util.ArrayList;

public class StrategyHourly implements StrategyPayment{
    ArrayList<Employees> employeesList = null;
    Payroll payroll = new Payroll();

    public StrategyHourly(ArrayList<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public void payroll(boolean testing) {
		LocalDate today = LocalDate.now();
		ArrayList<Employees> employeesToPay = new ArrayList();

        if(today.getDayOfWeek() == DayOfWeek.FRIDAY || testing){
			System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay Hourly employees.\n");
			System.out.println("These are the employees that got paid today:\n");
			for(Employees employees : employeesList){
				if(employees instanceof Hourly){
					employeesToPay.add(employees);
					System.out.println(employees.getName());
					System.out.println("\n");
				}
			}
            if(employeesToPay.isEmpty()) {
                System.out.println("None\n");
            }
        }
        payroll.incrementFridays();
    }
}
