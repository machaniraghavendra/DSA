package arrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class CreateMapForListOfDuplicateStrings {

     public static void main(String[] args) {
          String[] r = new String[]{"ragfahs", "hsxgjsa"};
//          Arrays.asList(r).reve;

          List<String> kanak = Arrays.asList(r);
          Collections.sort(kanak);
//          FunInterface val = String::new;
          FunInterface val = new FunInterface() {
               @Override
               public String hello(String val) {
                    return val + "raghu";
               }
          };
//          System.out.println(val.hello("hello"));
//          System.out.println(val.hello1(1));
//          printMapOfString(List.of("abcde", "abc", "abcd", "ragha", "raghu", "ragha"));
          var map = new HashMap<String, Integer>();
          map.put("raghu1", 2000);
          map.put("raghu3", 1500);
          map.put("raghu2", 1500);
          map.put("raghu5", 1001);
          map.put("raghu", 1000);
          map.put("raghu4", 100);
//          printMapOfString(map, 2);
          printFirstRepeativeString("Java");
     }

     private static void printFirstRepeativeString(String value) {
          Set<Character> s = new HashSet<>();
          value.chars().mapToObj(a -> (char) a).parallel().filter(a -> !s.add(a)).findFirst()
               .ifPresentOrElse(System.out::println, () -> System.out.println("No value is repeated"));

          System.out.println(
               value.chars().mapToObj(a -> (char) a).parallel()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().filter(a -> a.getValue() > 1).findFirst().get().getKey()
          );
     }

     private static void printMapOfString(HashMap<String, Integer> map, Integer n) {
          Map<Integer, List<String>> salaryMap = map.entrySet().stream()
               .collect(Collectors.toMap(Map.Entry::getValue, a -> new ArrayList<>(List.of(a.getKey())),
                    (a, b) -> {
                         a.addAll(b);
                         return a;
                    }, TreeMap::new));
//          System.out.println(salaryMap);
          int index = n == 0 ? n : (salaryMap.size() - n);
          if (index > -1 && index < salaryMap.size()) {
               var valueAtN = salaryMap.keySet().stream().toList().get(index);
               //Just to make sure the sort order
//               int valueAtN = (int) salaryMap.keySet().stream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll).stream().toList().get(index);
               System.out.format("%s has %s salary.", valueAtN, salaryMap.get(valueAtN));
          } else {
               System.out.format("No value at %s", n);
               System.out.println();
          }
     }

     private static void printMapOfString(List<String> strings) {
          Map<String, Integer> value = new HashMap<>();
          Map<Integer, List<String>> values = new HashMap<>();
          AtomicReference<Integer> i = new AtomicReference<>(1);
          var sort = new Comparator<String>() {
               @Override
               public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
               }
          };
//          var s = new Stream<List<String>>();
//          values = strings.stream().sorted(sort)
//               .collect(Collectors.partitioningBy(s -> s.length()>1));
//          strings = strings.stream().sorted(sort.reversed())
//               .collect(Collectors.toMap(
//                    a -> {
//                         return value.computeIfAbsent(a, s -> i.getAndSet(i.get() + 1));
//                    },
//                    a -> new ArrayList<>(List.of(a))
//                    ,
//                    (a, b) -> {
//                         a.addAll(b);
//                         return a;
//                    },
//                    LinkedHashMap::new
//               ));
//          System.out.println(strings.stream().sorted(sort)
//               .collect(Collectors.partitioningBy(s -> s.length()>4)));
          Test test = new Test(1, "name", "12345");
          Test test1 = new Test(2, "name1", "12345");
          Test test2 = new Test(3, "name1", "123456");
          Test test3 = new Test(3, "name2", "12345777");
          var stringStringMap = Stream.of(test, test2, test3, test1)
//               .map(a->Integer.parseInt(a.getSalary()))
//               .reduce(0, Integer::max);
               .collect(groupingBy(Test::getName, TreeMap::new, Collectors.summingInt(value1 -> Integer.parseInt(value1.getSalary()))));
          System.out.println(stringStringMap);
//          System.out.println(strings.stream()
//               .collect(Collectors.toMap(String::length, (a) -> new ArrayList<>(List.of(a)), (a, b) -> {
//                    a.addAll(b);
//                    return a;
//               })));
//          printMapOfString(List.of("abcde", "abc", "abcd", "ragha", "raghu", "ragha"));

//          Map<Integer, List<Test>> s = Stream.of(test, test2, test3, test1).collect(Collectors.groupingBy(Test::getId));
//          Map<Integer, List<String>> s1 = Stream.of(test, test2, test3, test1)
//               .collect(Collectors.toMap(Test::getId, a -> new ArrayList<>(List.of(a.getName())),
//               (first, remaining) -> {
//                    first.addAll(remaining);
//                    return first;
//               }));
//          System.out.println(s);
//          System.out.println(s1);
     }
}
