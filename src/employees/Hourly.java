package src.employees;

import java.util.ArrayList;
import java.util.Scanner;
import src.TimeCard;

public class Hourly extends Employees {
    private ArrayList<TimeCard> listTimeCards = new ArrayList<TimeCard>(); // um horista tem varios cartões de ponto

    public Hourly(String name, String adress, int id) {
        super(name, adress, id);// chama o construtor da classe pai.
    }

    public void getHoursWeekly(TimeCard timeCard){
        timeCard.setHoursWeekly(listTimeCards);
    }

    public void addTimeCard(){
        Scanner input = new Scanner(System.in);
        System.out.println("Data: (DD/MM/AA)");
        String date = input.nextLine();

        System.out.println("Hora de entrada: (24h)");
        int in = input.nextInt();

        System.out.println("Hora de saida: (24h)");
        int out = input.nextInt();
        
        TimeCard timeCard = new TimeCard(in, out, date);
        listTimeCards.add(timeCard);
        
        for(TimeCard timecard : listTimeCards){
            System.out.println("Data adicionada: " + timecard.getDate());
        }
    }
}
