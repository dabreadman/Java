import java.util.Arrays;

public class Connect4Grid2DArray implements Connect4Grid{

	private static final char EMPTY = '?';
	private static int ROW_SIZE=7;
	private static int COLUMN_SIZE=6;
	char[][]grid;

	Connect4Grid2DArray(int row_size, int column_size){
		ROW_SIZE = row_size;
		COLUMN_SIZE=column_size;
		grid = new char[COLUMN_SIZE][ROW_SIZE];
	}

	public void printGrid() {
		System.out.print(">|");
		for(int n=1;n<=grid[0].length;n++)
			System.out.print(n+"|");
		System.out.println();

		for (int i=0;i<grid.length;i++) {
			System.out.print(i+1+"|");
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(grid[i][j]+"|");
			}
			System.out.println();
		}
	}

	public void emptyGrid() {
		//Arrays.fill(grid, '?');
		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[0].length;j++) {
				grid[i][j]='?';
			}
		}
	}

	public int getRowSize() {
		return ROW_SIZE;
	}

	public int getColumnSize() {
		return COLUMN_SIZE;
	}

	public char[][] getGrid(){
		return grid;
	}

	public String toString() {
		return null;
	}

	public boolean isValidColumn(int column) {
		return (column>=0 && column<ROW_SIZE);
	}

	public boolean isColumnFull(int column) {
		for (int i=0;i<grid.length;i++){
			if (grid[i][column]==EMPTY)
				return false;
		}
		return true;
	}

	public void dropPiece(ConnectPlayer thePlayer, int column) {
		boolean moveMade = false;
		char piece = thePlayer.getPiece();
		for(int i=grid.length-1; i>=0 && !moveMade; i--){
			if (grid[i][column]==EMPTY){
				grid[i][column]=piece;
				moveMade=true;
			}
		}	
	}

	public boolean didLastPieceConnect4() {

		char previous='0';
		int count=0;

		//horizontal
		for (int i=0;i<grid.length;i++){
			previous = '0';
			count=0;
			for (int j=0;j<grid[0].length;j++){
				if (grid[i][j]==previous )
				{
					count++;
					if (count>=4 && previous!=EMPTY)
						return true;
				}
				else{
					previous = (char) grid[i][j];
					count=1;
				}
			}
		}

		//vertical
		for (int i =0;i<grid[0].length;i++){
			previous = '0';
			count=0;
			for (int j=0; j<grid.length;j++){
				if (grid[j][i]==previous )
				{
					count++;
					if (count>=4 && previous!=EMPTY)
						return true;
				}
				else{
					previous = (char) grid[j][i];
					count=1;
				}
			}
		}

		//diagonal '\' 1st column
		for (int i=0;i<grid.length-3;i++){
			previous = '0';
			count=0;
			for (int n=0;i+n<grid.length && n<grid[0].length;n++){
				if (grid[i+n][n]==previous )
				{
					count++;
					if (count>=4 && previous!=EMPTY)
						return true;
				}
				else{
					previous = (char) grid[i+n][n];
					count=1;
				}         
			}
		}

		//diagonal '\' 1st row
		for (int i=1;i<grid[0].length-3;i++){  //first row first column has been calculated 
			previous = '0';
			count=0;
			for (int n=0;n<grid.length && i+n<grid[0].length;n++){
				if (grid[n][i+n]==previous )
				{
					count++;
					if (count>=4 && previous!=EMPTY)
						return true;
				}
				else{
					previous = (char) grid[n][i+n];
					count=1;
				}         
			}
		}

		//diagonal '/' last column
		for (int i= grid.length-1;i>=3;i--){
			previous = '0';
			count=0;
			for (int n=0;i-n>=0 && n<grid[0].length;n++){
				if (grid[i-n][n]==previous )
				{
					count++;
					if (count>=4 && previous!=EMPTY)
						return true;
				}
				else{
					previous = (char) grid[i-n][n];
					count=1;
				}         
			}
		}

		//diagonal '/' first row
		for (int i=grid[0].length-1-1;i>=3;i--){
			previous = '0';
			count=0;
			for (int n=0;i-n>=0 && n<grid.length;n++){
				if (grid[n][i-n]==previous )
				{
					count++;
					if (count>=4 && previous!=EMPTY)
						return true;
				}
				else{
					previous = (char) grid[n][i-n];
					count=1;
				}         
			}
		} 

		return false;
	}

	public boolean isGridFull() {
		for(int i=0;i<grid[0].length;i++){
			if(!isColumnFull(i))
				return false;
		}
		return true;
	}   
}
