package arrays;

public class Permutation {
     public static void main(String[] args) {
          System.out.println(permutation(new int[]{1, 2, 3, 4, 6}, new int[]{ 1, 2, 3, 4, 5}));
     }

     public static boolean permutation(int[] array1, int[] array2) {
          boolean isPermutation = true;
          if (array1.length != array2.length) return false;
          first_loop:
          for (int k : array1) {
               boolean numberContains = false;
               second_loop:
               for (int j = 0; j < array1.length; j++) {
                    if (k == array2[j]) {
                         numberContains = true;
                         break second_loop;
                    }
               }
               if (!numberContains) {
                    isPermutation = false;
                    break;
               }
          }
          return isPermutation;
     }
}
