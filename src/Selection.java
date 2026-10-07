import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {3,5,4,2,1};
        sort(arr,arr.length,0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int r,int c, int maxIdx){
        if(r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[maxIdx]){
                sort(arr, r, c+1, c);
            } else {
                sort(arr, r, c+1,maxIdx);
            }
        } else{
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[r-1];
            arr[r-1] = temp;

            sort(arr,r-1,0,0);
        }
    }
}
