package graph;

/*
Theory: To find the shortest path between source and every other node of graph

Solution : Same as BFS, only differebce in place of Queue use Min. Priority Queue.
 */


import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q13_DijkstraAlgorithm  {

    public static class Pair implements Comparable<Pair>{ // implements Comparable<Pair> to make priority queue compare the weights
        Integer vertex;
        String psf ;
        Integer weight;

        public Pair(Integer vertex,String psf,Integer weight){
            this.vertex = vertex;
            this.psf = psf;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) { // this funtion has to be implemented
            return this.weight - o.weight;
        }
    }

    public static void dijkstraAlgo(ArrayList<ArrayList<Edge>> graph, int source){
        boolean[] visited = new boolean[graph.size()];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source,source+"",0));
        while (!pq.isEmpty()){
            Pair p = pq.remove(); //1. Remove
            if (visited[p.vertex]) continue;// 2. Check visited
            else visited[p.vertex]= true; // 2. MArk Visited

            System.out.println(p.vertex+" via "+p.psf+" @ "+ p.weight ); // 3. work

            for (Edge e : graph.get(p.vertex)){ // 4. Add neighbour
                if (!visited[e.neighbour])
                    pq.add(new Pair(e.neighbour, p.psf+e.neighbour,p.weight+e.distance ));
            }
        }
    }


}
