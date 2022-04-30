package graph;

import java.util.ArrayList;

/*
Question : Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
            An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
            You may assume all four edges of the grid are all surrounded by water.

Example : ["1","1","0","0","0"],
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]    --> 3 islands

Solution : Problem is solved same as 'Connected Components' problem.
            Diff is, here 2D array is given in form of graph, where every cell is a vertex. And each cell can be connected in
            noeth, south , east and west.

            Thus, no of island = no of connected components.

            Visit all the vertex (ony island one) and try to crate the tree for that, that will give the component .
            Mark the  visited once and finally count the no of connected components (here no need to add components).
* */
public class Q06_CountNumberOfIsland {


    static void countOfIsland(int[][] graph){
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int countIsland = 0;
        // Two for loops, to iterate over each vertex
        for (int i = 0; i<graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                // considering only vertex who are Land(i.e. 0) and vertex thosea re not visited earlier
                if(graph[i][j]==0 && !visited[i][j]){
                    drawTreeAndGenerateComponents(i,j,graph,visited);
                    countIsland++;
                }
            }
        }

    }

    // fn same as ConnectedComponents
    /*
     * Mark the source as visisted
     * Add the components (not requited here)
     * Call on all the neighbours (here each cell has 4 neighbours thus 4 call)
     * */
    static void drawTreeAndGenerateComponents(int i, int j, int[][] graph, boolean[][] visited) {
        // base condition
        if(i<0 || i> graph.length || j<0 || j> graph[0].length || graph[i][j]==1 || visited[i][j])
            return;

        visited[i][j] = true;

        // Calling in all the neighboiurs of the cell (boundary conditions handled in base condition above)
        drawTreeAndGenerateComponents(i+1,j,graph,visited);
        drawTreeAndGenerateComponents(i-1,j,graph,visited);
        drawTreeAndGenerateComponents(i,j+1,graph,visited);
        drawTreeAndGenerateComponents(i,j-1,graph,visited);

    }


    public static void main(String[] args){
        int[][] graph ;
//        countOfIsland(graph,visisted);

    }
}
