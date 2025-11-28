package arrays;

public class FindLongestSubStringLengthWithoutRepeatingChars {

     public static void main(String[] args) {
          String val = "abcdabcdabcd"; // Output should be abcd
          System.out.println(getLongestSubStringLengthWithoutRepeatingChars(val));
     }

     private static int getLongestSubStringLengthWithoutRepeatingChars(String val) {
          int[] map = new int[255];
          int maxLen = 0;
          int left = 0;
          for (int right = 0; right < val.length(); right++) {
               char ch = val.charAt(right);
               if (map[ch] >= left) {
                    left = map[ch] + 1;
               }
               map[ch] = right;
               maxLen = Math.max(maxLen, right - left + 1);
          }
          return maxLen;
     }
}
