package practice.stringexamples;

import java.util.*;

public class StringExamples {
     public static void main(String[] args) {
          System.out.print("Reverse words in sentence : ");
          System.out.println(reverseWordsInASentence("Java is fun"));//Output: "fun is Java"
          System.out.print("Check for Anagrams : ");
          System.out.println(checkForAnagrams("lissten", "silents")); //Output: true
          System.out.print("First non repeating char : ");
          System.out.println(findFirstNonRepeatingChar("Stress")); //Output: 't'
          System.out.print("Longest Palindrome : ");
          System.out.println(longestPalindrome("babad")); //Output: "bab" or "aba"
          System.out.print("String comparison :");
          System.out.println(compressString("aaabbccc"));//Output : "a3b2c3"
          System.out.print("Check if a String is a Rotation of Another : ");
          System.out.println(checkStringIsRotationAnother("waterbottle", "erbottlewat")); //Output: true
          System.out.print("Convert Roman to Numeral : ");
          System.out.println(convertRomanToNumeral("XVI")); //Output: 14
          System.out.print("Group Words that are Anagrams : ");
          System.out.println(groupWordsOfAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})); // Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
          System.out.print("Check if a String is a Palindrome (Ignore Special Characters) : ");
          System.out.println(checkStringIsPalindrome("A man, a plan, a canal: Panama"));//Output: true
          System.out.print("Find the Longest Common Prefix :");
          System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); //Output: "fl"
     }

     private static String reverseWordsInASentence(String value) {
          StringBuilder stringBuffer = new StringBuilder();
          String[] subWords = value.split(" ");
          for (int i = subWords.length - 1; i >= 0; i--) {
               stringBuffer.append(subWords[i]).append(" ");
          }
          return stringBuffer.toString().trim();
     }

     private static boolean checkForAnagrams(String compareValue, String withValue) {
          if (compareValue.length() != withValue.length()) return false;
          int[] arr = new int[256];
          for (int i = 0; i < compareValue.length(); i++) arr[compareValue.charAt(i)]++;
          for (int i = 0; i < withValue.length(); i++) arr[withValue.charAt(i)]--;
          for (int j : arr) {
               if (j == 1) {
                    return false;
               }
          }
          return true;
     }

     private static String findFirstNonRepeatingChar(String val) {
          val = val.toLowerCase();
          HashMap<Character, Integer> map = new HashMap<>();
          for (int i = 0; i < val.length(); i++) {
               map.put(val.charAt(i), map.getOrDefault(val.charAt(i), 0) + 1);
          }
          for (int i = 0; i < val.length(); i++) {
               if (map.get(val.charAt(i)) == 1) {
                    return String.valueOf(val.charAt(i));
               }
          }
          return "-1";
     }

     private static String longestPalindrome(String val) {
          if (val == null || val.isEmpty()) return "";
          int start = 0, end = 0;
          for (int i = 0; i < val.length(); i++) {
               int len1 = expandAroundCenter(val, i, i);
               int len2 = expandAroundCenter(val, i, i + 1);
               int len = Math.max(len1, len2);
               if (len > (end - start)) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
               }
          }
          return val.substring(start, end + 1);
     }

     private static int expandAroundCenter(String s, int left, int right) {
          while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
               left--;
               right++;
          }
          return right - left - 1;
     }

     private static String compressString(String val) {
          if (val.isEmpty()) return val;
          StringBuilder compressedResult = new StringBuilder();
          int reapeatedChars = 1;
          char nextChar = val.charAt(0);
          for (int i = 1; i < val.length(); i++) {
               if ((i + 1) < val.length() && nextChar == val.charAt(i)) {
                    reapeatedChars++;
               } else {
                    compressedResult.append(nextChar).append(reapeatedChars);
                    reapeatedChars = 1;
                    nextChar = val.charAt(i);
               }
          }
          return compressedResult.toString();
     }

     private static boolean checkStringIsRotationAnother(String original, String rotated) {
          if (original.length() != rotated.length()) return false;
          String concatenatedString = original + original;
          return concatenatedString.contains(rotated);
     }

     private static int convertRomanToNumeral(String roman) {
          if (roman.isEmpty()) return -1;
          Map<Character, Integer> romans = new HashMap<>();
          romans.put('I', 1);
          romans.put('V', 5);
          romans.put('X', 10);
          romans.put('L', 50);
          romans.put('C', 100);
          romans.put('D', 500);
          romans.put('M', 1000);
          if (roman.length() == 1) return romans.get(roman.toCharArray()[0]);
          int result = 0;
          for (int i = 0; i < roman.length(); i++) {
               int curr = romans.get(roman.charAt(i));
               if ((i + 1) < roman.length() && curr < romans.get(roman.charAt(i + 1))) {
                    result -= curr;
               } else {
                    result += curr;
               }
          }
          return result;
     }

     private static List<List<String>> groupWordsOfAnagrams(String[] arr) {
          List<List<String>> resultList = new ArrayList<>();
          String[][] result = new String[arr.length][arr.length];
          for (int i = 0; i < result.length; i++) {
               String val = sortStringWithBubbleSort(arr[i]);
               result[i][0] = val;
               List<String> stringList = new ArrayList<>();
               for (int j = 0; j < result.length; j++) {
                    if (sortStringWithBubbleSort(arr[j]).equals(result[i][0])) {
                         stringList.add(arr[j]);
                    }
               }
               if (!resultList.contains(stringList)) resultList.add(stringList);
          }
          return resultList;
     }

     private static String sortStringWithBubbleSort(String val) {
          char[] chars = val.toCharArray();
          final int n = chars.length;
          for (int i = 0; i < n; i++) {
               int count = 0;
               while (count < (n - i - 1)) {
                    if (chars[count] > chars[count + 1]) {
                         char temp = chars[count];
                         chars[count] = chars[count + 1];
                         chars[count + 1] = temp;
                    }
                    count++;
               }
          }
          return new String(chars);
     }

     private static boolean checkStringIsPalindrome(String value) {
          value = value.toLowerCase();
          StringBuilder stringBuilder = new StringBuilder();
          for (int i = 0; i < value.length(); i++) {
               char ch = value.charAt(i);
               if (Character.isLetterOrDigit(ch)) {
                    stringBuilder.append(ch);
               }
          }
          for (int i = 0; i < stringBuilder.length() / 2; i++) {
               if (stringBuilder.charAt(i) != stringBuilder.charAt(stringBuilder.length() - i - 1)) {
                    return false;
               }
          }
          return true;
     }

     private static String longestCommonPrefix(String[] arr) {
          StringBuilder result = new StringBuilder();
          firstloop:
          for (int i = 0; i < arr[0].length(); i++) {
               for (int j = 1; j < arr.length; j++) {
                    if (i < arr[j].length() && arr[0].charAt(i) != arr[j].charAt(i)) {
                         break firstloop;
                    }
               }
               result.append(arr[0].charAt(i));
          }
          return result.toString();
     }
}
