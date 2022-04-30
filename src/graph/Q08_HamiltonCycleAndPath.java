package graph;

import java.util.ArrayList;
import java.util.HashSet;

/*
  * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
  * A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in the graph)
    from the last vertex to the first vertex of the Hamiltonian Path.

 Solution : Problem same as 'Finding All Paths', once changes need to be done in base case.
            Only source givne no destination (as all vertex have to be touched)
            Check if all the vertices are visited one, when ever a base case is hit (i.e. A path is found)

            For visited array its convinient to make hasSet for that( easy in counting)
*/
public class Q08_HamiltonCycleAndPath {

    static void printAllHamiltonCycleAndPath(int src, ArrayList<ArrayList<Edge>> graph, HashSet<Integer> visited, String psf, int orgSrc){
        // base condition to check when all points are visited once
        if(visited.size()==graph.size()-1){
            System.out.print(psf);

            // to check is path Hamilton Cycle
            // be checking if last vertex in path has original source as one its neighbour
            for(Edge e: graph.get(src)){
                if(e.neighbour==orgSrc)
                    System.out.println("Hamilton Cyclic Path ");
            }

        }

        visited.add(src);
        for (Edge e: graph.get(src)){
            if (!visited.contains(e.neighbour)){
                printAllHamiltonCycleAndPath(e.neighbour,graph,visited,psf+e.neighbour,src);
            }
        }
        visited.remove(src);
        return;
    }
}
