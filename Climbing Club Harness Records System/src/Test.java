import java.util.Scanner;
import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		HarnessRecords harnessRecord = new HarnessRecords();

		Scanner inputScanner = new Scanner(System.in);
		int selection=-1;

		boolean finished=false;
		while(!finished){
			System.out.println("\nCommand list:"+
					"\n(1) add a record for a newly purchased harness"+
					"\n(2) remove a climbing harness from the club"+
					"\n(3) record the fact that a club instructor has checked the safety of a harness"+
					"\n(4) loan a harness to a club member if there is an availabe harness"+
					"\n(5) return a harness which is no longer in use by a club member"+
					"\n(6) quits program"+
					"\nP.S: null means no operation has been done.");

			if(inputScanner.hasNextInt()){
				selection = inputScanner.nextInt();
				if (selection>0){
					switch(selection){
					case 1:
						addHarness(harnessRecord);
						break;
					case 2:
						removeHarness(harnessRecord);
						break;
					case 3:
						checkHarness(harnessRecord);
						break;
					case 4:
						loanHarness(harnessRecord);
						break;
					case 5:
						returnHarness(harnessRecord);
						break;
					case 6:
						System.out.println("Program exitted");
						finished=true;
						break;
					default:
						System.out.println("Error, invalid input.");
						break;
					}
				}
				else
					System.out.println("Error, invalid input.");
			}
			else
				System.out.println("Error, invalid input.");
		}
	}

	public static void addHarness(HarnessRecords records) {
		Scanner inputScanner = new Scanner(System.in);

		String make="";
		boolean makeF=false;
		while(!makeF)
		{
			System.out.println("Enter new harness make: ");
			if (inputScanner.hasNext())
			{
				make = inputScanner.next();
				makeF = true;
			}
			else {
				String junk = inputScanner.next();
				System.out.println("Error, try again.");
			}
		}

		int modelNumber=-1;
		boolean modelNumberF = false;
		while(!modelNumberF) {
			System.out.println("Enter new harness model number: ");
			if (inputScanner.hasNextInt())
			{
				modelNumber = inputScanner.nextInt();
				modelNumberF = true;
			}
			else
				System.out.println("Error, try again.");
		}

		String instructor="";
		boolean instructorF=false;
		while(!instructorF) {
			System.out.println("Enter new harness instructor name: ");
			if (inputScanner.hasNext())
			{
				instructor = inputScanner.next();
				instructorF = true;
			}
			else
				System.out.println("Error, try again.");
		}

		Harness theHarness = new Harness(make,modelNumber,instructor);
		records.addHarness(theHarness);
		if(theHarness!=null)
			System.out.println("Added harness:"+theHarness);
	}

	public static void removeHarness(HarnessRecords records) {
		Scanner inputScanner = new Scanner(System.in);

		String make="";
		boolean makeF=false;
		while(!makeF)
		{
			System.out.println("Enter new harness make:\n");
			if (inputScanner.hasNext())
			{
				make = inputScanner.next();
				makeF = true;
			}
			else {
				String junk = inputScanner.next();
				System.out.println("Error, try again.");
			}
		}

		int modelNumber=-1;
		boolean modelNumberF = false;
		while(!modelNumberF) {
			System.out.println("Enter new harness model number: ");
			if (inputScanner.hasNextInt())
			{
				modelNumber = inputScanner.nextInt();
				modelNumberF = true;
			}
			else
				System.out.println("Error, try again.");
		}

		System.out.println("Harness removed:"+records.removeHarness(make,modelNumber));

	}

	public static void checkHarness(HarnessRecords records) {
		Scanner inputScanner = new Scanner(System.in);

		String make="";
		boolean makeF=false;
		while(!makeF)
		{
			System.out.println("Enter the harness make to check: ");
			if (inputScanner.hasNext())
			{
				make = inputScanner.next();
				makeF = true;
			}
			else {
				String junk = inputScanner.next();
				System.out.println("Error, try again.");
			}
		}

		int modelNumber=-1;
		boolean modelNumberF = false;
		while(!modelNumberF) {
			System.out.println("Enter the harness model number to check: ");
			if (inputScanner.hasNextInt())
			{
				modelNumber = inputScanner.nextInt();
				modelNumberF = true;
			}
			else
				System.out.println("Error, try again.");
		}

		String instructor="";
		boolean instructorF=false;
		while(!instructorF) {
			System.out.println("Enter the instructor name checking: ");
			if (inputScanner.hasNext())
			{
				instructor = inputScanner.next();
				instructorF = true;
			}
			else
				System.out.println("Error, try again.");
		}
		System.out.println("Harness checked:"+records.checkHarness(instructor,make,modelNumber));
	}

	public static void loanHarness(HarnessRecords record) {
		Scanner inputScanner = new Scanner(System.in);
		String member="";
		boolean memberF=false;
		while(!memberF)
		{
			System.out.println("Enter the member's name: ");
			if (inputScanner.hasNext())
			{
				member = inputScanner.next();
				memberF = true;
			}
			else {
				String junk = inputScanner.next();
				System.out.println("Error, try again.");
			}
		}

		Harness theHarness = record.loanHarness(member);
		if(theHarness==null)
			System.out.println("No harness is available.");
		else
			System.out.println("The harness lend:"+theHarness);
	}

	public static void returnHarness(HarnessRecords records) {
		Scanner inputScanner = new Scanner(System.in);

		String make="";
		boolean makeF=false;
		while(!makeF)
		{
			System.out.println("Enter the harness make to return: ");
			if (inputScanner.hasNext())
			{
				make = inputScanner.next();
				makeF = true;
			}
			else {
				String junk = inputScanner.next();
				System.out.println("Error, try again.");
			}
		}

		int modelNumber=-1;
		boolean modelNumberF = false;
		while(!modelNumberF) {
			System.out.println("Enter the harness model number to return: ");
			if (inputScanner.hasNextInt())
			{
				modelNumber = inputScanner.nextInt();
				modelNumberF = true;
			}
			else
				System.out.println("Error, try again.");
		}
		System.out.println("Harness returned:"+records.returnHarness(make,modelNumber));
	}

}
