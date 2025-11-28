package arrays;

import java.util.*;

public class IntersectionOfArrays {
     public static void main(String[] args) {
          int[] a = {1, 2, 2, 1};
          int[] b = {2, 2};
          System.out.println(Arrays.toString(getIntersectionOfArrays(a, b)));
     }

     private static Integer[] getIntersectionOfArrays(int[] a, int[] b) {
          Set<Integer> set1 = new HashSet<>(Arrays.stream(a).boxed().toList());
          Set<Integer> set2 = new HashSet<>(Arrays.stream(b).boxed().toList());
          set1.retainAll(set2);
          return set1.toArray(new Integer[0]);
     }
}
