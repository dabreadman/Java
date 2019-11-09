import java.util.Scanner;
import javax.swing.JOptionPane;

public class Reversed_Number {

	public static void main(String[] args) {

		try
		{
			int front,back,newFront,newBack;
			String tempFront,tempBack,sign;
			newFront = 0;
			newBack = 0;

			String input = JOptionPane.showInputDialog("This is a program that reverse digits."
					+ "\nPlease enter your number in the form of"
					+ "\n-123.45 for -123.45."
					+"\nInput: ");
			Scanner scanner  = new Scanner(input);
			scanner.useDelimiter("\\."); 

			tempFront = scanner.next();
			if (scanner.hasNext())
			{
				tempBack = scanner.next();
			}
			else 
			{
				tempBack = "0";
			}
			scanner.close();
			front = Integer.parseInt(tempFront);
			back = Integer.parseInt(tempBack);

			sign = (front <0)? "-":"";
			front = Math.abs(front);

			while (front > 0)
			{
				newBack = newBack*10 + front%10;
				front /= 10;
			}
			while (back > 0)
			{
				newFront = newFront*10 + back%10;
				back /= 10;
			}
			JOptionPane.showMessageDialog(null, "The reveresed digit is " + sign + newFront + "." + newBack);
		}

		catch(java.util.NoSuchElementException exception)
		{
			System.err.printf("\nException thrown: %s\n", exception );
		}
		catch(java.lang.NullPointerException exception)
		{
			System.err.printf("\nException thrown: %s\n", exception );
		}
	}
}


