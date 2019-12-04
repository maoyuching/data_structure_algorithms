package tree;

import org.omg.CORBA.Any;

public class AvlNode<AnyType extends Comparable>{
    public AnyType element;
    public AvlNode<AnyType> left;
    public AvlNode<AnyType> right;
    public int height;

    /*
    构造方法
     */
    public AvlNode(AnyType theElement, AvlNode<AnyType> left, AvlNode<AnyType> right) {
        element = theElement;
        left = left;
        right = right;
        height = 0;
    }
    public AvlNode(AnyType theElement) {
        this(theElement, null, null);
    }



    public int height(AvlNode<AnyType> t) {
        return t == null? -1: t.height;
    }

    /*
    左旋转 左边长过右边
     */
    public AvlNode<AnyType> rotaeWithLeftChild(AvlNode<AnyType> k2){
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /*
    右旋转 右边太长
     */
    public AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }

    public AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotaeWithLeftChild(k3);
    }

    public AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
        k3.right = rotaeWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }


    static final int ALLOWED_IMBALANCE = 1;
    public AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right))
                t = rotaeWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) > height(t.right.left)) {
                t = rotateWithRightChild(t);
            }else
                t = doubleWithRightChild(t);
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null)
            return new AvlNode<>(x, null, null);

        if (x.compareTo(t.element) < 0)
            t.left = insert(x, t.left);
        if (x.compareTo(t.element) > 0)
            t.right = insert(x, t.right);
        return balance(t);
    }

    public AvlNode<AnyType> findMin(AvlNode<AnyType> root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return findMin(root.left);
    }
    public AvlNode<AnyType> remove(AnyType x, AvlNode<AnyType> t) {
        if (t == null) return t;

        if (x.compareTo(t.element) < 0) {
            t.left = remove(x, t.left);
        }
        else if (x.compareTo(t.element) > 0){
            t.right = remove(x, t.right);
        }
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null)? t.left:t.right;
        }
        return balance(t);
    }



}
