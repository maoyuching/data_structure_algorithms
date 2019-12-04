package heap;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class MinBinaryHeap {
    int[] array;       //array for storage
    int countSize;


    public MinBinaryHeap(int size) {
        array = new int[size];
        array[0] = Integer.MIN_VALUE;
        array[array.length-1] = Integer.MAX_VALUE;
        countSize = 0;
    }

    public MinBinaryHeap(int[] A) {
        this(A.length + 2);
        for (int i : A) {
            this.insert(i);
        }

    }
    @Override
    public String toString() {
        String s = " ";
        for (int i = 1; i <= countSize; i++)
            s += array[i] + " ";
        return s + "\n";
    }

    public void swap(int a, int b) {
        if (a <= countSize && b <= countSize) return;
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public int leftChild(int parent) {
        return parent * 2 > countSize ? array.length-1 : parent*2 ;
    }

    public int rightChild(int parent) {
        return parent * 2 + 1 > countSize? array.length-1 : parent * 2 +1;
    }

    public int parent(int child) {
        return child / 2;
    }

    public void insert(int i) {
        if (countSize + 2 == array.length) {
            //因为0放最小 -1 放最大 所以总大小比length小2
            System.out.println("is full");
        } else {
            array[++countSize] = i;
            int hole = countSize;
            while (array[hole] < array[parent(hole)]) {
                int temp = array[hole];
                array[hole] = array[parent(hole)];
                array[parent(hole)] = temp;
                hole = parent(hole);
            }
        }
    }

    public void delete() {
        if (countSize == 0) {
            System.out.println(" is empty");
        } else {
            array[1] = array[countSize];
            countSize--;
            int hole = 1;
            int minChildPosition = array[leftChild(hole)] < array[rightChild(hole)] ? leftChild(hole):rightChild(hole);
            while (array[hole] > array[minChildPosition]) {
                int temp = array[hole];
                array[hole] = array[minChildPosition];
                array[minChildPosition] = temp;
                hole = minChildPosition;
            }
        }
    }


    public static void main(String[] args) {
        MinBinaryHeap minBinaryHeap = new MinBinaryHeap(10);

        int[] a = {4,6,7,9,22,8,5};
        minBinaryHeap = new MinBinaryHeap(a);

        for (int i : a) {
            System.out.println(minBinaryHeap);
            minBinaryHeap.delete();
        }
    }

}

