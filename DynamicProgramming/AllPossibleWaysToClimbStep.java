package DynamicProgramming;

public class AllPossibleWaysToClimbStep {
     public static void main(String[] args) {
          int steps = 5;
          System.out.println(possibleWays(steps));
     }

     private static int possibleWays(int step) {
          return backtrack(step);
     }

     private static int backtrack(int index) {
          if (index == 0) return 1;
          if (index == 1) return 1;
          int left = backtrack(index - 1);
          int right = backtrack(index - 2);
          return left + right;
     }
}
