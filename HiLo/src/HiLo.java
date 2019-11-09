import java.util.Scanner;
import java.util.Random;

public class HiLo {

	public static final int MAX_NUMBER = 14;  //Ace is considered largest in this program, assigned the value of 14;
	public static final int MIN_NUMBER = 2;
	public static final int RANGE = MAX_NUMBER - MIN_NUMBER;

	public static void main(String[] args) {
		Random generator = new Random();
		Scanner guess = new Scanner(System.in);

		int genCard1,genCard2;
		String printCard = "";

		int count = 0;
		boolean success = false;

		while(!success)
		{
			genCard1 = generator.nextInt(RANGE+1)+MIN_NUMBER;
			genCard2 = generator.nextInt(RANGE+1)+MIN_NUMBER;
			boolean correct = true;

			if (genCard1 < 11)
				printCard = "" + genCard1;
			if (genCard1 == 11)
				printCard = "Jack";
			if (genCard1 == 12)
				printCard = "Queen";
			if (genCard1 == 13)
				printCard = "King";
			if (genCard1 == 14)
				printCard = "Ace";

			System.out.print("The card is a " + printCard +
					"\nDo you think the next card will be higher, lower or equal?");

			if (guess.hasNext("higher")||guess.hasNext("lower")||guess.hasNext("equal"))
			{
				String guessString = guess.next();
				guessString = guessString.replaceAll("\\s",""); //Deals with space and/or enter.

				if (guessString.equals("higher") == true)
					if(genCard2 < genCard1)
						correct = false;
				if (guessString.equals("lower") == true)
					if(genCard2 > genCard1)
						correct = false;
				if (guessString.equals("equal") == true)
					if(genCard2 != genCard1)
						correct = false;

				if(!correct)
				{
					if (genCard2 == 11)
						printCard = "Jack";
					if (genCard2 == 12)
						printCard = "Queen";
					if (genCard2 == 13)
						printCard = "King";
					if (genCard2 == 14)
						printCard = "Ace";
					else
						printCard = ""+genCard2;
					System.out.print("\nYou have guessed wrongly. The card is a " + printCard
							+"\nYou have gotten " + count + " correct."
							+"\nPlease try again.\n\n"
							+"----------------\n");
					count = 0;
				}

				else
					++count;
				if (count == 4)
					success = true;
				genCard1= genCard2;
			}

			else
			{
				System.out.print("\n!\n!\n!\n!\n!Invalid input. Please restart the program.\n!\n!");
				System.exit(0);
				String junk = guess.next();
			}

		}
		System.out.print("Congratulations.  You got them all correct.");
	}

}
