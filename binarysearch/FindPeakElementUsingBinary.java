package binarysearch;


public class FindPeakElementUsingBinary {

     public static void main(String[] args) {
          System.out.println(findPeakElement(new int[]{1, 2, 4, 3, 5, 2}));
          BinarySearch binarySearch = new BinarySearch();
     }


     private static int findPeakElement(int[] nums) {
          int low = 0;
          int high = nums.length - 1;
          while (low < high) {
               int mid = low + (high - low) / 2;
               if (nums[mid] > nums[mid + 1]) {
                    high = mid;
               } else {
                    low = mid + 1;
               }
          }
          return nums[low];
     }
}
