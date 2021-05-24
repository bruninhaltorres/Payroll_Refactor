package src.payment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;

import java.util.Scanner;
import java.util.ArrayList;

import src.employees.Commissioned;
import src.employees.Employees;
import src.employees.Hourly;

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

	public static void payEmployees(ArrayList<Employees> employeesList, Payroll payroll) {
		Scanner input = new Scanner(System.in);
		boolean testing = false;
//		printEmployees(listEmployee);
		LocalDate today = LocalDate.now();
		ArrayList<Employees> employeesToPay = new ArrayList();
		int size = employeesList.size();
		int i;

		if(testing || today.getDayOfMonth() == 27 || today.getDayOfMonth() == 29 || today.getDayOfMonth() == 30 ||today.getDayOfMonth() == 31){
			// pay salaried
			System.out.println("Today is " + today.getDayOfMonth() + " of " + today.getMonth() + ". It's time to pay salaried employees.\n");
			System.out.println("These are the employees that got paid today:\n");
			for(i = 0; i < size; i++){
				if(employeesList.get(i).getClass() == Employees.class){
					employeesToPay.add(employeesList.get(i));
					System.out.println(employeesList.get(i).getName());
					System.out.println("\n");
				}
			}
		}
		if(today.getDayOfWeek() == DayOfWeek.FRIDAY || testing){
			// pay hourly
			System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay Hourly employees.\n");
			System.out.println("These are the employees that got paid today:\n");
			for(i = 0; i < size; i++){
				if(employeesList.get(i).getClass() == Hourly.class){
					employeesToPay.add(employeesList.get(i));
					System.out.println(employeesList.get(i).getName());
					System.out.println("\n");
				}
			}

			if(payroll.fridays % 2 == 0){
				// pay commissioned
				System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay commissioned employees.\n");
				System.out.println("These are the employees that got paid today:\n");
				for(i = 0; i < size; i++){
					if(employeesList.get(i).getClass() == Commissioned.class){
						employeesToPay.add(employeesList.get(i));
						System.out.println(employeesList.get(i).getName());
						System.out.println("\n");
					}
				}
			}
			payroll.incrementFridays();
		} else System.out.println("The company don't have any employees to pay today.\n");
	}
}
