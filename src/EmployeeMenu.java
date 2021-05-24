package src;

import src.employees.*;
import src.payment.*;

import java.util.Scanner;
import java.lang.String;
import java.util.Random;
import java.util.ArrayList;

public class EmployeeMenu {
    Scanner input = new Scanner(System.in);
    
    public static int generateId(ArrayList<Employees> employeeList) {
        Random random = new Random();
        int id, qntEmployees = employeeList.size(); // quantos empregados já foram cadastrados.
        id = random.nextInt(30);
        for (int i = 0; i < qntEmployees; i++){
            if (id == employeeList.get(i).getId()){
                id = random.nextInt(30);
                i = 0; // verificar lista toda do começo garantindo a não repetição do novo id.
            }
        }
        return id;
    }

    public int generateIdSyndicate(ArrayList<Syndicate> syndicateList) {
        Random random = new Random();
        int id, qntEmployees = syndicateList.size(); // quantos empregados já foram cadastrados.
        id = random.nextInt(30);
        for (int i = 0; i < qntEmployees; i++){
            if (id == syndicateList.get(i).getIdSyndicate()){
                id = random.nextInt(30);
                i = 0; // verificar lista toda do começo garantindo a não repetição do novo id.
            }
        }
        return id;
    }

    public void isSyndicate(ArrayList<Syndicate> listSyndicate, Employees employees) {
        System.out.println("Ele irá fazer parte do Sindicato?\n1 - Sim\n2 - Não");
        int isSyndicate = input.nextInt();
        if(isSyndicate == 1) {
            int idSyndicate = generateIdSyndicate(listSyndicate);
            Syndicate syndicate = new Syndicate(idSyndicate);
            syndicate.add(employees.getId());
            listSyndicate.add(syndicate);
        }
    }

    public void addEmployee(Employees employees, ArrayList<Employees> listEmployees, ArrayList<Syndicate> listSyndicate) {
        listEmployees.add(employees);
        isSyndicate(listSyndicate, employees);
        employees.printEmployees(listEmployees);
    }

    public Employees createEmployee(ArrayList<Employees> listEmployees, ArrayList<Syndicate> listSyndicate, Payment payment) {
        
        System.out.println("Nome do empregado:");
        String name = input.nextLine();

        System.out.println("Endereco do empregado:");
        String adress = input.nextLine(); 

        System.out.println("O empregado é...\n1 - Horista\n2 - Comissionado\n3 - Assalariado");
        int type = input.nextInt();

        int idEmployee = generateId(listEmployees);

        Employees employees = null;

        if (type == 1) { // horista
            employees = new Hourly(name, adress, idEmployee); 
        } else if (type == 2) { // comissionado
            double valueComissioned;
            System.out.println("Valor da comissão:");
            valueComissioned = input.nextDouble();
            employees = new Commissioned(name, adress, idEmployee, valueComissioned);
        } else {
            double salary;
            System.out.println("Salário:");
            salary = input.nextDouble();
            employees = new Assalaried(name, adress, idEmployee, salary);
        }
        payment.payment_method(employees);
        addEmployee(employees, listEmployees, listSyndicate);
        input.nextLine();
        return employees;
    }
}
