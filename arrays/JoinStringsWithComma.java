package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinStringsWithComma {
     public static void main(String[] args) {
          List<String> names = new ArrayList<>();
          names.add("Raghu");
          names.add("ARaghu");
          names.add("BRaghu");
          names.add("ARaghu");
          System.out.println(names.stream().reduce((a, b) -> a + "," + b).get());
          System.out.println(names.stream().collect(Collectors.joining(",")));
          System.out.println(String.join(",", names));

          int[] nums = {1, 2, 3, 4, 5, 6};
          System.out.println(Arrays.stream(nums).boxed().collect(Collectors.partitioningBy(a-> a%2==0, Collectors.counting())));
     }
}
