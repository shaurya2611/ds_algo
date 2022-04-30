package graph;

/*
Prim's Algorithm :  Prim's algorithm (also known as Jarník's algorithm) is a greedy algorithm
                    that finds a minimum spanning tree for a weighted undirected graph.
                    This means it finds a subset of the edges that forms a tree that includes every vertex,
                    where the total weight of all the edges in the tree is minimized.

Spanning Tree : Drawing tree from the graph consisting of N nodes and N-1 edges, with all nodes connected(acyclic)
                Such graph have 'N' nodes and 'N-1' edges and every node is accessible through another

Minimum Spanning Tree : Out of the all possible spanning tree from graph , drawing spanning tree with minimum cost of weight

Solution : Same as Dijkstra Algo (i.e. Same as BFS with min priority queue)
            In place of psf add the previous parent node and only current weight not summation of weight
Similar Ques : Connecting all PCs with LAN wire, such thar length wire used is shortest.
 */


import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q14_PrimsAlgorithm {

    public static class Pair implements Comparable<Pair>{
        Integer vertex;
        Integer acquiringVertex;
        Integer weight;

        public Pair(Integer vertex, Integer acquiringVertex,Integer weight){
            this.vertex = vertex;
            this.acquiringVertex = acquiringVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o){
            return this.weight - o.weight;
        }
    }

    public static void primsAlgo(ArrayList<ArrayList<Edge>> graph){
        boolean[] visited = new boolean[graph.size()];
        PriorityQueue<Pair> priQueue = new PriorityQueue<>();
        priQueue.add(new Pair(0,-1,0));

        while(!priQueue.isEmpty()){
            Pair p = priQueue.remove();// 1. Remove

            if (visited[p.vertex]) continue; //2. If marked Visited continue
            else visited[p.vertex] = true; // 2. Else mark visited

            System.out.println("Node : "+p.vertex+ " , Acquired By :  "+p.acquiringVertex+" @ "+p.weight);// 3. Perform Work

            for (Edge e: graph.get(p.vertex)){// 4. Adding neighbours
                if (!visited[p.vertex])
                    priQueue.add(new Pair(e.neighbour,p.vertex, e.distance));
            }
        }
    }
}
