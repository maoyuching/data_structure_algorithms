package queue;

public class DynArrayQueue {
    private int front;
    private int back;
    private int countsize;
    private int[] arr;

    public DynArrayQueue() {
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
            int[] newArr = new int[2 * arr.length];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr = newArr;
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
        DynArrayQueue dynArrayQueue = new DynArrayQueue();
        for (int i = 0; i < 12; i++) {
            dynArrayQueue .enQueue(i);
        }

        while (!dynArrayQueue.isEmpty()) {
            int i = dynArrayQueue.deQueue();
            System.out.println(i);
        }

    }

}
