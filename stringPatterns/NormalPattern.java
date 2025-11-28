package stringPatterns;

public class NormalPattern {

     public static void main(String[] args) {
          for (int i = 'A'; i <= 'Z' ; i++) {
               System.out.print(Character.toString(i));
          }
//          printPattern(177);
     }

     private static void printPattern(int max) {
          for (int i = 1; i <= max; i++) {
               for (int j = 1; j <= max - i; j++) {
                    System.out.print(" ");
               }
               for (int j = 1; j <= i; j++) {
                    System.out.print(i*j + " ");
               }
               System.out.println();
          }
     }
}
