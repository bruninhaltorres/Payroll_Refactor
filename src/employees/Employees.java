package src.employees;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

import src.payment.CheckHand;
import src.payment.CheckMail;
import src.payment.Deposit;
import src.payment.Payroll;

public class Employees {
    private String name;
    private String adress;
    private String methodPayment;
    private int id;


    public String getName(){
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getAdress(){
        return adress;
    }

    public void setAdress(String setAdress) {
        this.adress = setAdress;
    }

    public String getMethodPayment(){
        return methodPayment;
    }


    public int getId(){
        return id;
    }

    public Employees(int id) {
        this.id = id;
    }

    public Employees(String name, String adress, String method, int id) { // contrutor 2. Pode ter vários e o que vai mudar de um pro outro são os parâmetros.
        this.setName(name);
        this.setAdress(adress);
        this.id = id;
        this.methodPayment = method;
    }

    public void employeeInfos(){
        System.out.println("Name: " + this.getName());
        System.out.println("ID: " + this.getId());
        System.out.println("Adress: " + getAdress());
        System.out.println("Employee Type: " + getMethodPayment());
        //return "Payment Day: " + getPaymentDay();
    }

    public void printEmployees(ArrayList<Employees> employeeList) {
        System.out.println("Lista de todos os empregados:\n\n");
        for(Employees employee : employeeList){
            System.out.println("Empregado " + employee.getId() + " - ");
            employee.employeeInfos();
            System.out.println("\n\n");
        }
    }

    public void payment_method(int method, int id) {
        Scanner input = new Scanner(System.in);
        if (method == 1) {
            this.methodPayment = "hand";
            CheckHand check = new CheckHand(this.id, this.name);
        } else if (method ==  2) {
            this.methodPayment = "deposit";
            System.out.println("Qual o nº da conta?");
            int account = input.nextInt();
            System.out.println("Número da agencia:");
            int agency = input.nextInt();
            System.out.println("Numero do banco:");
            int bank = input.nextInt();
            Deposit deposit = new Deposit(this.id, account, agency, bank);
        } else if (method == 3) {
            this.methodPayment = "mail";
            System.out.println("Nome do remetente:");
            String sender = input.next();
            CheckMail ckeckM = new CheckMail(this.id, this.name, sender);
        } else {
            System.out.println("Metodo de pagamento inválido!\n");
        }
    }

    public void add(){
        // ---- NOME ----
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do empregado:");
        this.name = input.nextLine();
    
        System.out.println("Insira o endereco do empregado:");
        this.adress = input.nextLine();
    
        // ---- FORMA PAGAMENTO ----
        System.out.println("Qual a forma de pagamento?");
        System.out.println("1 - Em mãos");
        System.out.println("2 - Depósito bancário");
        System.out.println("3 - Cheque pelos correios");
        int method = input.nextInt();
        payment_method(method, id);
        // ---- TIPO EMPREGADO ----
        
        System.out.println("Empregado adicionado com sucesso!");
        System.out.println(this.name);
    //System.out.println(id);
    }
}
