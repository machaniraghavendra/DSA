package arrays;

import java.util.Arrays;
import java.util.List;

public class FindStringsWithAnyOneCommonChar {
     public static void main(String[] args) {
          String[] arr = {"abc", "bcd", "efg", "gh"};
          System.out.println(findStrings(arr));
     }

     private static List<String> findStrings(String[] arr) {
          return Arrays.stream(arr)
               .filter(s -> s.chars().anyMatch(k ->
                    Arrays.stream(arr).filter(a -> a.chars().anyMatch(b -> b == k)).count() > 1))
               .toList();
     }
}
