package tree;

import queue.ArrayQueue;
import stack.ArrayStack;
import sun.misc.Queue;

import java.util.Stack;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int i) {
        left = null;
        right = null;
        data = i;
    }

    public static void PreOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(" "+ root.data+" ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public static void InOrder(BinaryTreeNode root) {
        if (root == null) return;
        InOrder(root.left);
        System.out.println(root.data);
        InOrder(root.right);
    }

    public static void LevelOrder(BinaryTreeNode root) throws InterruptedException {
        if (root == null) return;
        Queue<BinaryTreeNode> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.dequeue();
            System.out.println(temp.data);
            if (temp.left != null) queue.enqueue(temp.left);
            if (temp.right != null) queue.enqueue(temp.right);
        }

    }

    public static void PreOrderNonRecursive(BinaryTreeNode node) {
        if (node == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            node = node.right;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        LevelOrder(root);


    }
}
