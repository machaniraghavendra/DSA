package arrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharInStr {
     public static void main(String[] args) {
          String val = "raghu";
          System.out.println(findFirstNonRepeatingCharInStr(val));
     }

     //Using LinkedHashMap (follows the insertion order)
     private static Character findFirstNonRepeatingCharInStr(String val) {
          if (val == null || val.isEmpty()) return null;
          return val.chars()
               .mapToObj(a -> (char) a)
               .collect(Collectors.groupingBy(a -> a, LinkedHashMap::new, Collectors.counting()))
               .entrySet()
               .stream()
               .filter(a -> a.getValue() == 1)
               .map(Map.Entry::getKey)
               .findFirst()
               .orElse(null);
     }
}
