package arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
* You are given an array of integers arr[].
* Your task is to find the length of the longest subarray such that all the
* elements of the subarray are smaller than or equal to the length of the subarray.
*
* Input: arr[] = [1, 2, 3]
Output: 3
Explanation: The longest subarray is the entire array itself,
* which has a length of 3. All elements in the subarray are less than or equal to 3.
Input: arr[] = [6, 4, 2, 5]
Output: 0
Explanation: There is no subarray where all elements are less than or
* equal to the length of the subarray. The longest subarray is empty, which has a length of 0.
* */
public class LongestSubArrayLength {

     public static void main(String[] args) {
//          int[] arr = new int[]{1, 2, 3};
//          int[] arr = new int[]{6, 4, 2, 5};
          int[] arr = new int[]{2, 2, 3, 15, 8, 11, 6, 6};
          System.out.println(longestSubarray(arr));
     }

     public static int longestSubarray(int[] arr) {
          int maxLength = 0, left = 0, right = 1, n = arr.length;
          while (left < n) {
               while (right <= n) {
                    int[] subarray = Arrays.copyOfRange(arr, left, right);
                    Arrays.sort(subarray);
                    int maxInSubArray = subarray[subarray.length - 1];
                    if (maxInSubArray <= subarray.length) {
                         maxLength = Math.max(maxLength, subarray.length);
                    }
                    right++;
               }
               if (maxLength == n) {
                    break;
               }
               left++;
               right = left + 1;
          }
          return maxLength;
     }
}
