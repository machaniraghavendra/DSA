package practice.recursion;

public class SumOfNNumbers {
     public static void main(String[] args) {
          int n = 3;
          System.out.println(getSumOfN(3));
     }

     private static int getSumOfN(int n) {
          return getSumOfN(n, 0);
     }

     private static int getSumOfN(int n, int sum) {
          if (n < 1) return sum;
          return getSumOfN(n - 1, sum + n);
     }
}
