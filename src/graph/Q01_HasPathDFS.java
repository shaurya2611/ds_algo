package graph;

import java.util.ArrayList;

public class Q01_HasPathDFS {

/* Given two points i.e. source and destination, find is the path exists between those two points
*  Using Depth First Search (DFS)
* */


    static boolean hasPath(int src, int dest, ArrayList<ArrayList<Edge>> graph,boolean[] vertcies){
        if (src==dest)
            return true;
        // check to avoid repetitive loops
        vertcies[src] = true;
        // iterating over all the neighbour node(connecting edges) of a node
        for ( Edge e: graph.get(src)){
            // if already a point is visited don't visit that again
             if(vertcies[e.neighbour]==false){
                 boolean pathFound = hasPath(e.neighbour,dest,graph,vertcies);
                 if (pathFound==true)
                     return  true;
             }
        }
        return false;
    }

    public static void main(String args[]){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        boolean vertices[] = new boolean[graph.size()];
        int src =3; int dest=6;
        hasPath(src,dest,graph,vertices);
    }
}
