import java.util.Random;
import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{
	C4HumanPlayer(char piece,String name){
		super(piece,name);
	}
	
	public int determineMove(Connect4Grid2DArray gridObj) {
		boolean validAnswer = false;
		//System.out.println("Press enter to start.");
		Scanner inputScanner = new Scanner(System.in);
		int column=-1;
		while(!validAnswer) {
			System.out.println(getName()+"'s turn.\nEnter the column number (1-" + gridObj.getRowSize() + "):\nPiece: "+ getPiece());
		
			if (inputScanner.hasNextInt()) {
				column=inputScanner.nextInt();
				if (column>0 && column<=gridObj.getRowSize()&&!gridObj.isColumnFull(column-1)) {
						validAnswer=true;
				}
				else
					System.out.println("Invalid input!");
			}
			else {
				System.out.println("Invalid input!");
			}		
		}
		return column-1;
	}	
}