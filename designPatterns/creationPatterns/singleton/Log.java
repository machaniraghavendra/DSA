package designPatterns.creationPatterns.singleton;

/**
 * # Ensures a class has only one instance and provides a global point of access to it
 * # Bill pugh singleton pattern
 */
public class Log {
     private Log() {
     }

     private static class Logger {
          private static final Log INSTANCE = new Log();
     }

     public static Log getInstance() {
          return Logger.INSTANCE;
     }

     public void log(String message) {
          System.out.println(message);
     }
}

class SingletonTest {
     public static void main(String[] args) {
          Log.getInstance().log("Hello world!");
     }
}
