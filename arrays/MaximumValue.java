package arrays;

public class MaximumValue {
     public static void main(String[] args) {
          int[] arr = new int[]{1, 6, 5, 2, 9, 3, 6, 9, 2, 1};
          long start = System.currentTimeMillis();
          System.out.println(maximumValue(arr));
          System.out.println(System.currentTimeMillis() - start);
          long start1 = System.currentTimeMillis();
          System.out.println(maxVal(arr));
          System.out.println(System.currentTimeMillis() - start1);

     }

     static Integer max = Integer.MIN_VALUE;

     private static int maximumValue(int[] arr) {
          int i = 0, j = 0, k = 0;
          if (arr.length == 3) {
               j = 1;
               k = 2;
               return evaluateExpression(i, j, k, arr);
          }
          backTrack(0, 0, 0, arr);
          return max;
     }

     private static void backTrack(int i, int j, int k, int[] arr) {
          if (i == arr.length - 1 || j == arr.length - 1 || k == arr.length - 1) {
               max = Math.max(max, evaluateExpression(i, j, k, arr));
               return;
          }
          backTrack(i + 1, j + 1, k + 1, arr);
          backTrack(i, j, k + 1, arr);
          backTrack(i, j + 1, k, arr);
          backTrack(i + 1, j, k, arr);
     }

     private static int evaluateExpression(int i, int j, int k, int[] arr) {
          return Math.abs(arr[i] - arr[j]) + Math.abs(arr[j] - arr[k]) + Math.abs(arr[k] - arr[i]);
     }

     private static int maxVal(int[] arr) {
          if (arr.length < 2) return -1;
          int min = Integer.MAX_VALUE;
          int max = Integer.MIN_VALUE;

          for (int num : arr) {
               min = Math.min(min, num);
               max = Math.max(max, num);
          }
          return 2 * (max - min);
     }
}
