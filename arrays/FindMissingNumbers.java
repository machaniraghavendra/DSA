package arrays;

public class FindMissingNumbers {

     public static void main(String[] args) {
          System.out.println(findMissingNumberInArray(new int[]{1, 2, 3, 4, 5, 6, 7, 9}));
     }

     static int findMissingNumberInArray(int[] arr) {
          for (int i = 0; i < arr.length; i++) {
               if (i + 1 != arr[i]) {
                    return i + 1;
               }
          }
          return -1;
     }
}
