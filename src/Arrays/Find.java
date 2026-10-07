package Arrays;

import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,4,4,5,7,7};
        int target = 7;
//        System.out.println(find(arr,target,0));
//        findAllIndex(arr,target,0);
//        System.out.println(list);
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<Integer> ans =findAllIndex(arr, target, 0, list);
//        System.out.println(ans);
        System.out.println(findAllIndex2(arr, target,0));
    }

    static boolean find(int[] arr, int target, int index){
        if(arr[index]==arr.length){
            return false;
        }

        return arr[index]==target || find(arr, target,index+1);
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index) {
        if(index==arr.length){
            return;
        }

        if(arr[index]==target){
            list.add(index);
        }
        findAllIndex(arr,target,index+1);
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }

        if(arr[index]==target){
            list.add(index);
        }
        return findAllIndex(arr,target,index+1,list);
    }
    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        //this will contain answer fo that answer call only
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls =  findAllIndex2(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}