package linkedList.singleLinkedList;

public class Node<T> {
     T value;
     Node<T> next;

     public Node(T value) {
          this.value = value;
          this.next = null;
     }

     public int size() {
          int size = 1;
          Node<T> head = next;
          while (head != null) {
               head = head.next;
               size++;
          }
          return size;
     }
}
