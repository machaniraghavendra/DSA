package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
     public static void main(String[] args) {
          int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {9, 15}, {7, 9}};
          System.out.println(Arrays.deepToString(getMergedIntervals(intervals)));
     }

     private static int[][] getMergedIntervals(int[][] intervals) {
          if (intervals.length <= 1) return intervals;
          List<int[]> list = new ArrayList<>();
          Arrays.sort(intervals, Comparator.comparingInt(current -> current[0]));
          int[] current = intervals[0];
          for (int[] next : intervals) {
               if (next[0] <= current[1]) {
                    current[1] = Math.max(next[1], current[1]);
               } else {
                    list.add(current);
                    current = next;
               }
          }
          list.add(current);
          return list.toArray(new int[list.size()][]);
     }
}
