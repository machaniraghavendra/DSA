package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseArray {
     public static void main(String[] args) {
          List<String> list = new LinkedList<>();
          var arr = reverseArray(new int[]{1, 2, 3, 4, 5,6});
          System.out.println(Arrays.toString(arr));
     }

     public static int[] reverseArray(int[] arr) {
          for (int i = 0; i < arr.length / 2; i++) { //-----------O(n/2)--->O(n)
               int temp = arr[i];                    //-----------O(1)
               arr[i] = arr[arr.length - 1 - i];     //-----------O(1)
               arr[arr.length - 1 - i] = temp;       //-----------O(1)
          }
          return arr;                                //-----------O(1)
     }
}
