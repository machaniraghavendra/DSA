package arrays;

public class PrintPairs {
     public static void main(String[] args) {
          printPairs(new int[]{1, 2, 3, 4, 5});
     }

     public static void printPairs(int[] arr) {
          for (int i : arr) {
               for (int k : arr) {
                    System.out.println(i + "" + k);
               }
               System.out.println("-------");
          }
     }
}
