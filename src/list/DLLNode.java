package list;

public class DLLNode {
    public int data;
    public DLLNode previous;
    public DLLNode next;

    public DLLNode(int i) {
        data = i;
        previous = null;
        next = null;
    }

    public int length(DLLNode head) {
        int size = 0;
        while (head != null) {
            size ++;
            head = head.next;
        }
        return size;
    }

    @Override
    public String toString() {
        String s = " ";
        DLLNode temp = this;
        while (temp != null) {
            s = s + temp.data + " ";
            temp = temp.next;
        }
        return s;
    }



    public DLLNode insert(DLLNode head, DLLNode node, int position) {
        int size = length(head);
        if (position < 1 || position > size + 1) return head;
        if (position == 1) {
            node.next = head;
            head.previous = node;
            return node;
        } else {
            DLLNode prnode = head;
            for (int i = 0; i < position - 2; i++) {
                prnode = prnode.next;
            }
            node.next = prnode.next;
            node.previous = prnode;

            prnode.next = node;
            if (node.next != null) node.next.previous = node;
            return head;
        }

    }

    public DLLNode delete(DLLNode head, int position) {
        int size = length(head);
        if (position < 1 || position > size) return head;
        if (position == 1) {
            DLLNode temp = head;
            head = head.next;
            temp = null;
            return head;
        } else {
            DLLNode node = head;
            for (int i = 0; i < position - 1; i++) {
                node = node.next;
            }
            node.previous.next = node.next;
            if (node.next != null) node.next.previous = node.previous;
            node = null;
            return head;
        }
    }

    public static void main(String[] args) {
        DLLNode dllNode = new DLLNode(3);

        System.out.println(dllNode);
        dllNode = dllNode.insert(dllNode, new DLLNode(4) , 1);
        dllNode = dllNode.delete(dllNode, 2);
        System.out.println(dllNode);

    }
}
