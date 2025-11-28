package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindDuplicates {
     public static void main(String[] args) {
          System.out.println(findDuplicates(new int[]{6, 7, 3, 6, 4, 5, 7}));
     }

     /*
     * #Constraints
     * values = 1 < num[i] < n, where n is length
     * Each number appears once or twice (no more than twice)
     * */
     private static List<Integer> findDuplicates(int[] arr) {
          List<Integer> duplicates = new ArrayList<>();
          for (int i = 0; i < arr.length; i++) { //----------- O(N)
               int index = Math.abs(arr[i]) - 1;
               if (arr[index] < 0) {
                    duplicates.add(Math.abs(arr[i]));
               } else {
                    arr[index] = -arr[index];
               }
          }
          duplicates.sort(Comparator.comparingInt(a -> a));
          return duplicates;
     }


}
