package tree;

public class AvlTreeNode {
    public  int data;
    public AvlTreeNode left;
    public AvlTreeNode right;
    public int height;

    public AvlTreeNode(int data) {
        data = data;
    }

    public static int height(AvlTreeNode root) {
        if (root == null) return -1;
        else return root.height;
    }

    public static AvlTreeNode L(AvlTreeNode root) {
        if (root == null) return null;
        AvlTreeNode newroot = root.left;
        root.left = newroot.right;
        newroot.right = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        newroot.height = Math.max(height(newroot.left), height(newroot.right)) + 1;
        return newroot;
    }

    public static AvlTreeNode R(AvlTreeNode root) {
        if (root == null) return  null;
        AvlTreeNode newroot = root.right;
        newroot.right = root.left;
        root.left = newroot;
        root.height = Math.max(height(root.right), height(root.left)) + 1;
        newroot.height = Math.max(height(root.right), height(root.left))+ 1;
        return newroot;
    }

    public static AvlTreeNode LR(AvlTreeNode root) {
        root.right = L(root.right);
        return R(root);
    }

    public static AvlTreeNode RL(AvlTreeNode root) {
        root.left = R(root.left);
        return L(root);
    }



}
