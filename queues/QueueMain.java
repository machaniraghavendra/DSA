package queues;

import java.util.List;

public class QueueMain {

     public static void main(String... args){
          Queue<Integer> queue = new Queue<>();
          final String CALLING_DEQUEUE = "Calling for to dequeue the element";

          System.out.println(queue.enQueue(10));
          System.out.println(queue.enQueue(11));

          System.out.println(CALLING_DEQUEUE);
          System.out.println(queue.deQueue());

          System.out.println(queue.enQueue(15));
          System.out.println(queue.enQueue(18));

          System.out.println(CALLING_DEQUEUE);
          System.out.println(queue.deQueue());

          System.out.println(queue.enQueue(20));

          System.out.println(CALLING_DEQUEUE);
          System.out.println(queue.deQueue());

          System.out.println(CALLING_DEQUEUE);
          System.out.println(queue.deQueue());

          System.out.println(queue.getPeek().orElse(-1));
          System.out.println(queue.getRear().orElse(-1));

          queue.isEmpty(false);

          System.out.println(queue.enQueueAll(List.of(12,3,6,8)));

          System.out.println(queue.getSizeOfQueue(queue));
     }

}
