package practice.arrays;

import java.util.Arrays;

import static arrays.MoveNegativesToOneSide.swap;
import static practice.arrays.sortings.Sortings.isNotValid;
import static practice.arrays.sortings.Sortings.mergeSort;

/**
 * A collection of common array-based programming questions and their solutions.
 */
public class ArraysQuestions {
     /**
      * The main method to demonstrate and test the array utility methods.
      *
      * @param args Command line arguments (not used).
      */
     public static void main(String[] args) {
          int[] largestElement = {4, 5, 8, 3, 2, 10, 6, 10};
          System.out.print("Find second largest element in array : " + Arrays.toString(largestElement) + ", result : ");
          System.out.println(findSecondLargestElement(largestElement, largestElement.length));
          int[] smallestElement = {4, 5, 8, 3, 2, 10, 6, 1};
          System.out.print("Find second smallest element in array : " + Arrays.toString(smallestElement) + ", result : ");
          System.out.println(findSecondSmallestElement(smallestElement, smallestElement.length));
          int[] removeDuplicates = {4, 5, 8, 3, 2, 10, 3, 2, 4};
          System.out.print("Remove duplicates in an array : Original = " + Arrays.toString(removeDuplicates) + ", result = ");
          System.out.println(Arrays.toString(removeDuplicates(removeDuplicates, removeDuplicates.length)));
          int[] removeDuplicatesOptimal = {4, 5, 8, 3, 2, 10, 3, 2, 4};
          System.out.print("Remove duplicates in an array by optimal approach : Original = " + Arrays.toString(removeDuplicatesOptimal) + ", result = ");
          System.out.println(Arrays.toString(removeDuplicatesOptimal(removeDuplicatesOptimal, removeDuplicatesOptimal.length)));
          int[] leftRotateByDPlaces = {4, 5, 8, 3, 2, 10, 3, 2, 4};
          System.out.print("Left rotate an array by D places : Original = " + Arrays.toString(leftRotateByDPlaces) + ", result = ");
          System.out.println(Arrays.toString(leftRotateByDPlaces(leftRotateByDPlaces, leftRotateByDPlaces.length, 5)));
          int[] rightRotateByDPlaces = {4, 5, 8, 3, 2, 10, 3, 2, 4};
          System.out.print("Right rotate an array by D places : Original = " + Arrays.toString(rightRotateByDPlaces) + ", result = ");
          System.out.println(Arrays.toString(rightRotateByDPlaces(rightRotateByDPlaces, rightRotateByDPlaces.length, 2)));
          int[] moveZerosToEnd = {3, 4, 0, 5, 0, 6, 1, 0, 0, 6, 2};
          System.out.print("Move zeroes to end : Original = " + Arrays.toString(moveZerosToEnd) + ", result = ");
          System.out.println(Arrays.toString(moveZerosToEnd(moveZerosToEnd, moveZerosToEnd.length)));
          int[] unionArrayA = {1, 3, 5, 7, 9, 11};
          int[] unionArrayB = {2, 4, 6, 8, 10, 12, 13};
          System.out.print("The union of " + Arrays.toString(unionArrayA) + " and " + Arrays.toString(unionArrayB) + ", result = ");
          System.out.println(Arrays.toString(unionOfTwoArrays(unionArrayA, unionArrayB)));
          int[] intersectionArrayB = {1, 1, 1, 2, 1, 3};
          int[] intersectionArrayA = {1, 2, 3};
          System.out.print("The intersection of " + Arrays.toString(intersectionArrayA) + " and " + Arrays.toString(intersectionArrayB) + ", result = ");
          System.out.println(Arrays.toString(intersection(intersectionArrayA, intersectionArrayB)));
          int[] missingNumberArray = {0, 2, 3, 1, 4};
          System.out.print("Missing number in array : " + Arrays.toString(missingNumberArray) + ", result : ");
          System.out.println(findMissingNumber(missingNumberArray, missingNumberArray.length));
          int[] singleNumberArr = {1, 2, 2, 4, 3, 1, 4};
          System.out.print("Single number in array : " + Arrays.toString(singleNumberArr) + ", result : ");
          System.out.println(singleNumber(singleNumberArr, singleNumberArr.length));
          int[] maxConsecutiveOnes = {1, 1, 0, 0, 1, 1, 1, 0};
          System.out.print("Maximum consecutive ones : " + Arrays.toString(maxConsecutiveOnes) + ", result : ");
          System.out.println(maxConsecutiveOnes(maxConsecutiveOnes, maxConsecutiveOnes.length));
          int[] longestSubArrayWithSumK = {10, 5, 2, 7, 1, 9};
//          int[] longestSubArrayWithSumK = {-3, 2, 1};
          int k = 15;
          System.out.print("Longest Subarray with sum k : " + k + " and for array : " + Arrays.toString(longestSubArrayWithSumK));
//          System.out.println(Arrays.toString(longestSubArrayWithSumK(longestSubArrayWithSumK, k)));
          System.out.println(Arrays.toString(longestSubArrayWithSumK(longestSubArrayWithSumK, k)));
//          int[] twoSum = {1, 6, 2, 10, 3};
//          int twoSumK = 7;
          int[] twoSum = {6, 7, 1, -7, 6, 2};
          int twoSumK = 12;
//          int[] twoSum = {1, 3, 5, -7, 6, -3};
//          int twoSumK = 0;
          System.out.print("Two sum for array : " + Arrays.toString(twoSum) + " of k = " + twoSumK + ", result : ");
          System.out.println(Arrays.toString(twoSum(twoSum, twoSumK)));
          int[] sort012 = {1, 0, 2, 1, 0};
          System.out.print("Sort of 0, 1 and 2 of " + Arrays.toString(sort012) + ", result");
          System.out.println(Arrays.toString(sort012(sort012, sort012.length)));
//          int[] majorityElement = {7, 0, 0, 1, 7, 7, 2, 7, 7};
          int[] majorityElement = {1, 1, 1, 2, 1, 2, 2, 2, 2};
//          int[] majorityElement = {3, 3, 1};
          System.out.print("Majority element in array : " + Arrays.toString(majorityElement) + ", result : ");
          System.out.println(majorityElement(majorityElement, majorityElement.length));
          int[] maxSubArraySum = {2, 3, 5, -2, 7, -4};
          System.out.print("Majority sub array sum using Kadane's algorithm : " + Arrays.toString(maxSubArraySum) + ", result : ");
          System.out.println(maxSubArraySumKadanesAlgo(maxSubArraySum));
     }

