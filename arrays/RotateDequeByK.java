package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class RotateDequeByK {

     public static void main(String[] args) {
          Deque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3, 4, 5, 6));
          int type = 1;
          int k = 2;
          int[] arr = new int[]{1, 2, 3, 4, 5, 6};
          rotateArray(arr, type, k);
          rotateDeque(deque, type, k);
          System.out.println(deque);
          System.out.println(Arrays.toString(arr));
     }

     private static void rotateDeque(Deque<Integer> dq, int type, int k) {
          if (dq.isEmpty()) return;
          for (int i = 0; i < k; i++) {
               switch (type) {
                    case 1 -> {
                         Integer element = dq.pollLast();
                         dq.addFirst(element);
                    }
                    case 2 -> {
                         Integer element = dq.pollFirst();
                         dq.addLast(element);
                    }
               }
          }
     }

     private static void rotateArray(int[] arr, int type, int k) {
          int n = arr.length;
          if (n < 1) return;
          if (n == k) return;
          for (int i = 0; i < k; i++) {
               switch (type) {
                    case 1 -> {
                         //right shift
                         int lastElement = arr[n - 1];
                         for (int j = n - 1; j > 0; j--) {
                              arr[j] = arr[j - 1];
                         }
                         arr[0] = lastElement;
                    }
                    case 2 -> {
                         //left shift
                         int firstElement = arr[0];
                         for (int j = 0; j < n - 1; j++) {
                              arr[j] = arr[j + 1];
                         }
                         arr[n - 1] = firstElement;
                    }
               }
          }
     }
}
