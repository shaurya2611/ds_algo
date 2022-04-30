package graph;

import java.util.ArrayList;

/*
1. You are given a number n (representing the number of students). Each student will have an id
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are
     from different clubs.

Solution :  Using Connected Components find the number of clubs from the given data in form of graph.
            No of connected components = no of clubs
            Npw find the all possible combination of pairs
* */
public class Q07_PerfectFriend {

    static Integer CountPerfectFriendPair(ArrayList<ArrayList<Edge>> graph){
        // Getting array list of all the connecting componenets
        ArrayList<ArrayList<Integer>> connectedComponents =  Q04_ConnectedComponents.findAllConnectedComponents(graph);

        // Now finding the possible pairs
        // e.g. --> [ [0,1], [2,3], [4,5,6] ] --> c1*c2, c1*c3, c2*c3
        int allPossiblePairs = 0;
        for (int i=0;i<connectedComponents.size();i++){
            for (int j = 0; j < connectedComponents.size(); j++) {
                   int noPairs = connectedComponents.get(i).size() *  connectedComponents.get(j).size();
                   allPossiblePairs+=noPairs;
            }
        }
        return allPossiblePairs;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        System.out.println(CountPerfectFriendPair(graph));


    }
}
