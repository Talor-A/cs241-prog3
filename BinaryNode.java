public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    /*Constructors*/
    public BinaryNode(T data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode() {
        this(null, null, null);
    }

    /*Getters*/
    public T getData() {
        return this.data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    /*Setters*/
    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    /*Helpers*/
    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getNumberOfNodes() {
        int total = 1;
        if (hasLeft())
            total += left.getNumberOfNodes();
        if (hasRight())
            total += right.getNumberOfNodes();
        return total;
    }

    public int getHeight() {
        return getHeight(this);
    }

    public int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null) {
            height = 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        }
        return height;
    }

    public BinaryNode<T> copy() {
        BinaryNode<T> newNode = new BinaryNode<T>(this.getData(), this.getLeft(), this.getRight());
        return newNode;
    }

}