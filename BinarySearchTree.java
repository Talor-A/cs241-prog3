import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {

  public BinarySearchTree() {
    super();
  }

  public BinarySearchTree(T rootData) {
    super();
    this.root = new BinaryNode<T>(rootData);
  }

  public void setTree(T rootData) {
    throw new UnsupportedOperationException();
  }

  public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
    throw new UnsupportedOperationException();
  }

  public boolean contains(T entry) {
    return findEntry(getRoot(), entry) != null;
  }

  public T getEntry(T entry) {
    return findEntry(getRoot(), entry);
  }

  private T findEntry(BinaryNode<T> rootNode, T entry) {
    if (rootNode == null)
      return null;

    T result = null;

    T rootEntry = rootNode.getData();

    if (entry.equals(rootEntry)) {
      result = rootEntry;
    } else if (entry.compareTo(rootEntry) < 0) {
      result = findEntry((BinaryNode<T>) rootNode.getLeft(), entry);
    } else {
      result = findEntry((BinaryNode<T>) rootNode.getRight(), entry);

    }

    return result;
  }

  public T add(T newEntry) {
    T result = null;
    if (isEmpty()) {
      this.root = new BinaryNode<T>(newEntry);
    } else {
      result = addEntry(super.getRoot(), newEntry);
    }
    return result;
  }

  private T addEntry(BinaryNode<T> rootNode, T newEntry) {
    assert rootNode != null;
    T result = null;
    T rootData = rootNode.getData();
    if (newEntry.equals(rootData)) {
      result = rootData;
      rootNode.setData(newEntry);
    } else if (newEntry.compareTo(rootData) < 0) {
      if (rootNode.hasLeft()) {
        result = addEntry((BinaryNode<T>) rootNode.getLeft(), newEntry);
      } else {
        rootNode.setLeft(new BinaryNode<T>(newEntry));
      }
    } else {
      if (rootNode.hasRight()) {
        result = addEntry((BinaryNode<T>) rootNode.getRight(), newEntry);
      } else {
        rootNode.setRight(new BinaryNode<T>(newEntry));
      }
    }
    return result;
  }

  public T remove(T entry) {
    return isEmpty() ? null : remove(this.root, entry);
  }

  private T remove(BinaryNode<T> rootNode, T entry) {
    T result = null;

    NodePair pair = findNode(entry);

    BinaryNode<T> parent = pair.getParent();
    BinaryNode<T> child = pair.getChild();
    if (child != null) {
      result = child.getData();
      if (child.hasLeft() && child.hasRight()) {
        pair = getNodeToRemove(child);
        BinaryNode<T> nodeToRemove = pair.getChild();
        parent = pair.getParent();
        child.setData(nodeToRemove.getData());
        child = nodeToRemove;
      }
      removeNode(child, parent);
    }

    return result;
  }

  private NodePair getNodeToRemove(BinaryNode<T> current) {
    BinaryNode<T> child = current.getLeft();
    BinaryNode<T> parent = current;

    return getRightmostChild(new NodePair(parent, child));
  }

  private NodePair getRightmostChild(NodePair pair) {
    BinaryNode<T> child = pair.getChild();
    return child.hasRight() ? new NodePair(child, child.getRight()) : pair;
  }

  private NodePair findNode(T entry) {
    return findNode(entry, new NodePair(null, this.root));
  }

  private NodePair findNode(T entry, NodePair pair) {
    BinaryNode<T> parent = null;
    BinaryNode<T> child = this.root;
    if (entry.equals(child.getData())) {
      return new NodePair(parent, child);
    } else if (entry.compareTo(child.getData()) < 0) {
      return findNode(entry, new NodePair(child, child.getLeft()));
    } else {
      return findNode(entry, new NodePair(child, child.getRight()));
    }

  }

  private void removeNode(BinaryNode<T> nodeToRemove, BinaryNode<T> parent) {
    BinaryNode<T> child;
    if (nodeToRemove.hasLeft()) {
      child = nodeToRemove.getLeft();
    } else {
      child = nodeToRemove.getRight();
    }
    if (nodeToRemove == getRoot()) {
      this.root = child;
    } else if (parent.getLeft() == nodeToRemove) {
      parent.setLeft(child);
    } else {
      parent.setRight(child);
    }
  }

  class NodePair {
    private BinaryNode<T> parent;
    private BinaryNode<T> child;

    NodePair(BinaryNode<T> parent, BinaryNode<T> child) {
      this.parent = parent;
      this.child = child;
    }

    public BinaryNode<T> getParent() {
      return parent;
    }

    public BinaryNode<T> getChild() {
      return child;
    }
  }

  public T getPredecessor(T entry) {
    return getPredecessorNode(findNode(entry).getChild()).getData();
  }

  private BinaryNode<T> getPredecessorNode(BinaryNode<T> node) {
    return findRightmostChild(node.getLeft());
  }

  private BinaryNode<T> findRightmostChild(BinaryNode<T> node) {
    return node.hasRight() ? findRightmostChild(node.getRight()) : node;
  }
}