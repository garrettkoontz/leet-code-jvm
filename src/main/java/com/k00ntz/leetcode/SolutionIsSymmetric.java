package com.k00ntz.leetcode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * ----1
 * ---/ \
 * --2   2
 * -/ \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * ----1
 * ---/ \
 * --2   2
 * ---\   \
 * ---3    3
 */
public class SolutionIsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && null == root.right)) return true;
        return isMirrored(root.left, root.right);
    }

    private boolean isMirrored(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isMirrored(left.left, right.right) && isMirrored(left.right, right.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}
