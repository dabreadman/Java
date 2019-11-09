public class Harness {
	private String make,member,instructor;
	private int modelNumber,timesUsed;
	private boolean isOnLoan;

	private static final String NO_MEMBER = "null";
	private static final int TIMES_USED_RESET = 0;
	private static final int MAX_TIMES_USED = 25;

	Harness(String make, int modelNumber, int timesUsed, String instructor,boolean isOnLoan, String member){
		this.make = make;
		this.modelNumber = modelNumber;
		this.timesUsed = timesUsed;
		this.instructor = instructor;
		this.isOnLoan = isOnLoan;
		this.member=(isOnLoan? member:NO_MEMBER);
	}

	Harness(String make, int modelNumber, String instructor){
		this.make = make;
		this.modelNumber = modelNumber;
		this.instructor = instructor;
		isOnLoan = false;
		timesUsed = TIMES_USED_RESET;
		member = NO_MEMBER;
	}

	public void checkHarness(String instructorName) {
		if (this.canHarnessBeLoaned())
		{
			instructor = instructorName;
			timesUsed = TIMES_USED_RESET;
		}
	}

	public boolean isHarnessOnLoan() {
		return isOnLoan;
	}

	public boolean canHarnessBeLoaned() {
		if (this.isHarnessOnLoan()||timesUsed>=MAX_TIMES_USED)
			return false;
		else
			return true;
	}

	public void loanHarness (String memberName) {
		if (this.canHarnessBeLoaned())
		{
			member = memberName;
			isOnLoan = true;
		}
	}

	public void returnHarness () {
		if (this.isHarnessOnLoan())
		{
			timesUsed++;
			isOnLoan = false;
		}
	}

	public String toString() {
		String description="";
		description = String.format("\nMake: %s\nModel number: %s\nTimes Used: %s\nIs Harness On Loan: %s\nLast loaned to: %s\n"
				+ "Last checked by: %s", make,modelNumber,timesUsed,isOnLoan,member,instructor);
		return description;
	}

	public String getMake() {
		return make;
	}

	public int getModelNumber() {
		return modelNumber;
	}


}
