package graph;

import java.util.ArrayList;

public class Q03_MultiSolverPath {
    /* For the given set of points find the following paths :
        1. Smallest Path from source vertex to destination vertex
        2. Largest Path from source vertex to destination vertex
        3. Ceil Path or Just Larger Weighted Path than a target.
        4. Floor Path or Just Smaller Weighted Path than a target.
        5. Kth Largest Path from source to destination.

    Solution : Above problem is same as, finding all the paths.
                Only the changes has to be done in base condition
    * */
    static String smallestPath = "";
    static Integer smallestPathWeight = Integer.MAX_VALUE;
    static String largestPath = "";
    static Integer largestPathWeight = Integer.MIN_VALUE;
    static String ceilPath = "";
    static Integer ceilPathWeight = Integer.MAX_VALUE;
    static String floorPath = "";
    static Integer floorPathWeight = Integer.MIN_VALUE;

    static void printAllPath(int src, int dest, ArrayList<ArrayList<Edge>> graph, boolean[] vertices, String psf,int wsf,int criterion){
        if (src==dest){
            // whenever base case is hit, one way has been found hence all the calculation to be done here

            // 1. for smallest path
            if(smallestPathWeight < wsf){
                smallestPath = psf;
                smallestPathWeight = wsf;
            }

            // 2. for largest path
            if(largestPathWeight > wsf){
                largestPath = psf;
                largestPathWeight = wsf;
            }

            // 3.ceil Path --> smallest among all the largest i.e. finding smallest but grater than criterion
            if (criterion > wsf && ceilPathWeight < wsf){
                ceilPath = psf;
                ceilPathWeight = wsf;
            }

            // 4. floor path --> finding largest but smaller than criterion
            if (criterion < wsf && ceilPathWeight > wsf){
                floorPath = psf;
                floorPathWeight = wsf;
            }

            // 5. Kth largest/smallest can be find out using the priority queue.
            System.out.println(psf);
            return;
        }

        vertices[src] = true;
        for (Edge e : graph.get(src)){
            if (vertices[e.neighbour]==false){
                printAllPath(e.neighbour,dest,graph,vertices,psf+e.neighbour,wsf+e.distance, criterion);
            }
        }
        vertices[src] = false;
        return;
    }



    public static void main(String args[]){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        boolean vertices[] = new boolean[graph.size()];
        int src =3; int dest=6;
        int criterion = 40; // for ceil and floor
        printAllPath(src,dest,graph,vertices,src+"",0,criterion);
    }
}
