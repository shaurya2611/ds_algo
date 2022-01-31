package recursion;

import java.util.ArrayList;

public class CombinationSum1 {
    /*
    * Input: candidates = [2,3,6,7], target = 7
       Output: [[2,2,3],[7]]
    * */
    public static void findCombinations(int i,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> arr,int target,ArrayList<Integer> tempArr){

        if(i==arr.size()){
            if(target==0){
                ans.add(new ArrayList<>(tempArr));
            }
            return;
        }

        if(arr.get(i)<=target){//ith index element selected
            tempArr.add(arr.get(i));
            findCombinations(i,ans,arr,target-arr.get(i),tempArr);
            tempArr.remove(tempArr.size()-1);//remove last added(line above) element in bactracking
        }
        else{//ith index element not selected
            findCombinations(i+1,ans,arr,target,tempArr);
        }

    }

    public static ArrayList<ArrayList<Integer>> combinatioSum(ArrayList<Integer> arr, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findCombinations(0,ans,arr,target,new ArrayList<Integer>());
        return ans;
    }

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);arr.add(3);arr.add(6);arr.add(7);

        ArrayList<ArrayList<Integer>> ans = combinatioSum(arr,7);
        System.out.println(ans);


    }

}
