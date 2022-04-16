package graph;

/* in a graph EDGE is the joining line between two vertices, consisting of following :
*   source , neighbour and weight/distance
* */
public class Edge {
    int source;
    int neighbour;
    int distance;

    public Edge(int source,int neighbour, int distance){
        this.source = source;
        this.neighbour = neighbour;
        this.distance = distance;
    }

}
