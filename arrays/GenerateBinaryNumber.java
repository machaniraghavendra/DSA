package arrays;

import java.util.ArrayList;
import java.util.stream.IntStream;

/*
* Input: n = 4
Output: ["1", "10", "11", "100"]
Explanation: Binary numbers from 1 to 4 are 1, 10, 11 and 100.
Input: n = 6
Output: ["1", "10", "11", "100", "101", "110"]
Explanation: Binary numbers from 1 to 6 are 1, 10, 11, 100, 101 and 110.
*/

public class GenerateBinaryNumber {
     public static void main(String[] args) {
          int n = 4;
          System.out.println(generateBinary(n));
     }

     public static ArrayList<String> generateBinary(int n) {
          ArrayList<String> result = new ArrayList<>();
          IntStream.rangeClosed(1, n).forEach(number -> {
               result.add(convertNumberToBinary(number));
//               result.add(Integer.toBinaryString(number));
          });
          return result;
     }

     private static String convertNumberToBinary(int n) {
          if (n == 0) {
               return "0";
          }
          StringBuilder builder = new StringBuilder();
          int quotient = n;
          while (quotient > 0) {
               int remainder = quotient % 2;
               builder.insert(0, remainder);
               quotient = quotient / 2;
          }
          return builder.toString();
     }
}
