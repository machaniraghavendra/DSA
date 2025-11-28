package linkedList.singleLinkedList;

public class LinkedListMain {

     public static void main(String[] args) {
          LinkedList<Integer> linkedList = new LinkedList<>();
          linkedList.add(1);
          linkedList.add(2);
          linkedList.add(3);
          linkedList.add(4);
          linkedList.add(5);
//          {1,2,3,6,4,5}
          linkedList.add(3,6);
          System.out.println(linkedList.getList());
//          System.out.println(linkedList.getSize());
          linkedList.removeTail();
          System.out.println(linkedList.getList());

          linkedList.removeElementByIndex(5);
          System.out.println(linkedList.getList());
     }
}
