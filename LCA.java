import java.util.*;

public class LCA {

    // Definition for a binary tree node
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // =========================================================================
    // 1. Lowest Common Ancestor in a General Binary Tree (LeetCode 236)
    // Time Complexity:  O(N) - visits each node once
    // Space Complexity: O(H) - recursion stack space where H is tree height
    // =========================================================================
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case:
        // - null: leaf ke neeche chale gaye, kuch nahi mila
        // - root == p ya root == q: target node mil gaya, upar return karo
        //   (agar doosra node iske neeche hua, toh ye khud hi LCA banega)
        if (root == null || root == p || root == q) {
            return root;
        }

        // Left aur Right subtrees me p aur q ko recursively search karo (Postorder)
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Agar left aur right dono non-null hain:
        // iska matlab p ek subtree me hai aur q doosre subtree me hai.
        // Isliye current root hi LCA hai!
        if (left != null && right != null) {
            return root;
        }

        // Agar sirf ek side se non-null mila, toh wahi side ka result upar pass karo
        // (ya toh wahi LCA hai, ya target node hai, ya dono null hain toh null jayega)
        return left != null ? left : right;
    }

    // =========================================================================
    // 2. Lowest Common Ancestor in a Binary Search Tree (BST) (LeetCode 235)
    // Time Complexity:  O(H) - traversal follows a single path from root
    // Space Complexity: O(1) - iterative approach, no recursion stack
    // =========================================================================
    public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) {
                // Dono values curr se badi hain -> LCA right subtree me hoga
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val) {
                // Dono values curr se chhoti hain -> LCA left subtree me hoga
                curr = curr.left;
            } else {
                // Split point mil gaya:
                // - Ya toh ek chhota hai aur ek bada (paths split ho gaye)
                // - Ya curr.val == p.val ya q.val (node khud ka ancestor ho sakta hai)
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // -----------------------------------------------------------------
        // Test Case 1: Binary Tree (LeetCode 236)
        // Tree:
        //           3
        //         /   \
        //        5     1
        //       / \   / \
        //      6   2 0   8
        //         / \
        //        7   4
        // -----------------------------------------------------------------
        TreeNode rootBT = new TreeNode(3);
        rootBT.left = new TreeNode(5);
        rootBT.right = new TreeNode(1);
        rootBT.left.left = new TreeNode(6);
        rootBT.left.right = new TreeNode(2);
        rootBT.right.left = new TreeNode(0);
        rootBT.right.right = new TreeNode(8);
        rootBT.left.right.left = new TreeNode(7);
        rootBT.left.right.right = new TreeNode(4);

        TreeNode p1 = rootBT.left;                 // Node 5
        TreeNode q1 = rootBT.right;                // Node 1
        TreeNode lca1 = lowestCommonAncestor(rootBT, p1, q1);
        System.out.println("--- Binary Tree LCA ---");
        System.out.println("LCA of " + p1.val + " and " + q1.val + " = " + (lca1 != null ? lca1.val : "null") + " (Expected: 3)");

        TreeNode p2 = rootBT.left;                 // Node 5
        TreeNode q2 = rootBT.left.right.right;     // Node 4
        TreeNode lca2 = lowestCommonAncestor(rootBT, p2, q2);
        System.out.println("LCA of " + p2.val + " and " + q2.val + " = " + (lca2 != null ? lca2.val : "null") + " (Expected: 5)");

        // -----------------------------------------------------------------
        // Test Case 2: Binary Search Tree (LeetCode 235)
        // BST:
        //           6
        //         /   \
        //        2     8
        //       / \   / \
        //      0   4 7   9
        //         / \
        //        3   5
        // -----------------------------------------------------------------
        TreeNode rootBST = new TreeNode(6);
        rootBST.left = new TreeNode(2);
        rootBST.right = new TreeNode(8);
        rootBST.left.left = new TreeNode(0);
        rootBST.left.right = new TreeNode(4);
        rootBST.left.right.left = new TreeNode(3);
        rootBST.left.right.right = new TreeNode(5);
        rootBST.right.left = new TreeNode(7);
        rootBST.right.right = new TreeNode(9);

        TreeNode pBST1 = rootBST.left;             // Node 2
        TreeNode qBST1 = rootBST.right;            // Node 8
        TreeNode lcaBST1 = lowestCommonAncestorBST(rootBST, pBST1, qBST1);
        System.out.println("\n--- Binary Search Tree (BST) LCA ---");
        System.out.println("BST LCA of " + pBST1.val + " and " + qBST1.val + " = " + (lcaBST1 != null ? lcaBST1.val : "null") + " (Expected: 6)");

        TreeNode pBST2 = rootBST.left;             // Node 2
        TreeNode qBST2 = rootBST.left.right;       // Node 4
        TreeNode lcaBST2 = lowestCommonAncestorBST(rootBST, pBST2, qBST2);
        System.out.println("BST LCA of " + pBST2.val + " and " + qBST2.val + " = " + (lcaBST2 != null ? lcaBST2.val : "null") + " (Expected: 2)");
    }
}
