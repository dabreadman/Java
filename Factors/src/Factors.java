import java.util.Scanner;

public class Factors {

	public static void main(String[]args)
	{
		try{
			boolean quit = false;
			Scanner scanner =  new Scanner(System.in);
			while (!quit)
			{
				System.out.print("Please enter a positive whole number: ");
				int number = scanner.nextInt();
				if (number< 0)
				{
					System.out.print("Positive number only."
							+"\nProgram terminated.");
					System.exit(0);
				}
				System.out.print("The factors of " + number + " are ");

				int factor,anotherFactor;
				anotherFactor = -1;
				int prime = -1;

				for (factor = 1; factor <= number/4 ;factor++)
				{
					if (number%factor == 0 )
					{	
						anotherFactor = number / factor;


						if (factor < anotherFactor)
						{

							String commaOrEnd = (number/(factor+1) >factor && number%(factor+1)==0)? ", ":". ";
							System.out.print(factor + "x" +anotherFactor + commaOrEnd);
							++prime;

						}	
					}
				}

				if (prime != 0)
					System.out.print("\n" + number + " is not prime number.\n\n");
				else
					System.out.print("\n" + number + " is prime number.\n\n");
			}
		}
		catch
		(java.util.InputMismatchException exception)
		{
			System.err.printf("Error %s", exception);
		}
	}
}


