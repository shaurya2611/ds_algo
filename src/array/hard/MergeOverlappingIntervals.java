package array.hard;

import java.util.*;

public class MergeOverlappingIntervals {

    /*
    Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
    Input: [[1,3],[2,6],[8,10],[4,5],[15,18]]
    Output:[[1,6],[8,10],[15,18]]
    */


    // Sort the array and apply the while loop to find the common interval
    // Time O(NlogN + N)
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length; // size of the array
        //sort the given intervals:
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0])
                    return a[0] - b[0];
                else
                    return a[1] - b[1];
            }
        });
        int i = 0;
        while(i < intervals.length){
            int first = intervals[i][0]; int second = intervals[i][1];
            while(i < intervals.length-1 && second>=intervals[i+1][0]){
                second = Math.max(intervals[i+1][1],second);
                i++;
            }
            ans.add(Arrays.asList(first,second));
            i++;
        }
        // Convert List<List<Integer>> to int[][]
        int[][] result = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            result[j][0] = ans.get(j).get(0);
            result[j][1] = ans.get(j).get(1);
        }

        return result;


    }

    public static void main(String[] args){
        int[][] intervals = {{1, 3},{2,6}, {8, 9}, {15,18}};
        int[][] ans = MergeOverlappingIntervals.mergeOverlappingIntervals(intervals);
    }

}
