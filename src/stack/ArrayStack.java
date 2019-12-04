package stack;

public class ArrayStack {
    private int top;
    private int[] arr;

    public ArrayStack(int i) {
        top = -1;
        arr = new int[i];
    }
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == arr.length - 1;
    }
    public int size() {
        return top+1;
    }

    public void push(int i) {
        if (isStackFull()) {
            System.out.println("stack overflow");
        } else {
            top++;
            arr[top] = i;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return 0;
        } else {
            return arr[top--];
        }
    }

    public void clear() {
        top = -1;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
    }
}
