package src;

public class Sale {
    private String date;
    private String nameItem;
    private double value;

    public Sale(String date, String nameItem, double value) {
        this.setDate(date);
        this.setNameItem(nameItem);
        this.setValue(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
