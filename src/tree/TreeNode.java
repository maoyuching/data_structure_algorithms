package tree;

public class TreeNode {
    public int data;
    public TreeNode firstChild;
    public TreeNode nextSibling;
    //sibling 兄弟 同级

    public TreeNode(int i) {
        data = i;
        firstChild = null;
        nextSibling = null;

    }
}
