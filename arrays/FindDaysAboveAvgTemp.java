package arrays;

import java.util.Scanner;

public class FindDaysAboveAvgTemp {
     int[] temperatures = null;
     int totalDays = 0;
     int sumOfTemp = 0;

     public FindDaysAboveAvgTemp(int totalDays) {
          temperatures = new int[totalDays];
     }

     public void findDaysWhichAreAboveAvgTemp() {
          try (Scanner sc = new Scanner(System.in)) {
               while (totalDays != temperatures.length) {
                    System.out.println(totalDays + 1 + " totalDays Temperature");
                    int temp = sc.nextInt();
                    temperatures[totalDays] = temp;
                    totalDays++;
                    sumOfTemp += temp;
               }
               double avg = (double) sumOfTemp / totalDays;
               System.out.println("Average of temp : " + avg);
               int totalDays = 0;
               for (var temp : temperatures) {
                    if (temp > avg) {
                         totalDays++;
                    }
               }
               System.out.println("Total totalDays which are above average temp is : " + totalDays);
          }
     }

     public static void main(String... args) {
          try(Scanner sc = new Scanner(System.in)) {
               System.out.println("Enter total number of totalDays : ");
               int totalDays = sc.nextInt();
               FindDaysAboveAvgTemp findDaysAboveAvgTemp = new FindDaysAboveAvgTemp(totalDays);
               findDaysAboveAvgTemp.findDaysWhichAreAboveAvgTemp();
          }
     }

}