     /**
      * Finds the second-largest element in an array.
      * Note: This implementation first sorts the array, then iterates through it.
      * A more optimal single-pass approach exists that doesn't require sorting.
      *
      * @param arr The input array of integers.
      * @param n   The size of the array.
      * @return The second-largest element, or Integer.MIN_VALUE if not found.
      */
     private static int findSecondLargestElement(int[] arr, int n) {
          // Sorting is not the most efficient way, as it takes O(n log n).
          // A single pass O(n) solution is preferred.
          mergeSort(arr, n);
          int firstLargest = Integer.MIN_VALUE;
          int secondLargest = Integer.MIN_VALUE;
          // This loop is redundant after sorting. A simpler check on the sorted array would work.
          // However, this logic correctly handles duplicate largest elements.
          for (int i = 0; i < n; i++) {
               if (firstLargest < arr[i]) {
                    secondLargest = firstLargest;
                    firstLargest = arr[i];
               } else if (arr[i] < firstLargest && arr[i] > secondLargest) {
                    secondLargest = arr[i];
               }
          }
          return secondLargest;
     }

     /**
      * Finds the second-smallest element in an array.
      * Note: This implementation first sorts the array, then iterates through it.
      * A more optimal single-pass approach exists that doesn't require sorting.
      *
      * @param arr The input array of integers.
      * @param n   The size of the array.
      * @return The second-smallest element, or Integer.MAX_VALUE if not found.
      */
     private static int findSecondSmallestElement(int[] arr, int n) {
          // Sorting is not the most efficient way, as it takes O(n log n).
          // A single pass O(n) solution is preferred.
          mergeSort(arr, n);
          int firstSmallest = Integer.MAX_VALUE;
          int secondSmallest = Integer.MAX_VALUE;
          // This loop is redundant after sorting. A simpler check on the sorted array would work.
          // However, this logic correctly handles duplicate smallest elements.
          for (int i = 0; i < n; i++) {
               if (arr[i] < firstSmallest) {
                    secondSmallest = firstSmallest;
                    firstSmallest = arr[i];
               } else if (arr[i] > firstSmallest && arr[i] < secondSmallest) {
                    secondSmallest = arr[i];
               }
          }
          return secondSmallest;
     }

