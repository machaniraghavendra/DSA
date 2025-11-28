package arrays;

public class MaxProductOfTwoInt {
     public static void main(String[] args) {
          System.out.println(maxProduct(new int[]{70, 20, 30, 40, 50}));
     }

     public static String maxProduct(int[] intArray) {
          int firstMax = Integer.MIN_VALUE;
          int secondMax = Integer.MIN_VALUE;
          for (int num : intArray) {
               if (num > firstMax) {
                    secondMax = firstMax;
                    firstMax = num;
               } else if (num > secondMax) {
                    secondMax = num;
               }
          }
          return firstMax + "," + secondMax;
     }
}
