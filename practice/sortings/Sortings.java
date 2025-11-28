package practice.arrays.sortings;

import java.util.ArrayList;
import java.util.Arrays;

public class Sortings {
     public static void main(String[] args) {
          int[] arr = {4, 7, 10, 5, 2, 8, 1};
          System.out.print("Selection sort : ");
          System.out.println(Arrays.toString(selectionSort(arr, arr.length))); // Time O(N^2), Space O(1)
          int[] bubbleArr = {4, 7, 10, 5, 2, 8, 1};
          System.out.print("Bubble sort : ");
          System.out.println(Arrays.toString(bubbleSort(bubbleArr, bubbleArr.length))); // Time O(N^2), Space O(1)
          int[] insertionArr = {4, 7, 10, 5, 2, 8, 1};
          System.out.print("Insertion sort : ");
          System.out.println(Arrays.toString(insertionSort(insertionArr, insertionArr.length))); // Time best case O(N), Avg case O(N^2), space O(1)
          int[] mergeArr = {4, 7, 10, 5, 2, 8, 1};
          System.out.print("Merge sort : ");
          System.out.println(Arrays.toString(mergeSort(mergeArr, mergeArr.length)));// TIme O(NlogN), space O(N)
          int[] quickArr = {4, 7, 10, 5, 2, 8, 1};
          System.out.print("Quick sort : ");
          System.out.println(Arrays.toString(quickSort(quickArr, quickArr.length))); // Time O(NlogN), space O(1)

     }

     public static int[] selectionSort(int[] arr, int n) {
          if (isNotValid(arr)) return arr;
          for (int i = 0; i < n - 1; i++) {
               int minValueIndex = i;
               //Find min value index
               for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minValueIndex]) {
                         minValueIndex = j;
                    }
               }
               //After finding swap
               swap(arr, minValueIndex, i);
          }
          return arr;
     }

     public static int[] bubbleSort(int[] arr, int n) {
          if (isNotValid(arr)) return arr;
          for (int i = 0; i < n - 1; i++) {
               for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
               }
          }
          return arr;
     }

     public static int[] insertionSort(int[] arr, int n) {
          if (isNotValid(arr)) return arr;
          for (int i = 1; i < n; i++) {
               int element = arr[i];
               int j = i - 1;
               while (j >= 0 && arr[j] > element) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
               }
               arr[j + 1] = element;
          }
          return arr;
     }

     public static int[] mergeSort(int[] arr, int length) {
          if (isNotValid(arr)) return arr;
          mergeSort(arr, 0, length - 1);
          return arr;
     }

     private static void mergeSort(int[] arr, int low, int high) {
          if (low == high) return;
          int mid = (low + high) / 2;
          mergeSort(arr, low, mid);
          mergeSort(arr, mid + 1, high);
          merge(arr, low, mid, high);
     }

     private static void merge(int[] arr, int low, int mid, int high) {
          ArrayList<Integer> temp = new ArrayList<>();
          int left = low;
          int right = mid + 1;
          while (left <= mid && right <= high) {
               if (arr[left] <= arr[right]) {
                    temp.add(arr[left]);
                    left++;
               } else {
                    temp.add(arr[right]);
                    right++;
               }
          }
          while (left <= mid) {
               temp.add(arr[left]);
               left++;
          }
          while (right <= high) {
               temp.add(arr[right]);
               right++;
          }
          for (int i = low; i <= high; i++) {
               arr[i] = temp.get(i - low);
          }
     }

     public static int[] quickSort(int[] arr, int length) {
          quickSort(arr, 0, length - 1);
          return arr;
     }

     private static void quickSort(int[] arr, int low, int high) {
          if (low < high) {
               int pi = partition(arr, low, high);
               quickSort(arr, low, pi - 1);
               quickSort(arr, pi + 1, high);
          }
     }

     private static int partition(int[] arr, int low, int high) {
          int pivot = arr[high];
          int i = low - 1;
          for (int j = low; j <= high - 1; j++) {
               if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
               }
          }
          swap(arr, i + 1, high);
          return i + 1;
     }

     public static boolean isNotValid(int[] arr) {
          return arr.length == 0;
     }

     private static void swap(int[] arr, int from, int to) {
          int temp = arr[to];
          arr[to] = arr[from];
          arr[from] = temp;
     }
}
