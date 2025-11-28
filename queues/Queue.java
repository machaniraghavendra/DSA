package queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//FIFO (FIRST COME FIRST OUT)
//Enqueue: Adds (or stores) an element to the end of the queue..
//Dequeue: Removal of elements from the queue.
//Peek or front: Acquires the data element available at the front node of the queue without deleting it.
//Rear: This operation returns the element at the rear end without removing it.
//isFull: Validates if the queue is full.
//isEmpty: Checks if the queue is empty.

public class Queue<T> {


     private final List<T> queue = new ArrayList<>();

     private int currentIndex = -1;

     //Enqueue: Adds (or stores) an element to the end of the queue..
     public List<T> enQueue(T value) {
          queue.add(1 + currentIndex++, value);
          return queue;
     }

     //Dequeue: Removal of elements from the queue.
     public List<T> deQueue() {
          if (isEmpty(true)) {
               return queue;
          } else {
               queue.remove(0);
               currentIndex--;
               return queue;
          }
     }

     //Peek or front: Acquires the data element available at the front node of the queue without deleting it.
     public Optional<T> getPeek() {
          if (isEmpty(true)) {
               return Optional.empty();
          } else {
               return Optional.of(queue.get(0));
          }
     }

     //Rear: This operation returns the element at the rear end without removing it.
     public Optional<T> getRear() {
          if (isEmpty(true)) {
               return Optional.empty();
          } else {
               return Optional.of(queue.get(currentIndex));
          }
     }

     public int getSizeOfQueue(Queue<T> queue) {
          return queue.queue.size();
     }

     public boolean isEmpty(boolean callingFromParent) {
          if (queue.isEmpty()) {
               if (!callingFromParent) System.out.println("The queue is empty\n");
               return true;
          } else {
               if (!callingFromParent) System.out.println("The queue is not empty\n");
               return false;
          }
     }

     private void printQueue() {
          System.out.printf("The new Stack is : %s\n", queue);
     }

     public List<T> enQueueAll(List<T> elements) {
          for (T element : elements) {
               enQueue(element);
          }
          return queue;
     }

}
