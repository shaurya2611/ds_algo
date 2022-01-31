package recursion;

import java.util.ArrayList;

public class MazePathWithJump {


	/* In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ),
	 *  or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
	 *  Start from 0,0
	 *  
	 *  Objective is to get all the possible path --> when traveled source to destination with available moves are horizontal ,
	 *  											  vertical and diagonal any no of steps*/
	
	    // sr - source row , sc - source column
	    // dr - destination row , dc - destination column
	    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
	        //Base Case
	        if(sr==dr && dc==sc){
	            ArrayList<String> p = new ArrayList<>();
	            p.add("");
	            return p;
	            
	        }
	        
	        //Any no of steps can be takn in a particular direction
	        ArrayList<String> paths = new ArrayList<>();
	        
	        
	        // for horizontal paths- column
	        for(int h=1; h<=(dc-sc); h++){ 
	            ArrayList<String> hpaths = getMazePaths(sr,sc+h,dr,dc);
	            for(String item : hpaths)
	                paths.add("h"+h+item);
	        }
	        // for vertical paths - row 
	        for(int v=1; v<=(dr-sr); v++){ 
	            ArrayList<String> vpaths = getMazePaths(sr+v,sc,dr,dc);
	            for(String item : vpaths)
	                paths.add("v"+v+item);
	        }
	        // for diagonal paths - both in row and column
	        for(int d=1; d<=(dr-sr) && d<=(dc-sc); d++){ 
	            ArrayList<String> dpaths = getMazePaths(sr+d,sc+d,dr,dc);
	            for(String item : dpaths)
	                paths.add("d"+d+item);
	        }
	        
	        return paths;
	        
	        
	    }


	
	
	public static void main(String[] args) {
        ArrayList<String> paths = getMazePaths(0,0,4,4);
        System.out.println(paths);

	}

}
