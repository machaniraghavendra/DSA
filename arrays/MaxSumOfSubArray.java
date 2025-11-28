package arrays;

public class MaxSumOfSubArray {
     public static void main(String[] args) {
//          maxSumOfSubArray1(-2, 3, -3, -4, -1, -2, -1, -5, -4);
          System.out.println(maxSumOfSubArray1(-2, -1, -3, -4, -1, -2, -1, -5, -4));
     }

     //4, -1, 2, 1,  = 6
     public static int maxSumOfSubArray(int... array) {
          int maxSum = Integer.MIN_VALUE;
          int currentSum = 0;
          int right = 0, left = 0, i = 0, j = 0;
          while (right < array.length) {
               currentSum = currentSum + array[right];
               if (currentSum < 0) {
                    currentSum = 0;
                    left = right + 1;
               }
               if (currentSum > maxSum) {
                    maxSum = currentSum;
                     i = left;
                     j = right;
               }
               right++;
          }
          for (int k = i; k <= j; k++) {
               System.out.println(array[k]);
          }
          return maxSum;
     }

     public static int maxSumOfSubArray1(int... array) {
          int maxSum = Integer.MIN_VALUE;
          int currentSum = 0;
          int right = 0, left = 0, lastRight = 0;
          while (right < array.length) {
               currentSum = currentSum + array[right];
               if (currentSum < 0) {
                    currentSum = 0;
               }
               maxSum = Math.max(currentSum, maxSum);
//               if (maxSum < currentSum) {
//                    maxSum = currentSum;
//                    lastRight = right;
//               }
               right++;
          }
//          for (int k = left; k <= lastRight; k++) {
//               System.out.println(array[k]);
//          }
          return maxSum;
     }

     private static int maxSumOfSubArrayByMaxMethod(int[] array) {
          int maxSum = array[0];
          int currentSum = array[0];
          for (int right = 1; right < array.length; right++) {
               currentSum = Math.max(array[right], currentSum + array[right]);
               maxSum = Math.max(currentSum, maxSum);
          }
          return maxSum;
     }

}
