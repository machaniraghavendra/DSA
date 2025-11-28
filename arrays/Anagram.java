package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagram {
     public static void main(String[] args) {
          String val = "java";
          String val1 = "VAAL";

          System.out.println(isAnagram(val, val1));
     }

     //Using maps
     // Time O(N) and space O(N)
     private static boolean isAnagram(String val, String val1) {
          if (val == null || val1 == null || val.length() != val1.length()) return false;
          var freqMap = val.toLowerCase().chars().mapToObj(a -> (char) a)
               .collect(Collectors.groupingBy(a -> a, Collectors.counting()));
          for (char c : val1.toLowerCase().toCharArray()) {
               Long count = freqMap.get(c);
               if (count == null || count == 0) return false;
               freqMap.put(c, count - 1);
          }
          return true;
     }

     //Using Arrays.sort
//     Time O(N log N), space O(1)
     public static boolean areAnagramsSort(String s1, String s2) {
          if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

          char[] arr1 = s1.toLowerCase().toCharArray();
          char[] arr2 = s2.toLowerCase().toCharArray();
          Arrays.sort(arr1);
          Arrays.sort(arr2);
          return Arrays.equals(arr1, arr2);
     }

     //Using hashing
     //Time O(N) and space O(1)
     public static boolean areAnagramsArray(String s1, String s2) {
          if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

          int[] count = new int[26];
          s1 = s1.toLowerCase();
          s2 = s2.toLowerCase();

          for (int i = 0; i < s1.length(); i++) {
               count[s1.charAt(i) - 'a']++;
               count[s2.charAt(i) - 'a']--;
          }

          for (int val : count) {
               if (val != 0) return false;
          }
          return true;
     }

     //Using streams to sort
     //Time O(N log N), Space O(N)
     public static boolean areAnagramsStreams(String s1, String s2) {
          if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

          String sorted1 = s1.toLowerCase().chars()
               .sorted()
               .mapToObj(c -> String.valueOf((char) c))
               .collect(Collectors.joining());

          String sorted2 = s2.toLowerCase().chars()
               .sorted()
               .mapToObj(c -> String.valueOf((char) c))
               .collect(Collectors.joining());

          return sorted1.equals(sorted2);
     }
}
