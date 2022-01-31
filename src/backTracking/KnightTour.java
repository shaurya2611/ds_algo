package backTracking;

public class KnightTour {

	/* Given a chess board n*n, find all possible ways such that a knight can travel 
	 * each and every cell of chess board
	 * Given knight can't revisit once visited cell*/
	public static void knightMove(int[][] chess, int row, int col, int move) {
		
		if(row<0 || col<0 | row>=chess.length || col>=chess.length || chess[row][col]>0 )
			return;
		else if(move == chess.length*chess.length) {
			chess[row][col] = move;
//			dispplayBoard(chess);
			chess[row][col]=0;
		}
		// calling recursion on all the possible moves knight can make on chess board
		chess[row][col] = move;
		knightMove(chess,row-2,col+1,move+1);
		knightMove(chess,row-1,col+2,move+1);
		knightMove(chess,row+1,col+2,move+1);
		knightMove(chess,row+2,col+1,move+1);
		knightMove(chess,row+2,col-1,move+1);
		knightMove(chess,row+1,col-2,move+1);
		knightMove(chess,row-1,col-2,move+1);
		knightMove(chess,row-2,col-1,move+1);
		chess[row][col]=0;
	}
	
	public static void dispplayBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				System.out.print(chess[i][j]+"\t");
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		
		int n = 8;
		int[][] chess = new int[n][n];
		knightMove(chess,2,3,0);
			

	}

}
