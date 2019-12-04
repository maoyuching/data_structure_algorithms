package list;

import javax.security.sasl.SaslServer;
import java.util.List;

public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public static int length(ListNode node) {
        int len = 0;
        ListNode head = node;
        while (head != null) {
            len ++;
            head = head.getNext();
        }
        return len;
    }

    public ListNode insert(ListNode head, ListNode insertnode, int position) {
        if (head == null) return head;
        if (position > length(head) + 1 || position < 0) return head;

        if (position == 1) {
            insertnode.setNext(head);
            return insertnode;
        } else {
            ListNode node = head;
            for (int i = 0; i < position - 2; i++) {
                node = node.getNext();
            }
            insertnode.setNext(node.getNext());
            node.setNext(insertnode);
            return head;
        }
    }

    public void delete(ListNode head, int position) {
        int size = length(head);
        if (position < 1 || position > size) return;

        if (position == 1) {
            ListNode temp = head;
            head = head.getNext();
            temp = null;
        } else {
            ListNode temp = head;
            for (int i = 0; i < position - 2; i++) {
                temp = temp.getNext();
            }
            ListNode deleteNode = temp.getNext();
            temp.setNext(deleteNode.getNext());
            deleteNode = null;

        }
    }

    public  static ListNode clear(ListNode head) {
        ListNode temp = head;
        while (head != null) {
            head = head.getNext();
            temp = null;
            temp = head;
        }
        return head;
    }


    @Override
    public String toString() {
        String s = " ";
        ListNode node = this;
        while (node != null) {
            s += (node.getData() + " ");
            node =node.getNext();
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.insert(listNode, new ListNode(6), 2);
        listNode = ListNode.clear(listNode);
        System.out.println(listNode);
    }
}
