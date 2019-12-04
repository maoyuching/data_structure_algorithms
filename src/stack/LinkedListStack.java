package stack;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class LinkedListStack {
    private LLNode top;
    public LinkedListStack() {
        top = null;
    }

    public int size() {
        if (top == null) return 0;
        LLNode l = top;
        int num = 1;
        while (l.getNext() != null) {
            num ++;
            l= l.getNext();
        }
        return num;
    }

    public boolean isEmpty() {
        if (top == null) return true;
        else             return false;
    }

    public void push(int i) {

        LLNode data = new LLNode(i);
        data.setNext(top);
        top = data;
    }

    public int pop() {
        if (isEmpty()) return -1;
        else {
            int data = top.getData();
            top = top.getNext();
            return data;
        }

    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        for (int i = 0; i < 10; i++) {
            linkedListStack.push(i);
        }
        System.out.println(linkedListStack.size());
        for (int i = 0; i < 10; i++) {
            linkedListStack.pop();
        }
    }
}

class LLNode {
    private int data;
    private LLNode next;

    public LLNode(Integer data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}
