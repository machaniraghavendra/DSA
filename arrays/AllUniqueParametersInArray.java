package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AllUniqueParametersInArray {
     public static void main(String[] args) {
          int[] arr = new int[]{1, 3, 3};
          System.out.println(uniquePerms(arr));
     }

     public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
          ArrayList<ArrayList<Integer>> result = new ArrayList<>();
          boolean[] used = new boolean[arr.length];
          backtrack(arr, new ArrayList<>(), used, result);
          return result;
     }

     private static void backtrack(int[] arr, ArrayList<Integer> temp,
                                   boolean[] used, ArrayList<ArrayList<Integer>> result) {
          for (int i = 0; i < arr.length; i++) {
               if (temp.size() == arr.length) {
                    result.add(new ArrayList<>(temp));
                    return;
               }
               if (used[i]) continue;
               if (i > 0 && arr[i] == arr[i - 1] && !used[i-1]) {
                    continue;
               }
               used[i] = true;
               temp.add(arr[i]);
               backtrack(arr, temp, used, result);
               used[i] = false;
               temp.remove(temp.size() - 1);
          }
     }
}
