package arrays;

@FunctionalInterface
public interface FunInterface {
     String hello(String val);

     default String hello1(Integer val) {
          return null;
     }
}
