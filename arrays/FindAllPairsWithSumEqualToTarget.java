package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindAllPairsWithSumEqualToTarget {
     public static void main(String[] args) {
          int[] arr = {1, 2, 3, 4, 5};
          int target = 7;
          System.out.println(findAllPairsWithSumEqualToTarget(arr, target));
          findAllPairsWithSumEqualToTarget1(arr, target);
     }

     public static List<List<Integer>> findAllPairsWithSumEqualToTarget(int[] arr, int target) {
          List<List<Integer>> result = new ArrayList<>();
          IntStream.range(0, arr.length).forEach(i -> {
               List<Integer> subResult = new ArrayList<>();
               IntStream.range(i + 1, arr.length).forEach(j -> {
                    if (arr[i] + arr[j] == target) {
                         subResult.add(arr[i]);
                         subResult.add(arr[j]);
                    }
               });
               if (!subResult.isEmpty()) {
                    result.add(subResult);
               }
          });
          return result;
     }

     public static void findAllPairsWithSumEqualToTarget1(int[] arr, int target) {
          IntStream.range(0, arr.length).boxed()
               .flatMap(i -> IntStream.range(i + 1, arr.length).filter(j -> arr[i] + arr[j] == target)
                    .mapToObj(a -> "(" + arr[i] + "," + arr[a] + ")")).forEach(System.out::println);
     }
}
