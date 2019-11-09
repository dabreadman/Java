import java.util.Scanner;

public class Connect4Game {

	public static final int SINGLE = 1;
	public static final int DOUBLE = 2;
	public static final char EMPTY='?';


	public static void main (String[]args){
		Connect4Grid2DArray gridObj = new Connect4Grid2DArray(7,6);
		gridObj.emptyGrid();

		Scanner scanner = new Scanner(System.in);
		ConnectPlayer[] players = new ConnectPlayer[2];

		System.out.println("Enter '1' for single player\nEnter '2' for two players");
		if(scanner.hasNextInt()){
			int choice = scanner.nextInt();

			if(choice==SINGLE||choice==DOUBLE) {

				if (choice==SINGLE){
					players = new ConnectPlayer[] {new C4RandomAIPlayer('X',"Computer"),new C4HumanPlayer('Y',"Player")};
				}
				else if(choice==DOUBLE){
					players = new ConnectPlayer[] {new C4HumanPlayer('X',"Player 1"),new C4HumanPlayer('Y',"Player 2")};
				}

				int player = 0;
				int column = -1;
				boolean win=false;

				while(!win && !gridObj.isGridFull()) {
					System.out.println("Current grid");
					gridObj.printGrid();
					column = players[player].determineMove(gridObj);
					gridObj.dropPiece(players[player], column);            	
					if(gridObj.didLastPieceConnect4()) {
						win=true;
					}
					else {
						if(player==0)
							player=1;
						else
							player=0;
					}
					System.out.println();
				}    
				gridObj.printGrid();
				if (win = true)
				System.out.println(players[player].getName()+" has won!");
				else
					System.out.println("Game ended in a draw!");
			}
			else{
				System.out.println("Invalid input");
			}
		}
		else{
			String junk=scanner.next();
			System.out.println("Invalid input");
		}
	}
}
