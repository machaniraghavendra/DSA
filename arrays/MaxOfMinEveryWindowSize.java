package arrays;

import java.util.ArrayList;
import java.util.Collections;

/*
* Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
Output: [70, 30, 20, 10, 10, 10, 10]
Explanation:
Window size 1: minimums are [10, 20, 30, 50, 10, 70, 30], maximum of minimums is 70.
Window size 2: minimums are [10, 20, 30, 10, 10, 30], maximum of minimums is 30.
Window size 3: minimums are [10, 20, 10, 10, 10], maximum of minimums is 20.
Window size 4–7: minimums are [10, 10, 10, 10], maximum of minimums is 10.
*
Input: arr[] = [10, 20, 30]
Output: [30, 20, 10]
Explanation:
Window size 1: minimums of  [10], [20], [30], maximum of minimums is 30.
Window size 2: minimums of [10, 20], [20,30], maximum of minimums is 20.
Window size 3: minimums of [10,20,30], maximum of minimums is 10.
* */
public class MaxOfMinEveryWindowSize {
     public static void main(String[] args) {
          int[] arr = new int[]{10, 20, 30, 50, 10, 70, 30};
          System.out.println(maxOfMins(arr));
     }

     public static ArrayList<Integer> maxOfMins(int[] arr) {
          ArrayList<Integer> maxOfMinResult = new ArrayList<>();
          int n = arr.length;
          int left, right;
          for (int i = 0; i < n; i++) {
               left = 0;
               right = i;
               ArrayList<Integer> minimums = new ArrayList<>();
               while (right < n && left <= right) {
                    int min = Integer.MAX_VALUE;
                    for (int j = left; j <= right; j++) {
                         min = Math.min(min, arr[j]);
                    }
                    minimums.add(min);
                    left++;
                    right++;
               }
               maxOfMinResult.add(Collections.max(minimums));
          }
          return maxOfMinResult;
     }
}
