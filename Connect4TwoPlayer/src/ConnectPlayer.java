public abstract class ConnectPlayer {
	public static final char EMPTY = '?';
	private char piece;
	private String name;
	ConnectPlayer(char piece, String name){
		this.piece = piece;
		this.name = name;
	}
	
	public abstract int determineMove(Connect4Grid2DArray gridObj);
	
	public char getPiece() {
		return piece;
	}
	
	public String getName() {
		return name;
	}
}

