package stack;

public class DynArrayStack {

    int[] array;
    int top;

    public DynArrayStack() {
        array = new int[3];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == array.length -1 ;
    }

    public int size() {
        return top;
    }

    public int top() {
        return array[top];
    }

    public void clear() {
        top = -1;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            return array[top--];
        }
    }

    public void push(int i) {
        if (isStackFull()) {
            int[] newArray = new int[2 * array.length];
            System.arraycopy(array, 0,
                    newArray, 0,
                    array.length);
            System.out.println("stackoverflow so double the array");
            array = newArray;
        }
        array[++top] = i;

    }


    public static void main(String[] args) {
        DynArrayStack dynArrayStack = new DynArrayStack();
        for (int i = 0; i < 10; i++) {
            dynArrayStack.push(1);
        }

        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
