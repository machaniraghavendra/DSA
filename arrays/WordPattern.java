package arrays;

import java.util.HashMap;

public class WordPattern {
     public static void main(String[] args) {
          String pattern = "abba", s = "dog cat cat dog";
          System.out.println(wordPattern(pattern, s));
     }

     private static boolean wordPattern(String pattern, String s) {
          String[] arr = s.split(" ");
          HashMap<Character, String> map = new HashMap<>();
          HashMap<String, Character> reverseMap = new HashMap<>();
          for (int i = 0; i < pattern.length(); i++) {
               char c = pattern.charAt(i);
               String word = arr[i];

               if (map.containsKey(c) && !map.get(c).equals(word)) return false;
               if (reverseMap.containsKey(word) && reverseMap.get(word) != c) return false;
               map.put(c, word);
               reverseMap.put(word, c);
          }
          return true;
     }
}
