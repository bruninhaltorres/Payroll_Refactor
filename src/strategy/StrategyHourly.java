package src.strategy;

import src.employees.*;
import src.payment.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

import java.util.ArrayList;

public class StrategyHourly implements StrategyPayment{
    ArrayList<Employees> employeesList = new ArrayList<Employees>();
    Payroll payroll = new Payroll();

    public StrategyHourly() {
    }

    public void addHourly(Employees employees) {
        this.employeesList.add(employees);
    }

    public void payroll(boolean testing) {
		LocalDate today = LocalDate.now();
        if(today.getDayOfWeek() == DayOfWeek.FRIDAY || testing){
			System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay Hourly employees.\n");
			System.out.println("These are the employees that got paid today:\n");
            payroll.paidEmployees(employeesList);
        }
        payroll.incrementFridays();
    }
}
