package arrays;

import java.util.*;

public class NextGreaterElementInCircularArray {

     public static void main(String[] args) {
//          int[] arr = new int[]{1, 3, 2, 4};
          int[] arr = new int[]{0, 2, 3, 1, 1};
          //[3, 4, 4, -1]
          System.out.println(nextGreater(arr));
          System.out.println(nextGre(arr));
     }

     public static ArrayList<Integer> nextGreater(int[] arr) {
          ArrayList<Integer> result = new ArrayList<>();
          int left = 0;
          int right = 0;
          while (left < arr.length) {
               while (right < arr.length) {
                    if (arr[left] < arr[right]) {
                         result.add(arr[right]);
                         break;
                    }
                    right++;
               }
               if (right == arr.length) {
                    right = 0;
                    while (right <= left) {
                         if (arr[left] < arr[right]) {
                              result.add(arr[right]);
                              break;
                         }
                         if (right == left) {
                              result.add(-1);
                         }
                         right++;
                    }
               }
               left++;
          }
          return result;
     }

     public static ArrayList<Integer> nextGre(int[] arr) {
          int n = arr.length;
          ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
          Stack<Integer> stack = new Stack<>();
          for (int i = 0; i < 2 * n; i++) {
               int index = i % n;
               while (!stack.isEmpty() && arr[stack.peek()] < arr[index]) {
                    result.set(stack.pop(), arr[index]);
               }

               if (i < n) {
                    stack.push(i);
               }
          }
          return result;
     }
}
