package stacks;

import java.util.ArrayList;
import java.util.List;

//LIFO-last in first out or FILO - First in last out (EX: Books)
//https://www.geeksforgeeks.org/stack-data-structure/

//     Push: Adds an element to the top of the stack.
//     Pop: Removes the top element from the stack.
//     Peek: Returns the top element without removing it.
//     IsEmpty: Checks if the stack is empty.
//     IsFull: Checks if the stack is full (in case of fixed-size arrays):
public class Stacks<T> {

     private final List<T> stack = new ArrayList<>();

     private int currentIndex = -1;

     public void push(T value) {
          System.out.println("Pushing the element in stack : " + value);
          stack.add(++currentIndex, value);
          printStack();
     }

     public void pop() {
          if (!isEmpty(true)) {
               System.out.printf("Poping the element : %s %n", stack.get(currentIndex));
               stack.remove(currentIndex--);
               printStack();
          } else {
               System.out.printf("Stack is empty : %s %n", stack);
          }
     }

     public void getPeek() {
          System.out.printf("Peek element is : %s%n", stack.get(currentIndex));
     }

     public boolean isEmpty(boolean callingFromParent) {
          if (stack.isEmpty()) {
               if (!callingFromParent) System.out.println("The stack is empty\n");
               return true;
          } else {
               if (!callingFromParent) System.out.println("The stack is not empty\n");
               return false;
          }
     }

     private void printStack() {
          System.out.printf("The new stack is : %s\n%n", stack);
     }

}