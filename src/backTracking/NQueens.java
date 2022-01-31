package backTracking;

public class NQueens {
	
	/* In n*n shape of chess board place 'n' queens such that they never intersect each other 
	 * Solution - Start approaching  by trying to all the possible ways to fill baord with n queens 
	 * 			  without applying any restriction.
	 * 			  After that apply the valid place  check*/

	public static void NQueenPlace(int[][] chess, String queenPlace, int row) {
		
		if(row == chess.length) {
			System.out.println(queenPlace);
			return;
		}
			
		for (int col = 0; col < chess.length; col++) {
			if(isValidPlace(chess,row,col)) {
				chess[row][col] = 1; // marking it as visited cell can't be revisited
				NQueenPlace(chess, queenPlace + row+"-"+col+", ", row+1);
				chess[row][col] = 0; // freeing cell, can be revisited
			}
		}
	}
	
	public static boolean isValidPlace(int[][] chess, int row, int col) {
		//cheching all the places where queen can move on board
		for (int i = row-1; i>=0; i--) {
			if(chess[i][col]==1)
				return false; } 
			
		for (int i1 = row-1, j = col-1; i1>=0 && j>=0; i1--, j--) {
			if(chess[i1][j]==1)
				return false; }
		
		for (int i2 = row-1, j2 = col+1; i2 >=0 && j2 <chess.length; i2--,j2++) {
			if(chess[i2][j2]==1)
				return false; }
		
		
		return true;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] chess = new int[4][4];
		NQueenPlace(chess, "", 0);

	}

}
