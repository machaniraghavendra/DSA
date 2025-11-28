package practice.recursion;

public class PrintNumbers {
     public static void main(String[] args) {
          int k = 10;
          printNumbers(k);
          printName(0, k);
     }

     private static void printNumbers(int k) {
          printNumbers(0, k);
     }

     private static void printNumbers(int count, int k) {
          if (count == k) return;
          System.out.println(count);
          printNumbers(count + 1, k);
     }

     private static void printName(int count, int k) {
          if (count == k) return;
          System.out.println("Raghu");
          printName(count + 1, k);
     }
}
