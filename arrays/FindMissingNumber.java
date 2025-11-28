package arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindMissingNumber {

     public static void main(String[] args) {
          System.out.println(findMissingNumber(0, 1, 2, 4, 5, 6));
          System.out.println(findMissingNumberByXOR(1, 2, 4, 5, 6));
          System.out.println(findMissingNumberUsingStreams(new int[]{16, 10, 12, 14, 15}));
          System.out.println(findStringHasUniqueChars("thiss"));
     }

     private static int findMissingNumber(int... nums) {
          int n = nums.length;
          if (n == 0) return -1;
          n = nums[n - 1];
          //Sum of 1 to N natural numbers
          int expectedSum = (n * (n + 1)) / 2;
          int actualSum = Arrays.stream(nums).sum();
          return expectedSum - actualSum == 0 ? -1 : expectedSum - actualSum;
     }

     private static int findMissingNumberByXOR(int... nums) {
          int xorFull = 0;
          int xorArr = 0;
          int min = Arrays.stream(nums).min().orElse(0);
          int max = Arrays.stream(nums).max().orElse(0);
          for (int i = min; i <= max; i++) {
               xorFull ^= i;
          }
          for (int x : nums) {
               xorArr ^= x;
          }
          return xorFull ^ xorArr;
     }

     private static List<Integer> findMissingNumberUsingStreams(int[] nums) {
          Set<Integer> integers = Arrays.stream(nums).boxed().collect(Collectors.toSet());

          IntStream.range(IntStream.of(nums).min().orElseThrow(), IntStream.of(nums).max().orElseThrow())
               .filter(x -> IntStream.of(nums).noneMatch(a -> a == x)).findFirst();

          return IntStream.range(Arrays.stream(nums).min().getAsInt(), Arrays.stream(nums).max().getAsInt())
               .filter(number -> !integers.contains(number)).boxed().toList();
     }

     private static boolean findStringHasUniqueChars(String val){
//          return val.chars().mapToObj(c -> (char) c).allMatch(c -> (val.indexOf(c) == val.lastIndexOf(c)));
//          return val.chars().mapToObj(c->(char) c).collect(Collectors.toSet()).size() == val.length();
          return val.chars().distinct().count() == val.length();
//          Set<Integer> seen = new HashSet<>();
//          return val.chars().anyMatch(seen::add);
     }
}
