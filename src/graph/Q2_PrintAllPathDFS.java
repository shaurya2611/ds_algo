package graph;

import java.util.ArrayList;

public class Q2_PrintAllPathDFS {

    /* Given two points i.e. source and destination, print all the path exists between those two points
    *  Using Depth First Search (DFS)
    * */
    static void printAllPath(int src, int dest, ArrayList<ArrayList<Edge>> graph,boolean[] vertices, String psf){
        if (src==dest){
            System.out.println(psf);
            return;
        }

        vertices[src] = true;
        for (Edge e : graph.get(src)){
            if (vertices[e.neighbour]==false){
                printAllPath(e.neighbour,dest,graph,vertices,psf+e.neighbour);
            }
        }
        vertices[src] = false;
        return;
    }



    public static void main(String args[]){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        boolean vertices[] = new boolean[graph.size()];
        int src =3; int dest=6;
        printAllPath(src,dest,graph,vertices,src+"");
    }
}
