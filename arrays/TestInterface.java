package arrays;

//interface E {
//     default void show() { System.out.println("A"); }
//}

interface A {
     default void greet() {
          System.out.println("Hello from A");
     }
}

interface B {
     //     @Override
     default void greet() {
          System.out.println("Hello from B");
     }
}

class MyClass implements A, B {

     @Override
     public void greet() {
          A.super.greet();
     }
}

public class TestInterface extends Thread {
//     TestInterface() {
//          System.out.println("Started");
//     }


     @Override
     public void run() {
          System.out.println(Thread.currentThread());
          System.out.println("Inside run");
     }

     public static void main(String[] args) throws InterruptedException {
//          MyClass obj = new MyClass();
//          obj.greet();
//          System.out.println(Thread.currentThread().get);
          TestInterface testInterface = new TestInterface();
          Thread thread = new Thread(() -> {
               System.out.println(Thread.currentThread());
               System.out.println("Inside main thread");

          });
          testInterface.setPriority(Thread.MAX_PRIORITY);
          testInterface.start();
          thread.start();
          System.out.println(Thread.currentThread());
          System.out.println("ended");
     }
}
