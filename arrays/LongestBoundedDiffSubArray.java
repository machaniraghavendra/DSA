package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LongestBoundedDiffSubArray {
     public static void main(String[] args) {
//          int[] arr = {8, 4, 5, 6, 7};
          int[] arr = {1, 10, 12, 13, 14};
          int x = 2;
          System.out.println(longestSubarray(arr, x));
     }

     static ArrayList<Integer> longestSubarray(int[] arr, int x) {
          int n = arr.length;
          Deque<Integer> minDeque = new ArrayDeque<>();
          Deque<Integer> maxDeque = new ArrayDeque<>();

          int left = 0, bestStart = 0, bestLen = 0;

          for (int right = 0; right < n; right++) {
               // Maintain minDeque (increasing order)
               while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[right]) {
                    minDeque.pollLast();
               }
               minDeque.addLast(right);

               // Maintain maxDeque (decreasing order)
               while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[right]) {
                    maxDeque.pollLast();
               }
               maxDeque.addLast(right);

               // Shrink window if invalid
               while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                    if (minDeque.peekFirst() == left) minDeque.pollFirst();
                    if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                    left++;
               }

               // Update best window
               int len = right - left + 1;
               if (len > bestLen) {
                    bestLen = len;
                    bestStart = left;
               }
          }

          // Build result
          ArrayList<Integer> result = new ArrayList<>();
          for (int i = bestStart; i < bestStart + bestLen; i++) {
               result.add(arr[i]);
          }
          return result;
     }
}
