package kanakExamples;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1 {

     //     void hello();
     private static final Object lock = new Object();
     private static char currentChar = 'A';
     private static int turn = 1;

     public static void main(String[] args) throws InterruptedException {
          System.out.println(List.of(1, 2, 3).stream().mapToInt(num -> num).max().orElse(Integer.MIN_VALUE));
          System.out.println(List.of("1", "2", "31").stream().mapToInt(String::length).max().orElse(Integer.MIN_VALUE));
          System.out.println(List.of("1", "2", "31").stream().max(Comparator.comparingInt(String::length)).orElse("No String"));
          System.out.println(IntStream.rangeClosed(1, 10).reduce((a, b) -> a * b).orElse(Integer.MIN_VALUE));
          System.out.println(findIndex(7, List.of(1, 2, 7, 4, 5, 6, 7, 8)));
          System.out.println("Hello World".chars().filter(c -> !"aeiouAEIOU".contains(String.valueOf(c))).mapToObj(c -> (char) c)
               .map(String::valueOf).reduce((a, b) -> a + "" + b).get());
          System.out.println("Hello World".chars().filter(x -> !"aeiouAEIOU".contains(String.valueOf((char) x)))
               .mapToObj(a -> String.valueOf((char) a)).collect(Collectors.joining()));

          String val = "traditional way of aging";
          System.out.println(replace(val, 'a', '*'));
          System.out.println(checkStringContainsOnlyDigits("124"));


//          IdentityHashMap<String, String> map = new IdentityHashMap<>();
//
//          String a1 = new String("key");
//          String a2 = new String("key");
//
//          map.put(a1, "Value1");
//          map.put(a2, "Value2");
//
//
//          System.out.println(map.get(a2));  // {key=Value1, key=Value2}
////          System.out.println(5 ^ 1);
////          Set<String> set = new ConcurrentSkipListSet<>();
////          set.add("");
//          EnumTest enumTest = EnumTest.SECOND;
//          enumTest.hello();
////          enumTest.setString("setString");
//          System.out.println(enumTest.getString());

//
//          Runnable task1 = () -> {
//               synchronized (lock) {
//                    while (currentChar <= 'Z') {
//                         if (turn == 1) {
//                              System.out.println("Thread : " + Thread.currentThread() + " : " + currentChar++);
//                              turn = 2;
//                              lock.notifyAll();
//                         } else {
//                              waitSafely();
//                         }
//                    }
//               }
//          };
//          Runnable task2 = () -> {
//               synchronized (lock) {
//                    while (currentChar <= 'Z') {
//                         if (turn == 2) {
//                              System.out.println("Thread : " + Thread.currentThread() + " : " + currentChar++);
//                              turn = 1;
//                              lock.notifyAll();
//                         } else {
//                              waitSafely();
//                         }
//                    }
//               }
//          };
//          var start = System.currentTimeMillis();
//
//          Thread thread1 = new Thread(task1);
//          Thread thread2 = new Thread(task2);
//          thread1.start();
//          thread2.start();
//          System.out.println(System.currentTimeMillis() - start);

//          var start1 = System.currentTimeMillis();
//          print();
//          System.out.println(System.currentTimeMillis() - start1);
     }

     private static int findIndex(int i, List<Integer> integers) {
          return IntStream.range(0, integers.size()).filter(a -> integers.get(a) == i).findFirst().orElse(Integer.MIN_VALUE);
     }

     private static String replace(String s, char old, char replace) {
          return s.chars().mapToObj(a -> a == old ? replace : (char) a)
               .collect(()-> new StringBuilder(), (a, b)->a.append(b), (a, b)->a.append(b)).toString();
     }

     private static boolean checkStringContainsOnlyDigits(String str){
//          return str.chars().mapToObj(c -> (char) c).filter(c -> !Character.isDigit(c)).toList().isEmpty();
//          return str.chars().allMatch(Character::isDigit);
          return str.chars().allMatch(a->a>='0' && a<='9');
     }

     private static void waitSafely() {
          try {
               lock.wait();
          } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
          }
     }

     public static void print() {
          while (currentChar <= 'Z') {
//               if (turn == 2) {
               System.out.println("Thread : " + Thread.currentThread() + " : " + currentChar++);
//                    turn = 1;
//                    lock.notifyAll();
//               } else {
//                    waitSafely();
//               }
          }
     }

     public static String findCharacter(int k, String s) {
          for (int i = k; i < s.length() - k; i++) {
               if (s.charAt(i - k) == s.charAt(i) && s.charAt(i + k) == s.charAt(i)) {
                    return String.valueOf(s.charAt(i));
               }
          }
          return "";
     }
}
//
//enum EnumTest implements Test1 {
//     FIRST("FIRST") {
//          @Override
//          public void hello() {
//               System.out.println("Hello1");
//          }
//     }, SECOND("SECOND") {
//          @Override
//          public void hello() {
//               System.out.println("Hello2");
//          }
//     };
//
//     String string;
//
//     EnumTest(String string) {
//          this.string = string;
//     }
//
//     void setString(String string){
//          this.string = string;
//     }
//
//     String getString(){
//          return string;
//     }
//
//}




