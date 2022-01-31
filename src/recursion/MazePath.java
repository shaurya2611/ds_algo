package recursion;

import java.util.ArrayList;

public class MazePath {
	
	//Using only HORIZINTAL and VERTICAL motion reach from starting to destination
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		
		//base condition
		if(sr==dr && sc==dc) {
			ArrayList<String> p = new ArrayList<>();
			p.add("");
			return p;
		}
		//Hypothesis (Assuming as we have TWO CHOICES only)
		ArrayList<String> hr = new ArrayList<>();
		ArrayList<String> vr = new ArrayList<>();
		if(sc<dc)
			hr = getMazePaths(sr, sc+1, dr, dc);
		if(sr<dr)
			vr = getMazePaths(sr+1, sc, dr, dc);
		//Induction
		ArrayList<String> paths = new ArrayList<>();
		for(String item : hr)
			paths.add("h"+item);
		for(String item : vr)
			paths.add("v"+item);
        return paths;
    }
	
	
	//Above function have 2^n space complexity as we were storing the data in Array list,
	//Here EULER method of recursion to get the ans for each branch
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		if(sr > dr || sc > dc){
            return;
        }
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> p = getMazePaths(0, 0, 3, 3);
		System.out.println(p);
		System.out.println(p.size());
//		printMazePaths(0, 0, 3, 3, "");

	}

}
