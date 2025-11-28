package arrays;

import java.util.Arrays;

public class TripletSortingUsingComparatorAndComparable {
     public static void main(String[] args) {
          int[][] arr = {{1, 2, 3}, {2, 2, 4}, {5, 6, 1}, {10, 2, 10}};
          System.out.println(Arrays.deepToString(sortBasedOnLastElement(arr)));
     }

     private static int[][] sortBasedOnLastElement(int[][] arr) {
//          return Arrays.stream(arr).sorted(Comparator.comparing((int[] a)-> a[a.length-1]).reversed()).toArray(int[][]::new);
          return Arrays.stream(arr).sorted((b, a) -> a[a.length - 1] - b[b.length - 1]).
          toArray(int[][]::new);
     }
}
