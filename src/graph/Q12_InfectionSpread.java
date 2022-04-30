package graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/*
Question :  given a graph, representing people and their connectivity.
            also given a src person (who got infected) and time t.
            find how many people will get infected in time t, if the infection spreads to neighbor of infected person in 1 unit of time.

Solution :  Using BFS concept
*/
public class Q12_InfectionSpread {

    public static class Pair{
        int vertex;
        int time;
        Pair(int vertex,int time){
            this.vertex = vertex;
            this.time = time;
        }
    }

    static void countInfectionSpread(ArrayList<ArrayList<Edge>> graph){
        int[] visited = new int[graph.size()];
        Arrays.fill(visited,0);
        // here no need of for loop as the graph given will have single component only.
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(1,0));
        int countInfected = 0;

        while(!queue.isEmpty()){
            Pair p = queue.pop();

            if(visited[p.vertex]==0){
                visited[p.vertex]=p.time; //mark visited  (i.e. assign the time)
                countInfected++; }
            else
                continue;

            for (Edge e : graph.get(p.vertex)){
                if (visited[e.neighbour]==0) // if neighbour not visited add to queue
                    queue.add(new Pair(e.neighbour,p.time+1));
            }
        }

    }
}
