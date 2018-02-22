import java.util.Iterator;
public class BinaryTree<T> implements BinaryTreeInterface<T> {
    BinaryNode<T> root;

    public void setTree(T rootData) {
        this.root = new BinaryNode<T>(rootData);
    }

    public void setTree(
            T rootData,
            BinaryTreeInterface<T> leftTree,
            BinaryTreeInterface<T> rightTree
    ) {
        privateSetTree(
                rootData,
                (BinaryTree<T>) leftTree,
                (BinaryTree<T>) rightTree
        );
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    private void privateSetTree(
            T rootData,
            BinaryTree<T> leftTree,
            BinaryTree<T> rightTree) {
        root = new BinaryNode<>(rootData);
        if (leftTree != null) {
            root.setLeft(leftTree.getRoot());
        }
        if (rightTree != null) {
            root.setRight(rightTree.getRoot());
        }
    }

    /*Traversal*/
    public void preorderTraverse() {
        preorderTraverse(this.root);
    }

    public void preorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            System.out.print(node.getData()+ " ");
            preorderTraverse(node.getLeft());
            preorderTraverse(node.getRight());
        }
    }

    public void inorderTraverse() {
        inorderTraverse(this.root);
    }

    public void inorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            inorderTraverse(node.getLeft());
            System.out.print(node.getData()+ " ");
            inorderTraverse(node.getRight());
        }
    }

    public void postorderTraverse() {
        postorderTraverse(this.root);
    }

    public void postorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            postorderTraverse(node.getLeft());
            postorderTraverse(node.getRight());
            System.out.print(node.getData()+ " ");
        }
    }
    /*Iterators*/
    public Iterator<T> getPreorderIterator(){
        return null;
    }
    public Iterator<T> getPostorderIterator(){
        return null;
    }
    public Iterator<T> getInorderIterator(){
        return null;
    }
    public Iterator<T> getLevelOrderIterator(){
        return null;
    }

    public T getRootData() {
        return (T) root.getData();
    }

    public int getHeight() {
        return root.getHeight();
    }

    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

}