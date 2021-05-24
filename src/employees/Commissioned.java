package src.employees;

import java.util.ArrayList;
import java.util.Scanner;
import src.Sale;

public class Commissioned extends Employees {
    private double committee;
    private ArrayList<Sale> listSales = new ArrayList<Sale>(); // cria uma lista dinâmica e não um array fixo que vai armazenas o todas as vendas dos comissionados.

    public void addTimeCard(){}

    public Commissioned(String name, String adress, int id, double committee) {
        super(name, adress, id);
        this.setCommittee(committee);
    }

    public double getCommittee() {
        return this.committee; // this opicional, pois só tem uma variavel com o nome "committee" nessa função.
    }

    public void setCommittee(double committee) {
        this.committee = committee;
    }

    public void addSale() {
        Scanner input = new Scanner(System.in);
        System.out.println("Data: (DD/MM/AA)");
        String date = input.nextLine();

        System.out.println("Nome do produto vendido:");
        String nameItem = input.nextLine();

        System.out.println("Valor desse produto: (R$)");
        double value = input.nextDouble();

        Sale sale = new Sale(date, nameItem, value);
        listSales.add(sale);

        for(Sale saleAux : listSales){
            System.out.println("Produto adicionado: " + saleAux.getNameItem());
        }
    }

}
