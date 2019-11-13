package otherpractice;

import java.util.Map;
import java.util.Set;

/**
 * add only AVL binary tree
 *
 * @param <K>
 * @param <V>
 */
public class BinaryTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public BinaryTree(K key, V value) {
        this.root = new Node<>(key, value);
    }

    public static <L extends Comparable<L>, W> BinaryTree<L, W> buildFrom(Map<L, W> mp) {
        Set<Map.Entry<L, W>> entries = mp.entrySet();
        Map.Entry<L, W> first = entries.iterator().next();
        BinaryTree<L, W> binaryTree = new BinaryTree<>(first.getKey(), first.getValue());
        entries.remove(first);
        for (Map.Entry<L, W> e : entries) {
            binaryTree.add(e.getKey(), e.getValue());
        }
        return binaryTree;
    }

    public void add(K key, V value) {
        this.root = root.add(key, value);
    }

    public V findValueAtLessThanOrEqualTo(K key) {
        Node<K, V> n = root;
        while (true) {
            if (n == null) return null;
            switch (Long.signum(key.compareTo(n.key))) {
                case 1:
                    if (n.left == null) {
                        return null;
                    } else if (n.left.getKey().compareTo(key) >= 0) {
                        return n.left.getValue();
                    } else {
                        n = n.left;
                    }
                    break;
                case 0:
                    return n.getValue();
                case -1:
                    if (n.right == null) return n.getValue();
                    n = n.right;
                    break;
            }
        }
    }

    public static class Node<K extends Comparable<K>, V> {
        private final K key;
        private final V value;
        private int height = 1;
        private Node<K, V> left = null;
        private Node<K, V> right = null;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean isBalanced() {
            return Math.abs(balanceFactor()) <= 1;
        }

        private int balanceFactor() {
            return (this.left != null ? this.left.height : 0) - (this.right != null ? this.right.height : 0);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        private void updateHeight() {
            this.height = 1 + Math.max(this.left != null ? this.left.height : 0,
                    this.right != null ? this.right.height : 0);
        }

        static <T extends Comparable<T>, E> Node<T, E> recursiveAdd(Node<T, E> node, T ky, E vl) {
            if (node == null) {
                return new Node<>(ky, vl);
            }
            if (ky.compareTo(node.key) < 0) {
                node.left = recursiveAdd(node.left, ky, vl);
            } else if (ky.compareTo(node.key) > 0) {
                node.right = recursiveAdd(node.right, ky, vl);
            } else {
                //no dups
                return node;
            }
            node.updateHeight();
            int balanceFactor = node.balanceFactor();
            if (balanceFactor > 1 && ky.compareTo(node.left.key) > 0) {
                return node.rightRotate();
            } else if (balanceFactor < -1 && ky.compareTo(node.right.key) > 0) {
                return node.leftRotate();
            } else if (balanceFactor > 1 && ky.compareTo(node.left.key) < 0) {
                node.left = node.left.leftRotate();
                return node.rightRotate();
            } else if (balanceFactor < -1 && ky.compareTo(node.right.key) < 0) {
                node.right = node.right.rightRotate();
                return node.leftRotate();
            }
            return node;
        }

        public Node<K, V> add(K ky, V vl) {
            return recursiveAdd(this, ky, vl);
        }

        /*
         *   z                                y
         *  /  \                            /   \
         * T1   y     Left Rotate(z)       z      x
         *     /  \   - - - - - - - ->    / \    / \
         *    T2   x                     T1  T2 T3  T4
         *        / \
         *      T3  T4
         */
        Node<K, V> leftRotate() {
            Node<K, V> z = this;
            Node<K, V> y = z.right;
            Node<K, V> t2 = y.left;
            z.right = t2;
            y.left = z;
            y.updateHeight();
            z.updateHeight();
            return y;
        }

        /*
         *        z                                      y
         *       / \                                   /   \
         *      y   T4      Right Rotate (z)          x      z
         *     / \          - - - - - - - - ->      /  \    /  \
         *    x   T3                               T1  T2  T3  T4
         *   / \
         * T1   T2
         */
        Node<K, V> rightRotate() {
            Node<K, V> z = this;
            Node<K, V> y = z.left;
            Node<K, V> t3 = y.right;
            y.right = z;
            z.left = t3;
            z.updateHeight();
            y.updateHeight();
            return y;
        }
    }
}
