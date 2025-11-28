package arrays;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ReverseQueue {
     public static void main(String[] args) {
          Queue<Integer> queue = new LinkedList<>(List.of(1, 2, 3, 4, 5));
          reverseQueue(queue);
          System.out.println(queue);
     }

     private static void reverseQueue(Queue<Integer> queue) {
          int n = queue.size();
          Deque<Integer> queue1 = new ConcurrentLinkedDeque<>();
          for (int i = 0; i < n; i++) {
               queue1.addFirst(queue.poll());
          }
          queue1.forEach(element -> queue.offer(queue1.pollFirst()));
     }
}
