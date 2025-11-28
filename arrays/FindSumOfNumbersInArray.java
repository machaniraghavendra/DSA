package arrays;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FindSumOfNumbersInArray {
     public static void main(String[] args) {
//          int[] arr = {121, 131, 141, 161};
          int[] arr = {123, 45, 6789};
          System.out.println(Arrays.toString(getSumOfNumbersInArray(arr)));
          System.out.println(Arrays.toString(getSumOfNumbersInArrayUsingStreams(arr)));
          System.out.println(Arrays.toString(getSumOfNumbersInArrayUsingStreams1(arr)));
          System.out.println(Arrays.toString(getSumOfNumbersInArrayUsingStreams2(arr)));
          System.out.println(Arrays.toString(getSumOfNumbersInArrayUsingStreams3(arr)));
     }

     private static int[] getSumOfNumbersInArray(int[] arr) {
          int[] result = new int[arr.length];
          for (int i = 0; i < arr.length; i++) {
               int num = arr[i];
               int divisor = (int) Math.pow(10, String.valueOf(num).length() - 1);
               int sum = 0;
               while (num > 0) {
                    int leftNum = num / divisor;
                    num = (num % divisor);
                    sum += leftNum;
                    divisor = divisor / 10;
               }
               result[i] = sum;
          }
          return result;
     }

     private static int[] getSumOfNumbersInArrayUsingStreams(int[] arr) {
          return Arrays.stream(arr).boxed().mapToInt(num -> {
               int divisor = (int) Math.pow(10, String.valueOf(num).length() - 1);
               int sum = 0;
               while (num > 0) {
                    int leftNum = num / divisor;
                    num = (num % divisor);
                    sum += leftNum;
                    divisor = divisor / 10;
               }
               return sum;
          }).toArray();
     }

     private static int[] getSumOfNumbersInArrayUsingStreams1(int[] arr) {
          return Arrays.stream(arr).boxed().mapToInt(num -> {
               char[] carr = String.valueOf(num).toCharArray();
               return IntStream.range(0, carr.length)
                    .map(i -> Character.getNumericValue(carr[i]))
                    .reduce(Integer::sum).orElse(0);
          }).toArray();
     }

     private static int[] getSumOfNumbersInArrayUsingStreams2(int[] arr) {
          return Arrays.stream(arr).boxed()
               .mapToInt(num -> IntStream.range(0, String.valueOf(num).length())
                    .map(i -> Character.getNumericValue(String.valueOf(num).toCharArray()[i]))
                    .sum()
               ).toArray();
     }

     private static int[] getSumOfNumbersInArrayUsingStreams3(int[] arr) {
          return Arrays.stream(arr).boxed()
               .mapToInt(num -> Arrays.stream(String.valueOf(num).split(""))
                    .mapToInt(Integer::valueOf).sum())
               .toArray();
     }
}
