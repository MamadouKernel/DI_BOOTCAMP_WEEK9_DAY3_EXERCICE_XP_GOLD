package exercice3;

import java.util.*;

public class MaximumOverlap {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(9, 12),
                                new Interval(5, 9), new Interval(5, 12)};
        int maxOverlapPoint = findMaxOverlapPoint(intervals);
        System.out.println("Maximum overlap point: " + maxOverlapPoint);
    }

    public static int findMaxOverlapPoint(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        // store start and end times in separate arrays
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        // sort start and end times arrays
        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0;
        int maxGuests = 0, currGuests = 0, maxOverlapPoint = 0;

        // merge start and end times arrays to find maximum overlap point
        while (i < n && j < n) {
            if (starts[i] <= ends[j]) {
                currGuests++;
                if (currGuests > maxGuests) {
                    maxGuests = currGuests;
                    maxOverlapPoint = starts[i];
                }
                i++;
            } else {
                currGuests--;
                j++;
            }
        }

        return maxOverlapPoint;
    }
}