     /**
      * Removes duplicate elements from an array using a brute-force approach.
      * It marks duplicates with -1 and then creates a new array without them.
      * Note: This approach has a time complexity of O(n^2) and will fail if -1 is a valid element.
      *
      * @param arr The input array.
      * @param n   The size of the array.
      * @return A new array with duplicate elements removed.
      */
     private static int[] removeDuplicates(int[] arr, int n) {
          int countOfDuplicates = 0;
          // Nested loop to find and mark duplicates. O(n^2) complexity.
          for (int i = 0; i < n; i++) {
               for (int j = i + 1; j < n; j++) {
                    // Using -1 as a marker for duplicates.
                    if (arr[i] != -1 && arr[i] == arr[j]) {
                         arr[j] = -1;
                         countOfDuplicates++;
                    }
               }
          }
          // Create a new array with the size of unique elements.
          int newArraySize = n - countOfDuplicates;
          int[] newArray = new int[newArraySize];
          int newIndex = 0;
          // Copy non-duplicate elements to the new array.
          for (int i = 0; i < n; i++) {
               if (arr[i] != -1) {
                    newArray[newIndex++] = arr[i];
               }
          }
          return newArray;
     }

     /**
      * Removes duplicate elements from an array using an optimal two-pointer approach.
      * This method assumes the array is sorted first. It modifies the array in-place.
      *
      * @param arr The input array.
      * @param n   The size of the array.
      * @return A new array containing only the unique elements.
      */
     private static int[] removeDuplicatesOptimal(int[] arr, int n) {
          if (isNotValid(arr)) return arr;
          // Sorting is required for this two-pointer approach to work correctly.
          mergeSort(arr, n);
          int low = 0; // Pointer for the last unique element found.
          // Iterate through the array to find unique elements.
          for (int high = 1; high < n; high++) {
               // If a new unique element is found...
               if (arr[low] != arr[high]) {
                    //...move it to the next position after the last unique element.
                    arr[low + 1] = arr[high];
                    low++;
               }
          }
          // The unique elements are now in the range [0, low].
          // Create a new array of the correct size and copy the unique elements.
          int[] newArr = new int[low + 1];
          System.arraycopy(arr, 0, newArr, 0, low + 1);
          return newArr;
     }

     /**
      * Rotates an array to the left by a given number of places.
      * Note: This is a brute-force implementation with O(n*d) time complexity, where d is 'times'.
      * More optimal solutions like the reversal algorithm exist (O(n)).
      *
      * @param arr The array to rotate.
      * @param n   The size of the array.
      * @param k   The number of positions to rotate left.
      * @return The rotated array.
      */
     private static int[] leftRotateByDPlaces(int[] arr, int n, int k) {
          if (k == arr.length) return arr;
          // Repeats the single-rotation 'times' number of times.
          for (int i = 0; i < k; i++) {
               int j = 0;
               // This inner loop performs a single left rotation.
               while (j < n - 1) {
                    swap(arr, j, j + 1);
                    j++;
               }
          }
          return arr;
     }

     /**
      * Rotates an array to the right by a given number of places.
      * Note: This is a brute-force implementation with O(n*d) time complexity, where d is 'times'.
      * More optimal solutions like the reversal algorithm exist (O(n)).
      *
      * @param arr The array to rotate.
      * @param n   The size of the array.
      * @param k   The number of positions to rotate right.
      * @return The rotated array.
      */
     private static int[] rightRotateByDPlaces(int[] arr, int n, int k) {
          if (k == arr.length) return arr;
          // Repeats the single-rotation 'times' number of times.
          for (int i = 0; i < k; i++) {
               int j = n - 1;
               // This inner loop performs a single right rotation.
               while (j > 0) {
                    swap(arr, j - 1, j);
                    j--;
               }
          }
          return arr;
     }

     /* Moves all zeros in an array to the end.
      * Note: This implementation does not preserve the relative order of non-zero elements
      */
     private static int[] moveZerosToEnd(int[] arr, int n) {
          int high = n - 1;
          for (int left = 0; left < n; left++) {
               if (left < high && arr[left] == 0) {
                    swap(arr, left, high);
                    high--;
               }
          }
          return arr;
     }

