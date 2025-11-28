package arrays;

public class MaxProfit {
     public static void main(String[] args) {
          System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
     }

     public static int maxProfit(int[] prices) {
          int minPrice = Integer.MAX_VALUE;
          int maxProfit = 0;
          for (int price : prices) {
               if (price < minPrice) {
                    minPrice = price;
               }
               int currentProfit = price - minPrice;
               if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
               }
          }
          return maxProfit;
     }
}
