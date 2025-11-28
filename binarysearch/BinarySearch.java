package binarysearch;



public class BinarySearch  {

     public static void main(String[] args) {
          int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8, 9};
          int element = 6;
          System.out.println("At index : " + getIndexOfElementByBinarySearch(arr, arr.length, element));
          System.out.println("At index : " + getIndexOfElementByBinarySearchUsingRecursion(arr, 0, arr.length - 1, element));
     }
     private static int getIndexOfElementByBinarySearch(int[] arr, int n, int element) {
          if (element > arr[n - 1]) return -1;
          int low = 0, high = n - 1, mid = 0;
          while (low <= high) {
               mid = (low + high) / 2;
               if (arr[mid] == element) return mid;
               else if (arr[mid] > element) high = mid - 1;
               else low = mid + 1;
          }
          return -1;
     }

     private static int getIndexOfElementByBinarySearchUsingRecursion(int[] arr, int low, int high, int element) {
          if (low > high) return -1;
          int mid = (low + high) / 2;
          if (arr[mid] == element) return mid;
          else if (arr[mid] > element) return getIndexOfElementByBinarySearchUsingRecursion(arr, low, mid - 1, element);
          return getIndexOfElementByBinarySearchUsingRecursion(arr, mid + 1, high, element);
     }
}
