import java.util.Scanner;
import javax.swing.JOptionPane;

public class TestClient {

	public static void main (String[]args){
		try{
			Rational a = getInput("Rational a: Enter a rational number in fractions (1/2 for 0.5):");
			Rational b = getInput("Rational a: Enter a rational number in fractions (1/2 for 0.5):");
			Rational result =  new Rational(0);

			System.out.println("Number a: " + a.toString());
			System.out.println("Number b: " + b.toString());

			result = a.add(b);
			result.simplify();
			System.out.println("Addition result: " +result.toString());

			result = a.substract(b);
			result.simplify();
			System.out.println("Substraction result: "+result.toString());

			result = a.multiply(b);
			result.simplify();
			System.out.println("Multiplication result: "+ result.toString());

			result = a.divide(b);
			result.simplify();
			System.out.println("Division result: "+result.toString());

			System.out.println("Both numbers equal? "+a.isEqual(b));

			System.out.println("Number a is lesser than number b? "
			+a.isLessThan(b));

		}
		catch(java.lang.NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Thank you!");
		}
	}
	//takes input from user using JOptionPane and returns Rational for valid input
	public static Rational getInput(String message){
		String errorMessage="Error, invalid input!";
		boolean inputValid=false;
		int numerator=0;
		int denominator=0;
		while(!inputValid)
		{
			String paneInput = JOptionPane.showInputDialog
					(message);
			Scanner scanner = new Scanner(paneInput).useDelimiter("/");

			if (scanner.hasNextInt())
			{
				numerator = scanner.nextInt();

				if (scanner.hasNext()){
					if (scanner.hasNextInt())
					{
						denominator = scanner.nextInt();
						if (denominator !=0)
							inputValid = true;
					}
					else
						JOptionPane.showMessageDialog(null, errorMessage);
				}
				else
				{
					inputValid=true;
					denominator = 1;
				}
			}
			else
				JOptionPane.showMessageDialog(null, errorMessage);
		}
		Rational rational = new Rational(numerator,denominator);
		return rational;
	}
}
