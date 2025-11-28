package nonLinearDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {
     Node tree;

     public static void main(String[] args) {
          BST bst = new BST();
          bst.tree = bst.insertInBST(bst.tree, 10);
          bst.tree = bst.insertInBST(bst.tree, 5);
          bst.tree = bst.insertInBST(bst.tree, 20);
          bst.tree = bst.insertInBST(bst.tree, 3);
          bst.tree = bst.insertInBST(bst.tree, 25);
          bst.tree = bst.insertInBST(bst.tree, 21);
          bst.tree = bst.insertInBST(bst.tree, 7);
          List<Integer> preOrder = new ArrayList<>();
          System.out.print("Pre order : ");
          bst.preOrder(bst.tree, preOrder);
          System.out.println(preOrder);
          List<Integer> postOrder = new ArrayList<>();
          System.out.print("Post order : ");
          bst.postOrder(bst.tree, postOrder);
          System.out.println(postOrder);
          List<Integer> inOrder = new ArrayList<>();
          System.out.print("In order : ");
          bst.inOrder(bst.tree, inOrder);
          System.out.println(inOrder);
          System.out.print("Number of nodes : ");
          System.out.println(bst.calculateNumberOfNodes(bst.tree));
          System.out.print("Height of tree : ");
          System.out.println(bst.heightOfTree(bst.tree));
          System.out.print("Level order traversal : ");
          bst.levelOrderTraversal(bst.tree);
          System.out.print("Count of leaf nodes : ");
          System.out.println(bst.countLeafNodes(bst.tree));
          System.out.print("Sum of leaf nodes : ");
          System.out.println(bst.sumOfAllNodes(bst.tree));
          System.out.print("Search in tree : ");
          var foundNode = bst.search(bst.tree, 21);
          if (foundNode != null) {
               System.out.println("Value : " + foundNode.value + ", Left : " +
                    (foundNode.left == null ? null : foundNode.left.value) + ", Right : " +
                    (foundNode.right == null ? null : foundNode.right.value));
          }
          bst.deleteNode(bst.tree, 5);
          System.out.println("After deletion : "+ 5);
          System.out.print("In order : ");
          inOrder = new ArrayList<>();
          bst.inOrder(bst.tree, inOrder);
          System.out.println(inOrder);
     }

     Node findMin(Node node) {
          while (node.left != null)
               node = node.left;
          return node;
     }

     public Node insertInBST(Node root, int value) {
          if (root == null) {
               return new Node(value);
          }
          if (root.value > value) {
               root.left = insertInBST(root.left, value);
          } else if (root.value < value) {
               root.right = insertInBST(root.right, value);
          }
          return root;
     }

     public void preOrder(Node tree, List<Integer> list) {
          if (tree == null) {
               return;
          }
          list.add(tree.value);
          preOrder(tree.left, list);
          preOrder(tree.right, list);
     }

     public void postOrder(Node tree, List<Integer> list) {
          if (tree == null) {
               return;
          }
          postOrder(tree.left, list);
          postOrder(tree.right, list);
          list.add(tree.value);
     }

     public void inOrder(Node tree, List<Integer> list) {
          if (tree == null) {
               return;
          }
          postOrder(tree.left, list);
          list.add(tree.value);
          postOrder(tree.right, list);
     }

     public Integer calculateNumberOfNodes(Node tree) {
          if (tree == null) {
               return 0;
          }
          return 1 + calculateNumberOfNodes(tree.left) + calculateNumberOfNodes(tree.right);
     }

     public int heightOfTree(Node tree) {
          if (tree == null) {
               return 0;
          }
          int leftHeight = heightOfTree(tree.left);
          int rightHeight = heightOfTree(tree.right);
          return 1 + Math.max(leftHeight, rightHeight);
     }

     public void levelOrderTraversal(Node tree) {
          if (tree == null) return;
          Queue<Node> nodes = new LinkedList<>();
          nodes.add(tree);
          while (!nodes.isEmpty()) {
               Node currentNode = nodes.poll();
               System.out.print(currentNode.value + " ,");
               if (currentNode.left != null) nodes.add(currentNode.left);
               if (currentNode.right != null) nodes.add(currentNode.right);
          }
          System.out.println();
     }

     public int countLeafNodes(Node tree) {
          if (tree == null) return -1;
          if (tree.left == null && tree.right == null) {
               System.out.println("Leaf nodes : " + tree.value);
               return 0;
          }
          return 1 + countLeafNodes(tree.left) + countLeafNodes(tree.right);
     }

     public int sumOfAllNodes(Node tree) {
          if (tree == null) return 0;
          return tree.value + sumOfAllNodes(tree.left) + sumOfAllNodes(tree.right);
     }

     public Node search(Node tree, int value) {
          if (tree == null) return null;
          Node currentNode = tree;
          while (currentNode != null) {
               if (currentNode.value == value) {
                    return currentNode;
               }
               if (currentNode.value < value) {
                    currentNode = currentNode.right;
               } else {
                    currentNode = currentNode.left;
               }
          }
          return null;
     }

     public Node deleteNode(Node tree, int value) {
          if (tree == null)
               return null;
          if (value < tree.value) {
               tree.left = deleteNode(tree.left, value);
          } else if (value > tree.value) {
               tree.right = deleteNode(tree.right, value);
          } else {
               // Case 1: No child
               if (tree.left == null && tree.right == null)
                    return null;
               // Case 2: One child
               else if (tree.left == null)
                    return tree.right;
               else if (tree.right == null)
                    return tree.left;
               // Case 3: Two children
               Node successor = findMin(tree.right);
               tree.value = successor.value;
               tree.right = deleteNode(tree.right, successor.value);
          }
          return tree;
     }
}
