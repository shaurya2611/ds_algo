package recursion;


public class MazePathWithJumpPrint {
	
	public static void maxePathJumpPrint(int srow, int scol, int drow, int dcol, String path) {
		if(srow>drow || scol>dcol) return;
		
		if(srow==drow && scol==dcol) System.out.println(path);
		
		for(int i=1;i<=drow-srow;i++) // for horizontal jump
			maxePathJumpPrint( srow+i,  scol,  drow,  dcol,  "h"+i+path);
		
		for(int i=1;i<=dcol-scol;i++) // for vertical jump
			maxePathJumpPrint( srow,  scol+i,  drow,  dcol,  "v"+i+path);
	}
	
	public static void main(String[] args) {
		maxePathJumpPrint(1, 1, 3, 3, "");
	
	}
}
