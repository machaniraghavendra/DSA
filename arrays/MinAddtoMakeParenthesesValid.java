package arrays;

import java.util.HashMap;

public class MinAddtoMakeParenthesesValid {
     public static void main(String[] args) {
          String value = "(()(";
//          String value = ")))";
//          String value = ")()()";
//          String value = "()))()()((())";
          System.out.println(minParentheses(value));

          System.out.println((String) null);
     }

     private static int minParentheses(String value) {
//          int open = 0, close = 0;
//          for (char c : value.toCharArray()) {
//               if (c == '(') {
//                    open++;
//               } else if (c == ')') {
//                    if (open > 0) {
//                         open--;
//                    } else {
//                         close++;
//                    }
//               }
//          }
//          return open + close;
          HashMap<Character, Integer> map = new HashMap<>();
          for (char c : value.toCharArray()) {
               if (c == '(') {
                    map.put(c, map.getOrDefault(c, 0) + 1);
               } else if (c == ')') {
                    if (map.getOrDefault('(', 0) > 0) {
                         map.put('(', map.get('(') - 1);
                    } else {
                         map.put(c, map.getOrDefault(c, 0) + 1);
                    }
               }
          }
          return map.getOrDefault('(', 0) + map.getOrDefault(')', 0);
     }
}
