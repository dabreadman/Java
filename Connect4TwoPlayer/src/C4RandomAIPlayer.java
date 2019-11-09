import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {

	C4RandomAIPlayer(char piece,String name){
		super(piece,name);
	}
	
	public int determineMove(Connect4Grid2DArray gridObj) {
		char[][]grid = gridObj.getGrid();
		Random generator = new Random();
		int column=-1;
		int middle = (int)grid[0].length/2;
		//if middle is still possible for human to win
		char test = getPiece();
		if (grid[grid.length-3][middle]!=getPiece() &&grid[grid.length-3-1][middle]!=getPiece())
			column=middle;
		else{
			boolean possible=true;
			for(int i=0;i<grid[0].length;i++){
				if (!gridObj.isColumnFull(i)){
					possible = true;
					char lastPiece = '@';
					for (int j=0;j<grid.length;j++){
						//if the highest piece is human
						char test2=getPiece();
						if (grid[j][i]!=EMPTY&&lastPiece==EMPTY&&grid[j][i]!=getPiece()) {
							column = i;
						}
						//set last piece
						else{
							lastPiece = grid[j][i];
						}
					}
				}
			}
		}
		if (column==-1)
		column = generator.nextInt(grid[0].length);
		
		System.out.println(getName()+" chose column "+(column+1)+"\nPiece: "+getPiece());
		return column;
	}	
}