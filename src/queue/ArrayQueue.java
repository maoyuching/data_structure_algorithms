package queue;

import javax.swing.plaf.PanelUI;

public class ArrayQueue {

    private int front;
    private int back;
    private int countsize;
    private int[] arr;

    public ArrayQueue() {
        front = 0;
        back = -1;
        countsize = 0;
        arr = new int[10];
    }

    public boolean isEmpty() {
        return countsize == 0;
    }

    public boolean isFull() {
        return countsize == arr.length;
    }

    public void enQueue(int i) {
        if (isFull()) {
            System.out.println("is full!");
            return;
        } else {
            back = (back + 1) % (arr.length);
            arr[back] = i;
            countsize++;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println(" is empty");
            return -1;
        } else {
            int data = arr[front];
            front = (front+1) % arr.length;
            countsize--;
            return data;
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i < 12; i++) {
            arrayQueue.enQueue(i);
        }

        while (!arrayQueue.isEmpty()) {
            int i = arrayQueue.deQueue();
            System.out.println(i);
        }

    }


}
