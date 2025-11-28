package arrays;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
     public static void main(String[] args) {
          int[] nums = {1, 2, 3};
          System.out.println(subsets(nums));
     }

     private static List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
          backTrack(0, nums, new ArrayList<>(), result);
          return result;
     }

     private static void backTrack(int start, int[] nums, ArrayList<Integer> subResult, List<List<Integer>> result) {
          result.add(new ArrayList<>(subResult));
          for (int i = start; i < nums.length; i++) {
               subResult.add(nums[i]);
               backTrack(i + 1, nums, subResult, result);
               subResult.remove(subResult.size() - 1);
          }
     }
}