     /**
      * Computes the union of two arrays.
      * The union contains all unique elements from both arrays.
      *
      * @param unionArrayA The first array.
      * @param unionArrayB The second array.
      * @return A new array representing the union of the two input arrays.
      */
     private static int[] unionOfTwoArrays(int[] unionArrayA, int[] unionArrayB) {
          // Create a new array to hold all elements from both arrays.
          int[] unionArrayWithDuplicates = new int[unionArrayA.length + unionArrayB.length];
          // Copy elements from the first array.
          for (int i = 0; i < unionArrayWithDuplicates.length; i++) {
               if (i < unionArrayA.length) {
                    unionArrayWithDuplicates[i] = unionArrayA[i];
               } else {
                    unionArrayWithDuplicates[i] = unionArrayB[i - unionArrayWithDuplicates.length + unionArrayB.length];
               }
          }
          // Remove duplicates from the combined array to get the final union.
          // A more efficient approach for sorted arrays would be a two-pointer merge.
          // Using a HashSet would also be very efficient: O(m+n).
          return removeDuplicatesOptimal(unionArrayWithDuplicates, unionArrayWithDuplicates.length);
     }

     private static int[] intersectionOfArrays(int[] a, int[] b) {
          final int aLength = a.length;
          final int bLength = b.length;
          int[] arr = new int[Math.min(aLength, bLength)];
          Arrays.fill(arr, Integer.MIN_VALUE);
          int count = 0;
          if (aLength == arr.length) {
               count = getCount(a, b, arr, count);
          }
          if (count == 0 && bLength == arr.length) {
               count = getCount(b, a, arr, count);
          }
          int[] newArr = new int[count];
          Arrays.fill(newArr, Integer.MIN_VALUE);

          int k = 0;
          for (int j : arr) {
               if (j != Integer.MIN_VALUE && k < count) {
                    newArr[k++] = j;
               }
          }
          int[] finalArr = new int[k];
          System.arraycopy(newArr, 0, finalArr, 0, k);
          return removeDuplicatesOptimal(finalArr, k);
     }

     private static int getCount(int[] intersectionArrayA, int[] intersectionArrayB, int[] intersectionArray, int count) {
          for (int i = 0; i < intersectionArray.length; i++) {
               for (int k : intersectionArrayB) {
                    if (intersectionArrayA[i] == k) {
                         intersectionArray[i] = intersectionArrayA[i];
                         count++;
                    }
               }
          }
          return count;
     }

     /**
      * Computes the intersection of two arrays.
      * The intersection contains unique elements that are present in both arrays.
      * Note: This brute-force approach has a high time complexity, roughly O(n*m*k) where k is the size
      * of the intersection, due to the nested loops.
      * For better performance, consider using HashSets (O(n+m)) or sorting both arrays and using a
      * two-pointer technique (O(n log n + m log m)).
      *
      * @param a The first array.
      * @param b The second array.
      * @return A new array representing the intersection of the two input arrays.
      */
     private static int[] intersection(int[] a, int[] b) {
          int[] intersection = new int[Math.min(a.length, b.length)];
          int index = 0;
          // Iterate through each element of the first array. O(n)
          for (int i : a) {
               boolean isFoundInB = false;
               // Check if the element exists in the second array. O(m)
               for (int j : b) {
                    if (i == j) {
                         isFoundInB = true;
                         break;
                    }
               }
               if (isFoundInB) {
                    // If found, check if it's already in our result to avoid duplicates. O(k)
                    boolean isThereInIntersection = false;
                    for (int j = 0; j < index; j++) {
                         if (intersection[j] == i) {
                              isThereInIntersection = true;
                              break;
                         }
                    }
                    // If it's not already in the result, add it.
                    if (!isThereInIntersection) {
                         intersection[index++] = i;
                    }
               }
          }
          // Create a new array of the correct size and copy the results.
          int[] newArr = new int[index];
          System.arraycopy(intersection, 0, newArr, 0, index);
          return newArr;
     }

     /**
      * Finds the missing number in an array of distinct numbers from 0 to n.
      * The array is assumed to contain n distinct numbers taken from 0, 1, 2, ..., n.
      * The missing number is the one that is not present in the array.
      * This method uses the sum formula for natural numbers to find the missing element.
      *
      * @param arr The input array of integers.
      * @param n   The size of the array (which means the numbers are from 0 to n-1, and one is missing).
      * @return The missing number, or -1 if the array is invalid or no number is missing.
      */
     private static int findMissingNumber(int[] arr, int n) {
          if (isNotValid(arr)) return -1;
          //According to formula sum of n natural numbers n(n+1)/2
          int totalSum = (n) * (n + 1) / 2;
          int sum = 0;
          for (int i = 0; i < n; i++) {
               sum += arr[i];
          }
          if (totalSum == sum) return -1;
          else {
               int result = Math.abs(totalSum - sum);
               return result > n - 1 ? -1 : result;
          }
     }

