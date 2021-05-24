package src;

import src.employees.Employees;
import src.employees.Syndicate;
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

    public Employees createEmployee(ArrayList<Employees> employeeList, Payment payment){

        int idEmployee = generateId(employeeList);
        Employees employees = new Employees(idEmployee);

        System.out.println("Nome do empregado:");
        employees.setName(input.nextLine());

        employees.setId(idEmployee);

        System.out.println("Endereco do empregado:");
        employees.setAdress(input.nextLine()); 

        payment.payment_method(employees);

        System.out.println("Empregado adicionado com sucesso!");

        return employees;
    }

    public void defineType(Employees employees){
        System.out.println("O empregado é...\n1 - Horista\n2 - Comissionado\n3 - Assalariado");
        int type = input.nextInt();
        
        if (type == 1) { // horista
            Employees hourly = new Hourly(employees.getName(), employees.getAdress(), employees.getId());                    
        } else if (type == 2) { // comissionado
            double valueComissioned;
            System.out.println("Valor da comissão:");
            valueComissioned = input.nextDouble();
            Employees commissioned = new Commissioned(employees.getName(), employees.getAdress(), employees.getId(), valueComissioned);
        } 
        // se for assalariado não acrescenta nada além do que já tem.
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

    public void addEmployee(ArrayList<Employees> listEmployees, ArrayList<Syndicate> listSyndicate, Payment payment) {
        Employees employees = createEmployee(listEmployees, payment);
        defineType(employees);
        listEmployees.add(employees);
        isSyndicate(listSyndicate, employees);
        employees.printEmployees(listEmployees);
    }
}
