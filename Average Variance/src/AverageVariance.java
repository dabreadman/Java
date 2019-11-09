import java.util.Scanner;

public class AverageVariance.java {

	public static void main (String[]args)
	{
		double counter,average,lastAverage,variance,number;
		average = 0.0;
		lastAverage= 0.0;
		variance = 0.0;
		number = 0.0;
		counter = 0.0;

		System.out.print("This program computes the average and variance of all numbers entered."
				+ "\n\nEnter a number (or type 'exit' ): ");

		boolean exit = false;
		while (!exit)
		{
			Scanner input = new Scanner(System.in);
			if(input.hasNextDouble())
			{
				++counter;
				lastAverage = average;
				number = input.nextDouble();
				average = lastAverage + (number - lastAverage)/ counter;
				variance = (variance * (counter -1) + (number - lastAverage ) 
						* (number - average))/counter;

				System.out.print("\nSo far the average is " + average
						+ " and the variance is " + variance +"."
						+"\n\nEnter another number (or type 'exit'): ");
			}

			else if (input.hasNext("exit") || input.hasNext("quit"))
			{
				System.out.println("\nGoodbye.");
				exit = true;
			}

			else
				System.out.print("\nError, please enter a valid value or command."
						+ "\n\nNote: Input is case-sensitive. \n");
		}

	}
}
