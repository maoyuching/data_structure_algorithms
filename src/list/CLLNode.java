package list;

public class CLLNode {
    public int data;
    public CLLNode next;

    public CLLNode(int i) {
        data = i;
        next = this;
    }

    public int length(CLLNode head) {
        if (head == null) return 0;
        int ans = 1;
        CLLNode currentnode = head.next;
        while (currentnode != head) {
            ans ++;
            currentnode = currentnode.next;
        }
        return ans;
    }

    public CLLNode insert(CLLNode head, CLLNode node, int position) {
        int size = length(head);
        if (position < 1 || position > size) return head;
        if (position == 1) {
            CLLNode lastnode = head;
            for (int i = 0; i < size - 1; i++) {
                lastnode = lastnode.next;
            }
            node.next = lastnode.next;
            lastnode.next = node;
            return node;
        } else {
            CLLNode prenode = head;
            for (int i = 0; i < position - 2; i++) {
                prenode = prenode.next;
            }
            node.next = prenode.next;
            prenode.next = node;
            return  head;
        }
    }

    public CLLNode delete(CLLNode head, int position) {
        int size = length(head);
        if (position < 1 || position > size) return head;
        if (position == 1) {
            CLLNode node = head;
            for (int i = 0; i < size - 1; i++) {
                node = node.next;
            }
            node.next = head.next;
            head = null;
            return node.next;
        } else {
            CLLNode prenode = head;
            for (int i = 0; i < position - 2; i++) {
                prenode = prenode.next;
            }
            CLLNode temp = prenode.next;
            prenode.next = prenode.next.next;
            temp = null;
            return head;
        }

    }

    @Override
    public String toString() {
        String s = " " + this.data;
        CLLNode temp = this.next;
        while (temp != this) {
            s += (temp.data + " ");
        }
        return s;
    }

    public static void main(String[] args) {
        CLLNode cllNode = new CLLNode(1);
        System.out.println(cllNode);

    }
}
