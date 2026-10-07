package Assignments;

import java.util.Arrays;

public class STA {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        printTriangle(A);
    }
    static void printTriangle(int[] arr){
        if(arr.length<1 ){
            return;
        }
        int[] nextRow = new int[arr.length-1];
        for(int i = 0; i<arr.length-1;i++){
            nextRow[i] = arr[i]+arr[i+1];
        }

        printTriangle(nextRow);
        System.out.println(Arrays.toString(arr));

    }

}
