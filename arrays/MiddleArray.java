package arrays;

import java.util.Arrays;

public class MiddleArray {
     public static int[] middle(int[] array) {
          int[] newArray = null;
          if (array.length > 2) {
               newArray = new int[array.length - 2];
          } else {
               System.out.println("Array should be greater than size 2");
               return null;
          }
          for (int i = 0; i < newArray.length; i++) {
               newArray[i] = array[i+1];
          }
          return newArray;
     }

     public static void main(String[] args) {
          System.out.println(Arrays.toString(middle(new int[]{1, 2, 3, 4, 5, 6})));
     }
}
