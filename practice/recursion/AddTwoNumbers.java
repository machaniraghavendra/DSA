package practice.recursion;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
public class AddTwoNumbers {
     static class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
               this.val = val;
          }

          ListNode(int val, ListNode next) {
               this.val = val;
               this.next = next;
          }
     }

     public void print(ListNode listNode) {
          while (listNode != null) {
               System.out.println(listNode.val + ", ");
               listNode = listNode.next;
          }
     }

     ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          return addTwoNumbers(l1, l2, 0);
     }

     ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
          if (l1 == null && l2 == null && carry == 0) {
               return null;
          }
          int x = l1 == null ? 0 : l1.val;
          int y = l2 == null ? 0 : l2.val;
          int sum = x + y + carry;
          ListNode listNode = new ListNode(sum % 10);
          listNode.next = addTwoNumbers(l1 != null ? l1.next : null, l2 != null ? l2.next : null, sum / 10);
          return listNode;
     }

     public static void main(String[] args) {
          ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
          ListNode listNode1 = new ListNode(5, new ListNode(6, new ListNode(4)));
          AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
          addTwoNumbers.print(addTwoNumbers.addTwoNumbers(listNode, listNode1));
     }
}
