package hash;

public class MyHashTable {

    int countsize;
    int[] array;

    private int myhash(int i) {
        return i % array.length;
    }

    private int myhash2(int i) {
        return 3 - (i % 3);
    }

    public MyHashTable(int size) {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        countsize = 0;
    }

    public void insert(int i) {
        int position = myhash(i);
        for (int j = 0; j < array.length; j++) {
            if (array[position] == -1) {
                array[position] = i;
                return;
            } else {
                position = (position + 1) % array.length;
            }
        }
    }

    public boolean contains(int i) {
        int position = myhash(i);

        for (int j = 0; j < array.length; j++) {
            if (array[position] == i) return true;
            else position = (position + 1) % array.length;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = " ";
        for (int i : array) s= s+ i + " ";
        return s;
    }

    public static void main(String[] args) {

        MyHashTable myHashTable = new MyHashTable(6);
        System.out.println(myHashTable);
        myHashTable.insert(1);
        myHashTable.insert(5);
        myHashTable.insert(7);
        myHashTable.insert(13);
        System.out.println(myHashTable);

    }
}
