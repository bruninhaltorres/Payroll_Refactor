package src.payment;

public class CheckHand extends Payment {
    private String nameEmployee;

    public String getNameEmployee() {
        return nameEmployee;
    }
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public CheckHand(int id, String nameEmployee) {
        setIdEmployee(id);
        setNameEmployee(nameEmployee);
    }
}