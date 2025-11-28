package arrays;

import java.util.ArrayList;

public class PossibleWordsFromPhoneNumbers {
     public static void main(String[] args) {
          int[] arr = new int[]{8,1, 8};
          System.out.println(possibleWords(arr));
     }

     public static ArrayList<String> possibleWords(int[] arr) {
          ArrayList<String> result = new ArrayList<>();
          backTrack(arr, 0, new StringBuilder(), result);
          return result;
     }

     private static void backTrack(int[] arr, int index, StringBuilder builder, ArrayList<String> result) {
          if (index == arr.length) {
               result.add(builder.toString());
               return;
          }

          //Skip the step of adding in builder and make builder to add in result
          if (arr[index] == 0 || arr[index] == 1) {
               backTrack(arr, index + 1, builder, result);
               return;
          }

          String word = getWord(arr[index]);
          for (char c : word.toCharArray()) {
               builder.append(c);
               backTrack(arr, index + 1, builder, result);
               builder.deleteCharAt(builder.length() - 1);
          }
     }

     private static String getWord(int num) {
          return switch (num) {
               case 2 -> "abc";
               case 3 -> "def";
               case 4 -> "ghi";
               case 5 -> "jkl";
               case 6 -> "mno";
               case 7 -> "pqrs";
               case 8 -> "tuv";
               case 9 -> "wxyz";
               default -> "";
          };
     }
}
