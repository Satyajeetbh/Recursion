package Assignments;

import java.util.ArrayList;

public class MinMax {
    public static void main(String[] args) {
        int[] arr = {1,4,3,-5,-4,8,6};
        ArrayList<Integer> res = findMinMax(arr);
        System.out.println(res.get(0) + " " + res.get(1));
    }

    static ArrayList<Integer> findMinMax(int[] arr){
        //we need a helper function to pass the index
        return findMinMaxRec(arr,arr.length-1);
    }

    private static ArrayList<Integer> findMinMaxRec(int[] arr, int n) {
        if(n==0){
            //base case:only one element
            ArrayList<Integer> base = new ArrayList<>();
            base.add(arr[0]);//0th element->min
            base.add(arr[0]);//1st element->max
            return base;
        }
        ArrayList<Integer> result = findMinMaxRec(arr,n-1);
        if(arr[n]<result.get(0)){
            result.set(0,arr[n]);
        }
        if(arr[n]>result.get(1)){
            result.set(1,arr[n]);
        }
        return result;
    }

    static class Pair {
        int min;
        int max;
        Pair(int min, int max) { this.min = min; this.max = max; }
    }

    static Pair findMinMax(int[] arr, int index) {
        if (index == 0) {
            return new Pair(arr[0], arr[0]);
        }

        Pair prev = findMinMax(arr, index - 1);
        int currentMin = Math.min(arr[index], prev.min);
        int currentMax = Math.max(arr[index], prev.max);

        return new Pair(currentMin, currentMax);
    }
}
