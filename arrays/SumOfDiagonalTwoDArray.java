package arrays;

public class SumOfDiagonalTwoDArray {
     public static int sumDiagonalElements(int[][] array) {
          int sum = 0;
          for (int i = 0; i < array.length; i++) {
               //primary diagonal
               sum += array[i][i];
               //secondary diagonal
//               sum += array[i][array.length - 1 - i];
          }
          return sum;
     }

     public static void main(String[] args) {
          System.out.println(sumDiagonalElements(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
     }
}
