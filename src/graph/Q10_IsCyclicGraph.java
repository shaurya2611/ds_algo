package graph;

/*
  A cyclic graph is a graph containing at least one graph cycle. A graph that is not cyclic is said to be acyclic.
  A cyclic graph possessing exactly one (undirected, simple) cycle is called a unicycle graph.
  Cyclic graphs are not trees. A cyclic graph is bipartite iff all its cycles are of even length

  Solution: Same as BFS, just check if a particular vertex which is added in queue and is already visited
            i.e. there are two ways to reach that point, hence graph is cyclic
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q10_IsCyclicGraph {

    public static class Pair{
        int vertex;
        String psf;
        Pair(int vertex,String psf){
            this.vertex = vertex;
            this.psf = psf;
        }
    }

    static boolean isCyclic(ArrayList<ArrayList<Edge>> graph){
        boolean[] visited = new boolean[graph.size()];
        for (int i=0;i< graph.size();i++){
            if(!visited[i]){
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(i,i+""));

                while(!queue.isEmpty()){
                    Pair p = queue.poll(); //1. remove from queue

                    if(visited[p.vertex]==true) // 2. Check visited, if visited continue else mark visited
                        return  true; // i.e. graph is cyclic
                    else
                        visited[p.vertex] = true; // else mark visited

                    System.out.println(p.vertex +'@'+p.psf); // 3. Perform work/operation

                    for(Edge e: graph.get(i)){ // 4. Add neighbours if they are not visited
                        if(visited[e.neighbour]==false)
                            queue.add(new Pair(e.neighbour,p.psf+e.neighbour));
                    }
                }

            }
        }

        return false;
    }

}
