package src.payment;

public class Payroll{
	private int fridays;

	public int getFridays() {
		return fridays;
	}

	public void incrementFridays() {
		this.fridays += 1;
	}

	public Payroll() {
		this.fridays = 2;
	}
}
