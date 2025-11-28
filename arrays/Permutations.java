package arrays;

import java.util.*;

public class Permutations {
     public static void main(String[] args) {
          int[] nums = {1, 2, 3};
          System.out.println(permute(nums));
     }

     private static List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
          boolean[] used = new boolean[nums.length];
          backTrack(nums, new ArrayList<>(), nums.length, result, used);
          return result;
     }

     private static void backTrack(int[] nums, ArrayList<Integer> subResult, int n, List<List<Integer>> result, boolean[] used) {
          for (int i = 0; i < n; i++) {
               if (subResult.size() == n) {
                    result.add(new ArrayList<>(subResult));
                    return;
               }
               if (used[i]) continue;
               subResult.add(nums[i]);
               used[i] = true;
               backTrack(nums, subResult, n, result, used);
               subResult.remove(subResult.size() - 1);
               used[i] = false;
          }
     }
}
