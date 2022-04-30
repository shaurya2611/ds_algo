package graph;

import java.util.*;

/*
Bipartite : Theory-1 :
            or BIGRAPH, whose vertices can be divided into two disjoint and independent sets and ,every edge connects a vertex in to one in.
            If cycle of graph ODD length --> never bipartite.
            Every non-cyclic graph is bipartite.

Solution 1 : In case of non-cyclic graph --> bipartite always
                                            Apply BFS (BFS travel is level wise). So alternatively put same level elements in same set
            In case of cyclic graph --> Even length -- bipartite always (in case more than once cycle, all cycles has to be even length)
                                    --> Odd length --  non-bipartite always

             ** Above contions stand still in form of "AND" oprator, if more than one cycle or type of graph in a graph

*/
public class Q11_BipartiteGraph {

    public static class Pair{
        int vertex;
        String psf;
        int level;
        Pair(int vertex,String psf, int level){
            this.vertex = vertex;
            this.psf = psf;
            this.level = level;
        }
    }

    static boolean isBipartiteGraph(ArrayList<ArrayList<Edge>> graph){
        int[] visited = new int[graph.size()];
        Arrays.fill(visited,-1); // -1 to represent not visited

        for (int i=0;i< graph.size();i++){
            if(visited[i]==-1){
                ArrayDeque<Pair> queue = new ArrayDeque<>();
                queue.add(new Pair(i,i+"",0));
                while (!queue.isEmpty()){
                    Pair p = queue.pop(); // 1. remove

                    if(visited[p.vertex]!=-1) { // 2. If already visited, cyclic graph condition
                        // check weather visited at same level or different, if visited at same level --> bipartite , else non-bipartite
                        if(p.level != visited[p.vertex])
                            return  false; // i.e. odd cyclic --> non-bipartite
                    }else
                        visited[p.vertex] = p.level; // 2. mark visited --> fill its level

                    // 3. work any if required (bipartite sets can be made)

                    for(Edge e : graph.get(p.vertex)){  // 4. Add unvisited neighbours
                        if(visited[e.neighbour]==-1)
                            queue.add(new Pair(e.neighbour,p.psf+e.neighbour,p.level+1));
                    }
                }
            }
        }
        return true;
    }


    /*
     Theory-2 :
     Graphs which can be coloured using two clours such that, no two adjacent nodes have same colour

     Solution :

*/

    static boolean isBipartiteGraph_2(ArrayList<ArrayList<Edge>> graph){
        int[] colourTrack = new int[graph.size()+1];
        Arrays.fill(colourTrack,-1); // initially filling array with -1 i.e no colour, 1--> Black, 0 --> White

        for (int i =1;i<= graph.size();i++) {
            if (colourTrack[i] == -1){ // check if already coloured
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                colourTrack[i] = 1;
                while (!queue.isEmpty()) {
                    Integer node = queue.peek(); // main node
                    for (Edge e: graph.get(node)){ // neighbours
                        if(colourTrack[e.neighbour]==-1){
                            colourTrack[e.neighbour] = Math.abs(1-colourTrack[node]);// marking colour opposite to of main node
                            queue.add(e.neighbour);
                        }else if(colourTrack[e.neighbour] == colourTrack[node]) //checking if main node and neighbour of same colour return false
                                return false;
                    }
                }
             }
        }
        return true;
    }
}
