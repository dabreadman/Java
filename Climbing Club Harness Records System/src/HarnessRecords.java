import java.util.Arrays;
import java.util.ArrayList;


public class HarnessRecords {

	private ArrayList<Harness> records;

	HarnessRecords(){
		records = new ArrayList<Harness>();
	}

	HarnessRecords(ArrayList<Harness>list){
		records = list;
	}

	public boolean isEmpty() {
		if (records.size()<=0)
			return true;
		return false;
	}

	public void addHarness (Harness newHarness) {
		records.add(newHarness);
	}

	public Harness findHarness (String make, int modelNumber) {

		for (Harness harness:records)
		{
			String harnessMake = harness.getMake();
			int harnessModelNumber = harness.getModelNumber();
			if (harnessMake.equals(make)&&harnessModelNumber==modelNumber)
				return harness;
		}
		return null;	
	}

	public Harness checkHarness(String instructorName,String hMake,int hModelNumber)
	{
		Harness theHarness = findHarness(hMake,hModelNumber);
		if (theHarness!=null && !theHarness.isHarnessOnLoan())
		{
			theHarness.checkHarness(instructorName);
			return theHarness;
		}
		return null;
	}

	public Harness loanHarness (String memberName)
	{
		for (Harness theHarness : records)
		{
			if(theHarness.canHarnessBeLoaned())
			{
				theHarness.loanHarness(memberName);
				return theHarness;
			}
		}
		return null;
	}

	public Harness returnHarness (String make, int modelNumber){
		Harness theHarness = findHarness(make,modelNumber);
		if (theHarness!=null)
		{
			if (theHarness.isHarnessOnLoan()){
				theHarness.returnHarness();
				return theHarness;
			}
		}
		return null;
	}

	public Harness removeHarness (String make, int modelNumber){
		Harness theHarness = findHarness(make,modelNumber);
		if (theHarness!=null){
			records.remove(theHarness);
			return theHarness;
		}
		return null;
	}

































	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
