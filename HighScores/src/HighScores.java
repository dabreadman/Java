import java.util.Arrays;
import java.util.Scanner;

public class HighScores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			System.out.print("Amount of high scores to be maintained: ");
			Scanner input = new Scanner(System.in);

			int lengthOfHighScores = input.nextInt();
			int[]highScores = new int[lengthOfHighScores];
			initialiseHighScores(highScores);

			int nextNumber = 0;
			while(true)
			{
				System.out.print("\nEnter the next number: ");
				nextNumber = input.nextInt();
				if(higherThan (highScores,nextNumber))
					insertScore(highScores,nextNumber);
				printHighScores(highScores);
			}
		}
		catch(java.util.InputMismatchException exception)
		{
			System.err.print(exception
					+"\nWrong input.");
		}
		catch(java.lang.NegativeArraySizeException exception)
		{
			System.err.print(exception 
					+"\nThe size of array should be larger than 0.");
		}
	}

	/**
	V.initialiseHighScores () which sets all high scores to zero.
	V.printHighScores() which prints the high scores in the format: “The high scores are 345, 300, 234”, for all existing high scores in the list (remember that sometimes it won’t be full).
	V.higherThan() which takes the high scores and a new score and returns whether the passed score is higher than any of those in the high score list.
	V.insertScore() which takes the current high score list  and a new score and updates it by inserting the new score at the appropriate position in the list
	 */
	public static void initialiseHighScores(int[]highScores)
	{
		Arrays.fill(highScores,0);
	}
	public static void printHighScores(int[]highScores)
	{
		String printHighScores = "\nThe high scores are ";
		for (int i = 0;i< highScores.length;i++)
			printHighScores += (highScores[i]+(i==highScores.length-1? "":", "));
		System.out.print(printHighScores);
	}

	public static boolean higherThan(int[]highScores,int newHighScore)
	{
		for (int i = 0; i< highScores.length;i++)
			if (newHighScore > highScores[i])
				return true;
		return false;
	}

	public static void insertScore(int[]highScores,int nextNumber)
	{
		boolean completedInsert = false;
		for (int i = 0; i< highScores.length && !completedInsert;i++)
		{
			if (nextNumber >= highScores[i])
			{
				for (int lastIndex = 1; lastIndex < highScores.length-i ;lastIndex++)
				{
					int index  = highScores.length-lastIndex;
					highScores[index]=highScores[index-1];
				}
				highScores[i]= nextNumber;
				completedInsert = true;
			}
		}
	}
}
