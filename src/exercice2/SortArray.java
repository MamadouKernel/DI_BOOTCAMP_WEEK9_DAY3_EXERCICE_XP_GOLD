package exercice2;

import java.util.*;

public class SortArray {

    public static void main(String[] args) {
        int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] A2 = {2, 1, 8, 3};
        int[] sortedArray = sortArray(A1, A2);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] sortArray(int[] A1, int[] A2) {
        int m = A1.length;
        int n = A2.length;

        // create a temporary array and copy the contents of A1 to it
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = A1[i];
        }

        // create a visited array and initialize all entries as false
        boolean[] visited = new boolean[m];

        // sort the temporary array
        Arrays.sort(temp);

        // initialize the output index as 0
        int ind = 0;

        // loop through every element in A2
        for (int i = 0; i < n; i++) {
            // binary search for all occurrences of A2[i] in temp
            int low = 0;
            int high = m - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp[mid] == A2[i]) {
                    // copy all occurrences to A1[ind] and mark them visited
                    int j = mid;
                    while (j < m && temp[j] == A2[i]) {
                        if (!visited[j]) {
                            A1[ind] = temp[j];
                            ind++;
                            visited[j] = true;
                        }
                        j++;
                    }
                    break;
                } else if (temp[mid] < A2[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // copy all unvisited elements from temp to A1
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                A1[ind] = temp[i];
                ind++;
            }
        }

        return A1;
    }
}
