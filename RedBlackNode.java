public class RedBlackNode<T> extends BinaryNode<T> {
  private boolean isRed;

  public RedBlackNode(T data, BinaryNode left, BinaryNode right) {
    super(data,left,right);
  }

  public RedBlackNode(T data) {
    super(data, null, null);

  }
  public RedBlackNode(){
    super();
    this.isRed = false;
  }

  public boolean isBlack() {
    return !isRed;
  }
  public boolean isRed(){
    return isRed;
  }
  public void swapColor() {
    this.isRed = !this.isRed;
  }
  public void setRed() {
    this.isRed = true;
  }
  public void setBlack() {
    this.isRed = false;
  }
  public RedBlackNode getLeft(){
    return (RedBlackNode<T>) super.getLeft();
  }
  public RedBlackNode getRight(){
    return (RedBlackNode<T>) super.getRight();
  }
}