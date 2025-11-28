package arrays;

import java.util.stream.IntStream;

public class IsIsomorphic {
     public static void main(String[] args) {
//          String s = "egg", t = "add";
          String s = "badc", t = "baba";
//          String s = "paper", t = "title";
          System.out.println(isIsomorphicByStreams(s, t));
     }

     public static boolean isIsomorphicByStreams(String s, String t) {
          return IntStream.range(1, s.length()).allMatch(i -> s.indexOf(s.charAt(i)) == t.indexOf(t.charAt(i)));
     }
}
