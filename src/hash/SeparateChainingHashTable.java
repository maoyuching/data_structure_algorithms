package hash;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<T> {
    private List<T> [] theLists;
    private int currentSize;

    private int myhash(T t) {
        return t.hashCode() % theLists.length;
    }

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[size];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        currentSize = 0;
    }

    public SeparateChainingHashTable() {
        this(10);
    }

    /*
    是否存在某个元素
     */
    public boolean contains(T t) {
        //Linked list has contains funciton
        return theLists[myhash(t)].contains(t);
    }

    /*
    insert an element
     */
    public void insert(T t) {
        if (currentSize >= theLists.length){
            System.out.println(" is full");
            return;
        }
        if (!theLists[myhash(t)].contains(t)) {
            theLists[myhash(t)].add(t);
            currentSize++;
        }
    }

    /*
    remove an element
     */
    public void remove(T t) {
        if (theLists[myhash(t)].contains(t)) {
            theLists[myhash(t)].remove(t);
            currentSize--;
        } else {
            System.out.println(" not exit");
        }
    }


    /*
    clear the theLists
     */
    public void clear() {
        for (List<T> t : theLists) t.clear();
        currentSize = 0;
    }

    public static void main(String[] args) {
        SeparateChainingHashTable<Integer> hashTable = new SeparateChainingHashTable();
        hashTable.insert(5);
        System.out.println(hashTable.contains(5));
    }



}
