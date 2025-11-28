package arrays;

import java.util.Scanner;

public class NumberToWords {
     static String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
     static String[] tens = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
     static String[] tensPlace = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
     static String[] higherValues = {" thousand ", " million ", " billion "};

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter any number : ");
          int number = sc.nextInt();
          if (number > 999999) {
               System.out.println("Value should be less than 999999");
               return;
          }
          StringBuilder value = new StringBuilder();
          if (number == 0) {
               value.append("zero");
          } else if (number <= 10) {
               value.append(units[number]);
          } else {
               getWordForNumber(number, value);
          }
          String result = value.toString().trim();
          System.out.println(result.substring(0, 1).toUpperCase() + result.substring(1));
     }

     private static void getWordForNumber(int number, StringBuilder value) {
          while (number / 100000 != 0) {
               value.append(units[number / 100000]).append(higherValues[1]);
               number = number % 100000;
          }
          while (number / 1000 != 0) {
               if (number / 1000 > 11) {
                    value.append(getTensValues(number / 1000)).append(higherValues[0]);
                    number = number % 1000;
               } else {
                    value.append(units[number / 1000]).append(higherValues[0]);
                    number = number % 1000;
               }
          }
          while (number / 100 != 0) {
               String tensValues = getTensValues(number % 100);
               value.append(units[number / 100]).append(" hundred ").append(tensValues.isEmpty() ? "" : "and ").append(tensValues);
               number = number / 100;
          }
          while (number / 10 != 0) {
               value.append(getTensValues(number % 100));
               number = number / 10;
          }
     }

     private static String getTensValues(int i) {
          int quotient = i / 10;
          int remainder = i % 10;
          String tensValue = tens[quotient];
          String unitsValue = quotient == 0 ? units[remainder] : quotient == 1 ? tensPlace[remainder] : units[remainder];
          return tensValue + unitsValue;
     }
}
