package queue;

import com.sun.prism.impl.paint.PaintUtil;
import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

public class LinkedListQueue {

    private LLNode front;
    private LLNode back;

    public LinkedListQueue (){
        front = null;
        back = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            System.out.println("is empty no front");
            throw new Exception("queue empty");
        }
        return front.data;
    }

    public void enQueue(int i) {
        if (isEmpty()) {
            LLNode llNode = new LLNode(i);
            front = llNode;
            back = llNode;
        } else {
            LLNode llNode = new LLNode(i);
            back.next = llNode;
            back = back.next;
        }

    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("is empty!");
            return -1;
        } else {
            int d = front.data;
            if (front == back) {
                front = null;
            } else {
                front = front.next;
            }

            return d;
        }
    }

    public static void main(String[] args)  {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enQueue(i);

        }

        try {
            for (int i = 0; i < 12; i++) {
                System.out.println(linkedListQueue.front());
                linkedListQueue.deQueue();
            }

        } catch (Exception ex) {
            System.out.println("exception");
        }

    }

}


class LLNode{
    public int data;
    public LLNode next;

    public LLNode(int d) {
        this.data = d;
    }
}
