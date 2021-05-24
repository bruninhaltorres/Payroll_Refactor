package src.employees;
import java.util.Scanner;

public class Syndicate{
    private int idSyndicate;
    private int idEmployee;
    private double feeSyndicate; // taxa sindical
    private double feeService; // taxa de serviço

    
    public double getFeeService() {
        return feeService;
    }
    
    public void setFeeService(double feeService) {
        this.feeService = feeService;
    }
    
    public double getFeeSyndicate() {
        return feeSyndicate;
    }
    
    public void setFeeSyndicate(double feeSyndicate) {
        this.feeSyndicate = feeSyndicate;
    }
    
    public int getId() {
        return idEmployee;
    }
    
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    
    public int getIdSyndicate() {
        return idSyndicate;
    }
    
    public void setIdSyndicate(int idSyndicate) {
        this.idSyndicate = idSyndicate;
    }
    
    public Syndicate(int id){
        this.setIdSyndicate(idSyndicate);
    }
    
    public void add(int idEmployees){
        this.setIdEmployee(idEmployees);

        Scanner input = new Scanner(System.in);
        System.out.println("Qual a taxa sindical? (R$)");
        this.feeSyndicate = input.nextDouble();

        /*
        System.out.println("Terá taxa de serviço?\n1 - Sim\n2 - Não");
        int isFeeService = input.nextInt();
        if (isFeeService == 1){
            System.out.println("Qual valor da taxa? (R$)");
            this.feeService = input.nextDouble();
        } else {
            this.feeService = 0.0;
            System.out.println("Continuando...");
        }
        */
    }
}
