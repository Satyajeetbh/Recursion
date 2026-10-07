package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
    int[] nums = {6,4,3,2,1};
    sort(nums,0,nums.length-1);
    System.out.println("Original Sort: " + Arrays.toString(nums));
    int[] nums2 = {5, 4, 3, 2, 1};
    sort3w(nums2, 0, nums2.length - 1);
    System.out.println("3-Way Sort:    " + Arrays.toString(nums2));
    }
    //low adn high tells which part of the array we are working on
    static void sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int s = low;
        int e = high;
        int m = s+(e-s)/2;
        int pivot = arr[m];

        while(s<=e) {
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]> pivot){
                e--;
            }

            if(s<=e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
            //now my pivot is at correct index, we sort the two halves now
        sort(arr,low, e);
        sort(arr,s,high);
    }
    // --- NEW 3-WAY QUICK SORT METHOD ---
    static void sort3w(int[] arr, int low, int high) {
        // Base case stays the same
        if (low >= high) {
            return;
        }

        // 1. Pick the pivot value from the middle index
        int m = low + (high - low) / 2;
        int pivot = arr[m];

        // 2. Setup your three pointers
        int s = low;   // Red Guard (boundary for elements < pivot)
        int i = low;   // The Scanner
        int e = high;  // Blue Guard (boundary for elements > pivot)

        // 3. Process the array until the scanner crosses the blue guard
        while (i <= e) {
            if (arr[i] < pivot) {
                // Elements smaller than pivot swap to the left side
                int temp = arr[s];
                arr[s] = arr[i];
                arr[i] = temp;
                s++;
                i++;
            } else if (arr[i] > pivot) {
                // Elements larger than pivot swap to the right side
                int temp = arr[e];
                arr[e] = arr[i];
                arr[i] = temp;
                e--; // Do not increment 'i' here! We must look at the new incoming element.
            } else {
                // Elements equal to the pivot pool up in the middle
                i++;
            }
        }

        // 4. Smart Recursion
        // The elements from index 's' to 'e' are equal to the pivot and perfectly sorted.
        // We completely skip them and sort the left and right outer boundaries.
        sort3w(arr, low, s - 1);  // Sort strictly smaller elements
        sort3w(arr, e + 1, high); // Sort strictly larger elements
    }
}