     private static int singleNumber(int[] arr, int n) {
          if (isNotValid(arr)) return -1;
          int result = Integer.MIN_VALUE;
          int count = 0;
          for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                    if (i != j && arr[i] == arr[j]) {
                         count++;
                         break;
                    }
               }
               if (count == 0) {
                    result = arr[i];
               }
               count = 0;
          }
          return result;
     }

     private static int maxConsecutiveOnes(int[] a, int n) {
          int maxOnes = 0;
          int right = 0, left = 0;
          int count = 0;
          while (left < n && right < n) {
               if (a[right] == 1 && maxOnes >= count) {
                    right++;
                    count++;
                    maxOnes = Math.max(maxOnes, count);
               } else {
                    left++;
                    right = left;
                    count = 0;
               }
          }
          return maxOnes;
     }

     private static int[] longestSubArrayWithSumK(int[] arr, int k) {
          int left = 0, right = 0, sum = 0, maxLength = 0;
          if (isNotValid(arr)) return new int[0];
          int leftPointer = 0, rightPointer = 0;
          while (left < arr.length && right < arr.length) {
               if (sum < k) {
                    sum += arr[right++];
               }
               if (sum == k) {
                    if (maxLength < (right - left)) {
                         maxLength = right - left;
                         leftPointer = left;
                         rightPointer = right;
                    }
                    sum = 0;
                    left++;
                    right = left;
               }
               if (right >= arr.length && sum != k) {
                    right = ++left;
               }
               if (rightPointer >= arr.length - 1) {
                    right++;
               }
          }
          if (maxLength > 0) {
               int[] result = new int[maxLength];
               int pointer = 0;
               for (int i = leftPointer; i < rightPointer; i++) {
                    result[pointer++] = arr[i];
               }
               System.out.print(", Size = " + maxLength + ", result : ");
               return result;
          }
          return new int[0];
     }

     private static int[] twoSum(int[] a, int k) {
          int[] result = new int[2];
          int left = 0, right = 0;
          while (left < a.length && right < a.length) {
               if (left != right && a[left] + a[right] == k) {
                    result[0] = left;
                    result[1] = right;
                    break;
               } else if (right >= a.length - 1) {
                    left++;
                    right = left;
               } else {
                    right++;
               }
          }
          return result;
     }

     private static int[] sort012(int[] arr, int n) {
          if (isNotValid(arr)) return arr;
//          Can be sorted using normal sorting algorithms
//          bubbleSort(arr, n);
          int ones = 0, twos = 0, zeros = 0;
          for (int i = 0; i < n; i++) {
               switch (arr[i]) {
                    case 0:
                         zeros++;
                         break;
                    case 1:
                         ones++;
                         break;
                    case 2:
                         twos++;
                         break;
                    default:
                         break;
               }
          }
          for (int i = 0; i < n; i++) {
               if (zeros > i) {
                    arr[i] = 0;
               } else if ((n - twos) > i) {
                    arr[i] = 1;
               } else {
                    arr[i] = 2;
               }
          }
          return arr;
     }

     private static int majorityElement(int[] a, int n) {
          if (isNotValid(a)) return -1;
          int left = 0, right = 0, element = Integer.MIN_VALUE, count = 0, maxCount = 0;
          while (left < n) {
               if (a[left] == a[right]) {
                    count++;
               }
               if (count > maxCount) {
                    element = a[left];
                    maxCount = count;
               }
               right++;
               if (right >= n) {
                    left++;
                    count = 0;
                    right = left;
               }
          }
          return element;
     }

     private static int maxSubArraySumKadanesAlgo(int[] a) {
          if (isNotValid(a)) return Integer.MIN_VALUE;
          int result = a[0];
          int maxEnding = 0;
          for (int i = 0; i < a.length; i++) {
               maxEnding = Math.max(maxEnding + a[i], a[i]);
               result = Math.max(result, maxEnding);
          }
          return result;
     }
}
