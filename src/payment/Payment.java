package src.payment;
import src.employees.Employees;

import java.lang.String;
import java.util.Scanner;

public class Payment {
    private int idEmployee;
    private int salary;
    
    public int getIdEmployee() {
        return this.idEmployee;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void payment_method(Employees employees) {
        Scanner input = new Scanner(System.in);

        System.out.println("Qual a forma de pagamento?");
        System.out.println("1 - Em mãos");
        System.out.println("2 - Depósito bancário");
        System.out.println("3 - Cheque pelos correios");
        int method = input.nextInt();
        int valid = 1;
        while (valid == 1){
            valid = 0;
            if (method == 1) {
                Payment check = new CheckHand(employees, "Em mãos");
            } else if (method ==  2) {
                System.out.println("Qual o nº da conta?");
                int account = input.nextInt();
                System.out.println("Número da agencia:");
                int agency = input.nextInt();
                System.out.println("Numero do banco:");
                int bank = input.nextInt();
                Payment deposit = new Deposit(employees, account, agency, bank, "Deposit");
            } else if (method == 3) {
                System.out.println("Endereço:");
                String adress = input.nextLine();
                Payment ckeckMail = new CheckMail(employees, adress, "Cheque via correios");
            } else {
                System.out.println("Metodo de pagamento inválido! Tente novamente\n");
                valid = 1;
                method = input.nextInt();
            }
        }
    }
}
