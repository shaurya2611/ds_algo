package graph;

import java.util.ArrayList;

/* Question : for the given graph, find an array of all connected components.
            Given graph --> vertices = 7, edges = 5,
            0-1-10
            2-3-10
            4-5-10
            4-6-10
            5-6-10
            Connected Components = [ [0,1], [2,3], [4,5,6] ]

Solution : Iterate over each vertex and for each vertex's form possible tree and gets its corresponding components
*
* */
public class Q4_ConnectedComponents {

    static void findAllConnectedComponents(ArrayList<ArrayList<Edge>> graph){
        ArrayList<ArrayList<Integer>> componentsList = new ArrayList<>();
        boolean visited[] = new boolean[graph.size()];

        for (int i=0;i<graph.size();i++){
            if(visited[i]==false){
                ArrayList<Integer> components = new ArrayList<>();
                drawTreeAndGenerateComponents(i,graph,visited,components);
                componentsList.add(components);
            }
        }

        System.out.println(componentsList);
    }

    static void drawTreeAndGenerateComponents(int vertices, ArrayList<ArrayList<Edge>> graph, boolean[] visited,ArrayList<Integer> components){
        visited[vertices] = true;
        components.add(vertices);
        for (Edge e: graph.get(vertices)){
            if(visited[e.neighbour]==false){
                drawTreeAndGenerateComponents(e.neighbour,graph,visited,components);
            }
        }
    }

    public static void main(String args[]){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        boolean vertices[] = new boolean[graph.size()];
        findAllConnectedComponents(graph);

    }
}
