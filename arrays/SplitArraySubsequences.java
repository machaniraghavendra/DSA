package arrays;

public class SplitArraySubsequences {

     public static void main(String[] args) {
          int[] arr = {2, 2, 3, 3, 4, 5};
//          int[] arr = {1, 1, 1, 1, 1};
          int k = 2;
          System.out.println(isPossible(arr, k));
     }

     public static boolean isPossible(int[] arr, int k) {
          if (k > arr.length) return false;
          boolean[] takenInConsider = new boolean[arr.length];
          int left = 0, right = 1;
          int[] temp = new int[k];
          int tempVar = 0;
          while (left < arr.length && right < arr.length) {
               temp[tempVar++] = arr[left];
               if (arr[left] < arr[right] && !takenInConsider[right] && !takenInConsider[left] && tempVar <= k) {
                    temp[tempVar++] = arr[right];
                    takenInConsider[left] = true;
                    takenInConsider[right] = true;
                    left++;
               }
               right++;
          }
          return false;
     }
}
