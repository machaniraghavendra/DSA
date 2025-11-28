package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindTheStringWithMaximumVowelCount {
     public static void main(String[] args) {
          String[] arr = {"Spring", "React", "Angular", "Vue"};
          List<String> list = maxVowelCount(arr);
          var list1 = maxVowelCount1(arr);
          System.out.println(list1);
     }

     public static List<String> maxVowelCount(String[] arr) {
          return Arrays.stream(arr)
               .collect(Collectors.groupingBy(FindTheStringWithMaximumVowelCount::countVowels))
               .entrySet().stream()
               .max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).get();
     }

     public static String maxVowelCount1(String[] arr) {
          return Arrays.stream(arr)
               .max(Comparator.comparingLong(s->s.chars().filter(a->"aeiouAEIOU".indexOf(a)!=-1).count())).orElse("No data");
     }

     private static int countVowels(String s) {
          String vowels = "aeiouAEIOU";
          return (int) s.chars().filter(a -> vowels.indexOf((char) a) != -1).count();
     }
}
