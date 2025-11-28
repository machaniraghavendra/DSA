package linkedList.singleLinkedList;

import java.util.ArrayList;
import java.util.List;

//add(int index, E element)	This method Inserts the specified element at the specified position in this list.
//add(E e)	This method Appends the specified element to the end of this list.
//addAll(int index, Collection<E> c)	This method Inserts all of the elements in the specified collection into this list, starting at the specified position.
//addAll(Collection<E> c)	This method Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection’s iterator.
//addFirst(E e)	This method Inserts the specified element at the beginning of this list.
//addLast(E e)	This method Appends the specified element to the end of this list.
//clear()	This method removes all of the elements from this list.
//clone()	This method returns a shallow copy of this LinkedList.
//contains(Object o)	This method returns true if this list contains the specified element.
//descendingIterator()	This method returns an iterator over the elements in this deque in reverse sequential order.
//element()	This method retrieves but does not remove, the head (first element) of this list.
//get(int index)	This method returns the element at the specified position in this list.
//getFirst()	This method returns the first element in this list.
//getLast()	This method returns the last element in this list.
//indexOf(Object o)	This method returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
//lastIndexOf(Object o)	This method returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
//listIterator(int index)	This method returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list.
//offer(E e)	This method Adds the specified element as the tail (last element) of this list.
//offerFirst(E e)	This method Inserts the specified element at the front of this list.
//offerLast(E e)	This method Inserts the specified element at the end of this list.
//peek()	This method retrieves but does not remove, the head (first element) of this list.
//peekFirst()	This method retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
//peekLast()	This method retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
//poll()	This method retrieves and removes the head (first element) of this list.
//pollFirst()	This method retrieves and removes the first element of this list, or returns null if this list is empty.
//pollLast()	This method retrieves and removes the last element of this list, or returns null if this list is empty.
//pop()	This method Pops an element from the stack represented by this list.
//push(E e)	This method pushes an element onto the stack represented by this list.
//remove()	This method retrieves and removes the head (first element) of this list.
//remove(int index)	This method removes the element at the specified position in this list.
//remove(Object o)	This method removes the first occurrence of the specified element from this list if it is present.
//removeFirst()	This method removes and returns the first element from this list.
//removeFirstOccurrence(Object o)	This method removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
//removeLast()	This method removes and returns the last element from this list.
//removeLastOccurrence(Object o)	This method removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
//set(int index, E element)	This method replaces the element at the specified position in this list with the specified element.
//size()	This method returns the number of elements in this list.
//spliterator()	This method creates a late-binding and fail-fast Spliterator over the elements in this list.
//toArray()	This method returns an array containing all of the elements in this list in proper sequence (from first to last element).
//toArray(T[] a)	This method returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
//toString()	This method returns a string containing all of the elements in this list in proper sequence (from first to the last element), each element is separated by commas and the String is enclosed in square brackets.
public class LinkedList<T> {

     private Node<T> head;

     //add(int index, E element)	This method Inserts the specified element at the specified position in this list.
//     public void add(int index, T value) {
//          Node<T> newNode = new Node<>(value);
//          if (head == null) head = newNode;
//          else {
//               Node<T> currentNode = head;
//               index = index - getSize();
//               while (index >= 0) {
//                    if (currentNode.next == null) {
//                         currentNode.next = new Node<>(null);
//                    } else {
//                         currentNode = currentNode.next;
//                    }
//                    index--;
//               }
//               currentNode.next = newNode;
//          }
//     }
     public void add(int index, T value) {
          if (index < 0) throw new IndexOutOfBoundsException("Index cannot be negative.");
          Node<T> newNode = new Node<>(value);
          // If adding at the head (index 0)
          if (index == 0) {
               newNode.next = head;
               head = newNode;
               return;
          }

          // Traverse to the node just before the specified index
          Node<T> current = head;
          int currentIndex = 0;

          while (current != null && currentIndex < index - 1) {
               current = current.next;
               currentIndex++;
          }

          // Check if index is out of bounds
          if (current == null) {
               throw new IndexOutOfBoundsException("Index out of bounds.");
          }

          // Insert the new node at the specified index
          newNode.next = current.next;
          current.next = newNode;
     }

     //add(E e)	This method Appends the specified element to the end of this list.
     public void add(T value) {
          Node<T> newNode = new Node<>(value);
          if (head == null) head = newNode;
          else {
               Node<T> currentNode = head;
               while (currentNode.next != null) {
                    currentNode = currentNode.next;
               }
               currentNode.next = newNode;
          }
     }

     public List<T> getList() {
          List<T> list = new ArrayList<>();
          Node<T> current = head;
          while (current != null) {
               list.add(current.value);
               current = current.next;
          }
          return list;
     }

     public int getSize() {
          return getList().size();
     }

     public Node<T> removeTail() {
          if (head == null || head.next == null) return null;
          Node<T> nodeNextToTail = head;
          while (nodeNextToTail.next.next != null) {
               nodeNextToTail = nodeNextToTail.next;
          }
          nodeNextToTail.next = null;
          return head;
     }

     public Node<T> removeElementByIndex(int index) {
          if (head == null || head.size() < index) return head;
          if (index == 1) {
               head = null;
               return null;
          }
          if (index == head.size()) {
               return removeTail();
          } else {
               int count = 0;
               Node<T> prev = null;
               Node<T> currentNode = head;
               while (currentNode.next != null) {
                    count++;
                    if (count == index) {
                         prev.next = prev.next.next;
                         break;
                    }
                    prev = currentNode;
                    currentNode = currentNode.next;
               }
          }
          return head;
     }
}

