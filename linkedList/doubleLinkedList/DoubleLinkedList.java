package linkedList.doubleLinkedList;

import nonLinearDS.Node;

public class DoubleLinkedList {
     Node linkedList;

     public static void main(String[] args) {
          DoubleLinkedList list = new DoubleLinkedList();
          list.add(10);
          list.add(20);
          list.add(30);
          list.add(31);
          list.add(20);
          list.add(32);
          System.out.println(list.getLastNode().value);
          System.out.println(list.size());
          System.out.println(list);
          System.out.println(list.remove(30));
          System.out.println(list.size());
          System.out.println(list);
     }

     public int add(int value) {
          if (linkedList == null) {
               linkedList = new Node(value);
               return value;
          }
          Node newNode = new Node(value);
          Node lastNode = getLastNode();
          lastNode.right = newNode;
          newNode.left = lastNode;
          return value;
     }

     public Node getLastNode() {
          if (linkedList == null) return new Node(-1);
          Node lastNode = linkedList;
          while (lastNode.right != null) {
               lastNode = lastNode.right;
          }
          return lastNode;
     }

     public int size() {
          if (linkedList == null) return 0;
          int size = 0;
          Node list = linkedList;
          while (list != null) {
               list = list.right;
               size++;
          }
          return size;
     }

     public int remove(int value) {
          if (linkedList == null) return -1;
          boolean found = false;
          Node currentNode = linkedList;
          while (currentNode != null) {
               if (currentNode.value == value) {
                    //If only single node
                    if (currentNode.right == null && currentNode.left == null) {
                         linkedList = null;
                    }
                    // If tail node
                    else if (currentNode.right == null) {
                         currentNode.left.right = null;
                         currentNode.left = null;
                    }
                    //If head node
                    else if (currentNode.left == null) {
                         currentNode.right.left = null;
                         currentNode = currentNode.right;
                         linkedList = currentNode;
                    }
                    //If middle node
                    else {
                         currentNode.left.right = currentNode.right;
                         currentNode.right.left = currentNode.right.left.left;
                    }
                    found = true;
                    break;
               }
               currentNode = currentNode.right;
          }
          return found ? value : -1;
     }

     @Override
     public String toString() {
          StringBuilder value = new StringBuilder("[");
          DoubleLinkedList list = new DoubleLinkedList();
          list.linkedList = linkedList;
          while (list.linkedList != null) {
               value.append(list.linkedList.value).append(", ");
               list.linkedList = list.linkedList.right;
          }
          value.append("]");
          return value.toString();
     }
}
