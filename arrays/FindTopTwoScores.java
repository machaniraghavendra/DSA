package arrays;

import java.util.*;

public class FindTopTwoScores {
     public static int[] findTopTwoScores(int[] array) {

         Set<Integer> sortedArray = new TreeSet<>(Collections.reverseOrder());
          for (int val : array) {
               sortedArray.add(val);
          }
          var list = sortedArray.stream().toList();
          return new int[]{list.get(0), list.get(1)};
     }

     public static void main(String[] args) {
          System.out.println(Arrays.toString(findTopTwoScores(new int[]{84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0})));
     }
}
