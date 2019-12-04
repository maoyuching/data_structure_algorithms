package tree;

public class BinarySearchTreeNode {
    public int data;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;

    public BinarySearchTreeNode(int i) {
        data = i;
        left = null;
        right = null;
    }

    public static void InOrder(BinarySearchTreeNode root) {
        if (root == null) return;
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }
    public static BinarySearchTreeNode Find(BinarySearchTreeNode root, int data) {
        if (root == null) return null;
        if (data < root.data) {
            return Find(root.left, data);
        }
        if (data > root.data) {
            return Find(root.right, data);
        }
        return root;
    }

    public static BinarySearchTreeNode FindNoRecursive(BinarySearchTreeNode root, int data) {
        if (root == null) return null;
        while (root != null) {
            if (data == root.data) return root;
            if (data < root.data) root=root.left;
            if (data > root.data) root=root.right;
        }
        return null;
    }

    public static BinarySearchTreeNode FindMin(BinarySearchTreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return FindMin(root.left);
    }

    /*非递归版本*/
    public static BinarySearchTreeNode FindMinNoRecursive(BinarySearchTreeNode root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static BinarySearchTreeNode FindMax(BinarySearchTreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root;
        return FindMax(root.right);
    }

    /*非递归版本*/
    public static BinarySearchTreeNode FindMaxNoRecursive(BinarySearchTreeNode root) {
        if (root == null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void Insert(BinarySearchTreeNode root, int data) {
        if (root == null) {
            root = new BinarySearchTreeNode(data);
            return ;
        }
        if (root.data == data) return;
        if (data < root.data) {
            if (root.left == null){
                root.left = new BinarySearchTreeNode(data);
            }
            Insert(root.left, data);
        }
        if (data > root.data) {
            if (root.right == null) root.right = new BinarySearchTreeNode(data);
            Insert(root.right, data);
        }
    }

    public static BinarySearchTreeNode Delete(BinarySearchTreeNode root, int data) {
        if (root == null) return null;
        else if (data < root.data) root.left = Delete(root.left, data);
        else if (data > root.data) root.right = Delete(root.right, data);
        else {
            if (root.left != null && root.right != null) {
                BinarySearchTreeNode temp = FindMax(root.left);
                root.data = temp.data;
                root.left = Delete(root.left, root.data);
            } else{
                if (root.left != null) {
                    root = root.left;
                }
                if (root.right != null) {
                    root = root.right;
                }
            }
        }
        return root;

    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = new BinarySearchTreeNode(10);
        root.left = new BinarySearchTreeNode(6);
        root.right = new BinarySearchTreeNode(16);
        root.left.left = new BinarySearchTreeNode(4);
        root.left.right = new BinarySearchTreeNode(9);
        root.left.right.left = new BinarySearchTreeNode(7);
        root.right.left = new BinarySearchTreeNode(14);


        InOrder(root);
        Delete(root, 14);
        InOrder(root);



    }
}
