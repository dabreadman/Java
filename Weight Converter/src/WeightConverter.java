import java.util.Scanner;
import javax.swing.JOptionPane;

public class WeightConverter {

	public static final double STONESTOPOUNDS = 14;
	public static final double POUNDSTOOUNCES = 16;
	public static final double OUNCESTOKILOGRAMS = 0.02834952; 
	public static final double POUNDSTOKILOGRAMS = POUNDSTOOUNCES*OUNCESTOKILOGRAMS;
	public static final double STONESTOKILOGRAMS = STONESTOPOUNDS*POUNDSTOKILOGRAMS;


	public static void main(String[] args) {
		try{
			boolean quit = false;
			while(!quit)
			{
				String userInput = JOptionPane.showInputDialog
						("Enter the number of Stones, Pounds and Ounces seperated by space (or enter quit):");
				Scanner scannerInput = new Scanner(userInput);
				scannerInput.useDelimiter(" ");
				int stones,pounds,ounces;

				if (scannerInput.hasNextInt())
				{
					stones = scannerInput.nextInt();
					pounds = scannerInput.nextInt();
					ounces = scannerInput.nextInt();
					if (stones>=0 && pounds >=0 && ounces >=0)
					JOptionPane.showMessageDialog(null, (getFormattedWeightString(stones,pounds,ounces)+" is equal to "
							+convertToKilograms(stones,pounds,ounces)+"kg."));
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid input","Error",2);
						quit = true;
					}
				}
				
				else
				{
					String nonIntegerInput = scannerInput.next();
					if (!nonIntegerInput.equals("quit"))
						JOptionPane.showMessageDialog(null, "Invalid input","Error",2);
					
					quit = true;
				}
				scannerInput.close();
			}
		}
		catch(java.util.InputMismatchException exception)
		{	
			JOptionPane.showMessageDialog(null, "Invalid input","Error",2);
		}
		catch(java.lang.NullPointerException exception)
		{
			JOptionPane.showMessageDialog(null, "Goodbye!");
		}
		catch(java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "Invalid input","Error",2);	
		}
	}
	
	public static double convertToKilograms(int stones, int pounds, int ounces)
	{
		double weightInKilograms = ((stones*STONESTOKILOGRAMS) + (pounds*POUNDSTOKILOGRAMS)+ (ounces*OUNCESTOKILOGRAMS));
		return weightInKilograms;
	}

	public static String getFormattedWeightString(int stones, int pounds, int ounces)
	{
		String returnString = "";
		if (stones == 0 && pounds ==0 && ounces==0)
			returnString = "0 ounces";
		else
		{
			if (stones!=0)
			{
				returnString += (stones)+ ((stones>1)? " stones":" stone");
				if (pounds != 0 || stones !=0)
					returnString += ", ";
			}
			if (pounds!=0)
			{
				returnString += (pounds)+((pounds>1)? " pounds":" pound");
				if (ounces!=0)
					returnString +=", ";
			}
			if (ounces!=0)
				returnString += (ounces)+((ounces>1)? " ounces":" ounce");
		}		
		return returnString;	
	}
}
