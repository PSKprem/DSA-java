// A Binary Search Tree (BST) keeps this rule for every node:
//   everything in the left subtree  < node.value
//   everything in the right subtree > node.value
//
// Example:
//         50
//        /  \
//      30    70
//     / \   / \
//   20  40 60  80
//
// Inorder traversal (left, node, right) visits the values in sorted order.

public class BinarySearchTree {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // ---------- Insert ----------
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);       // found the empty spot
        }
        if (value < node.value) {
            node.left = insert(node.left, value);    // go left
        } else if (value > node.value) {
            node.right = insert(node.right, value);  // go right
        }
        // value == node.value: duplicates are ignored
        return node;
    }

    // ---------- Search ----------
    public boolean contains(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            }
            current = (value < current.value) ? current.left : current.right;
        }
        return false;
    }

    // ---------- Delete ----------
    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;                  // value not found
        }
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // Case 1 and 2: zero or one child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // Case 3: two children.
            // Replace with the smallest value in the right subtree
            // (the inorder successor), then delete that duplicate.
            Node successor = minNode(node.right);
            node.value = successor.value;
            node.right = delete(node.right, successor.value);
        }
        return node;
    }

    // ---------- Min / Max / Height ----------
    public int min() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        return minNode(root).value;
    }

    private Node minNode(Node node) {
        while (node.left != null) {
            node = node.left;             // leftmost = smallest
        }
        return node;
    }

    public int max() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        Node node = root;
        while (node.right != null) {
            node = node.right;            // rightmost = largest
        }
        return node.value;
    }

    // Height counted in edges: a single node has height 0, empty tree -1.
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // ---------- Traversals ----------
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            bst.insert(value);
        }

        System.out.print("Inorder (sorted): ");
        bst.inorder();

        System.out.print("Preorder:          ");
        bst.preorder();

        System.out.print("Postorder:         ");
        bst.postorder();

        System.out.println("Contains 60? " + bst.contains(60));
        System.out.println("Contains 65? " + bst.contains(65));
        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());
        System.out.println("Height: " + bst.height());

        bst.delete(30);   // two children case
        System.out.print("After deleting 30: ");
        bst.inorder();

        bst.delete(20);   // one child (no children in this case)
        System.out.print("After deleting 20: ");
        bst.inorder();
    }
}
