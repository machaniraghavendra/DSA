package arrays;

import java.util.*;

public class GroupAnagrams {
     public static void main(String[] args) {
          List<String> array = new ArrayList<>(List.of("eat", "tea", "tan", "ate", "nat", "bat"));
          //Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
//          System.out.println(getGroupOfAnangrams(array));
          System.out.println(getGroupOfAnangramsByGpt(array));
     }

     private static Collection<List<String>> getGroupOfAnangrams(List<String> array) {
          Map<String, List<String>> map = new HashMap<>();
          for (String s : array) {
               var c = s.toCharArray();
               Arrays.sort(c);
               String sortedString = Arrays.toString(c);
               List<String> anagrams = new ArrayList<>();
               for (String s1 : array) {
                    if (!s.equals(s1)) {
                         if (checkIsAnagram(s, s1)) {
                              anagrams.add(s1);
                         }
                    }
               }
               anagrams.add(s);
               map.put(sortedString, anagrams);
          }
          return map.values();
     }

     private static boolean checkIsAnagram(String s, String s1) {
          if (s == null || s1 == null || s1.length() != s.length()) return false;

          int[] count = new int[26];
          s1 = s1.toLowerCase();
          s = s.toLowerCase();
          for (int i = 0; i < s.length(); i++) {
               count[s.charAt(i) - 'a']++;
               count[s1.charAt(i) - 'a']--;
          }
          for (int j : count) {
               if (j != 0) {
                    return false;
               }
          }
          return true;
     }

     private static Collection<List<String>> getGroupOfAnangramsByGpt(List<String> array) {
          Map<String, List<String>> map = new HashMap<>();
          for (String s : array) {
               var c = s.toCharArray();
               Arrays.sort(c);
               String sortedString = new String(c);
               map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(s);
          }
          return map.values();
     }

}
