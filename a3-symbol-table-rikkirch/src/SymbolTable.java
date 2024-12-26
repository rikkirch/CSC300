import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SymbolTable<Key extends Comparable<Key>, Value> implements ISymbolTable<Key , Value> {
    private class Node {
        Key key;            /* The key that the node will store */
        Value val;          /* The value the node will store */
        Node left, right;   /* pointers to the left and right children of this node */
        int size;           /* The number of nodes in the subtree rooted by this node */

        public Node(Key k, Value v, int s) {
            this.key = k;
            this.val = v;
            this.size = s;
        }
    }

    /* the root of our tree */
    Node root;

    public void put(Key k, Value v) throws InvalidParameterException {
        if (k == null) {
            throw new InvalidParameterException("no key was passed");
        }
        root = put(root, k, v);
    }

    private Node put(Node x, Key k, Value v) {
        if (x == null) return new Node(k, v, 1);

        int cmp = k.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, k, v);
        else if (cmp > 0) x.right = put(x.right, k, v);
        else x.val = v;  // if keys are equal, update value

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key k) throws NoSuchElementException, InvalidParameterException {
        if (k == null) {
            throw new InvalidParameterException("no key was passed");
        }
        return get(root, k);
    }

    private Value get(Node x, Key k) {
        if (x == null) throw new NoSuchElementException("Key not found");

        int cmp = k.compareTo(x.key);
        if (cmp < 0) return get(x.left, k);
        else if (cmp > 0) return get(x.right, k);
        else return x.val;
    }

    public void del(Key k) throws NoSuchElementException, InvalidParameterException {
        if (k == null) {
            throw new InvalidParameterException("no key was passed");
        }
        root = del(root, k);
    }

    private Node del(Node x, Key k) {
        if (x == null) throw new NoSuchElementException("Key not found");

        int cmp = k.compareTo(x.key);
        if (cmp < 0) x.left = del(x.left, k);
        else if (cmp > 0) x.right = del(x.right, k);
        else {
            // Node to be deleted found
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            // Node with two children: get the successor (smallest in the right subtree)
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public boolean contains(Key k) {
        return get(k) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public LinkedList<Key> keys() {
        LinkedList<Key> keys = new LinkedList<>();
        inorder(root, keys);
        return keys;
    }

    private void inorder(Node x, LinkedList<Key> keys) {
        if (x == null) return;
        inorder(x.left, keys);
        keys.add(x.key);
        inorder(x.right, keys);
    }

    /*******************************************************************************************************************
     * Tree integrity checking functions as written by the book's authors. Do not modify any of the following functions,
     * they should be used to ensure that your tree is correctly structured
     ******************************************************************************************************************/

    public boolean check() {
        boolean isBST = isBST();
        boolean isSizeConsistent = isSizeConsistent();
        boolean isRankConsistent = isRankConsistent();

        if (!isBST)            System.out.println("Not in symmetric order");
        if (!isSizeConsistent) System.out.println("Subtree counts not consistent");
        if (!isRankConsistent) System.out.println("Ranks not consistent");

        return isBST && isSizeConsistent && isRankConsistent;
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    public boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }

    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) return false;
        }
        for (Key key : keys()) {
            if (key.compareTo(select(rank(key))) != 0) return false;
        }
        return true;
    }

    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private Key select(Node x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if      (leftSize > rank) return select(x.left,  rank);
        else if (leftSize < rank) return select(x.right, rank - leftSize - 1);
        else                      return x.key;
    }
}
