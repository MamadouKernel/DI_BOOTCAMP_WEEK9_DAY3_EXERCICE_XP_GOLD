package exercice1;

import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public static void sort(int[] arr, int k) {
        int n = arr.length;
        
        // Create a min-heap of size k+1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
        
        // Insert the first k+1 elements into the heap
        for (int i = 0; i <= k; i++) {
            minHeap.add(arr[i]);
        }
        
        // Process the remaining elements
        for (int i = k+1; i < n; i++) {
            // Insert the current element into the heap
            minHeap.add(arr[i]);
            
            // Extract the minimum element from the heap
            int min = minHeap.poll();
            
            // Replace the extracted element with the newly inserted element
            arr[i-k-1] = min;
        }
        
        // Sort the remaining elements in the heap using insertion sort
        while (!minHeap.isEmpty()) {
            arr[n-k-1] = minHeap.poll();
            k--;
        }
        
        // The array is now sorted
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 4, 70, 60, 50, 100};
        int k = 3;
        sort(arr, k);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
