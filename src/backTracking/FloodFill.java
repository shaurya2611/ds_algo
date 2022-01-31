package backTracking;

public class FloodFill {

	/* -----...............-BACKTRACKING ALGO------------------------
	 *  Step 1 − if current_position is goal, return success
		Step 2 − else,
		Step 3 − if current_position is an end point, return failed.
		Step 4 − else, if current_position is not end point, explore and repeat above steps.
	*
	*Problem- To find all non repeating paths from source to destination such that
	*			4 direction movement is possible at a time-- t - l - d - r
	*			One step at a time.
	*			 You can't move out of the boundaries or in the cells which have value 1 in them (1 means obstacle)
	*
	*Solution - A track of movement/visited blocks has to be kept, hence array will pe passed in fn 
	*			argument, thus backtracking.	*
	*/
	
	public static void mazePath(int[][] maze, int row, int column, String pathSoFar, boolean[][] trackPath) {
		
		/* Considering all invalid moves- starting 4 condiotns if move is out of mazr, if obstacle in path, if column already visited*/
		if(row<0 || column<0 || row>maze.length || column>maze[0].length || maze[row][column]==1 || trackPath[row][column]==true)
			return;
		
		//induction
		if(row==maze.length-1 && column==maze[0].length-1)
			System.out.println(pathSoFar);
		
		//Hypothesis (t-l-d-r) movement
		trackPath[row][column] = true; // to mark that block is visited
		mazePath(maze, row-1, column, pathSoFar+"t", trackPath);
		mazePath(maze, row, column+1, pathSoFar+"l", trackPath);
		mazePath(maze, row+1, column, pathSoFar+"d", trackPath);
		mazePath(maze, row, column+1, pathSoFar+"r", trackPath);
		trackPath[row][column] = false; // to mark block not visited when a complete 4 call are been made so as to make path available for otherss
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 6;
		int column = 5;
		boolean[][] trackPath = new boolean[row][column]; // all eleemnt initialized to false by deafult

	}

}
