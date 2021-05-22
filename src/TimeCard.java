package src;

import java.util.ArrayList;

public class TimeCard {
    private int in;
    private int out;
    private int hoursWorked = out - in;
    private int hoursWeekly;
    private String date;

    public TimeCard(int in, int out, String date) {
        this.in = in;
        this.out = out;
        this.setDate(date);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWeekly(ArrayList<TimeCard> listTimeCards) {
        int hoursWeekly = 0;
        for (TimeCard timecard : listTimeCards) {
            hoursWeekly += timecard.getHoursWorked();
        }
        this.hoursWeekly = hoursWeekly;
        System.out.println("Horas trabalhadas essa semana: " + hoursWeekly);
    }

}
