package graph;

import javafx.util.Pair;

import java.util.*;

/*
    BFS also known as Level Order Traversal(same as in TREE)
    Traversal of element in increasing radius

    Follow algo : Remove --> Mark Visited --> If not visited --> Perform Action/Work --> Add Neighbours
                                          --> If visited --> Continue

    Time Complexity : O(n)
    Space Complexity : O(n)
*/
public class Q9_BFSTraversal {
    static class Pair{
        int vertex;
        String psf;

        Pair(int vertex, String psf){
            this.vertex = vertex;
            this.psf = psf;
        }
    }

    static void bfsTraversal(ArrayList<ArrayList<Edge>> graph){
        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < visited.length; i++) { // iterating over each vertex to handle multiple components case
            if (visited[i] == false) {
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(i,i+""));

                while(queue.size()>0){
                    Pair p = queue.poll(); //1. remove from queue

                    if(visited[p.vertex]==true)  // 2. Check visited, if visited continue else mark visited
                        continue;
                    else
                        visited[p.vertex] = true;

                    System.out.println(p.vertex +'@'+p.psf); // 3. Perform work/operation

                    for(Edge e: graph.get(i)){ // 4. Add neighbours
                        if(visited[e.neighbour]==false)
                            queue.add(new Pair(e.neighbour,p.psf+e.neighbour));
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graphConnected = new ArrayList<>();
        graphConnected.add(new ArrayList<>(Arrays.asList(1,3)));
        graphConnected.add(new ArrayList<>(Arrays.asList(0,2)));
        graphConnected.add(new ArrayList<>(Arrays.asList(1,3)));
        graphConnected.add(new ArrayList<>(Arrays.asList(0,2,4)));
        graphConnected.add(new ArrayList<>(Arrays.asList(3,5,6)));
        graphConnected.add(new ArrayList<>(Arrays.asList(4,6)));
        graphConnected.add(new ArrayList<>(Arrays.asList(4,5)));
//        bfsTraversal(graphConnected);

        System.out.println("-------------------------");

        ArrayList<ArrayList<Integer>> graphComponents = new ArrayList<>();
        graphComponents.add(new ArrayList<>(Arrays.asList(1,3)));
        graphComponents.add(new ArrayList<>(Arrays.asList(0,2)));
        graphComponents.add(new ArrayList<>(Arrays.asList(1,3)));
        graphComponents.add(new ArrayList<>(Arrays.asList(0,2)));
        graphComponents.add(new ArrayList<>(Arrays.asList(5,6)));
        graphComponents.add(new ArrayList<>(Arrays.asList(4,6)));
        graphComponents.add(new ArrayList<>(Arrays.asList(4,5)));
//        bfsTraversal(graphComponents);

    }
}
