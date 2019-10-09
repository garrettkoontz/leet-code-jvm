package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionIsSymmetricTest {

    @Test
    void isSymmetric() {
        SolutionIsSymmetric solution = new SolutionIsSymmetric();
        SolutionIsSymmetric.TreeNode tree1 = new SolutionIsSymmetric.TreeNode(1);
        tree1.left = new SolutionIsSymmetric.TreeNode(2);
        tree1.right = new SolutionIsSymmetric.TreeNode(2);
        tree1.left.left = new SolutionIsSymmetric.TreeNode(3);
        tree1.right.right = new SolutionIsSymmetric.TreeNode(3);
        tree1.left.right = new SolutionIsSymmetric.TreeNode(4);
        tree1.right.left = new SolutionIsSymmetric.TreeNode(4);
        assertTrue(solution.isSymmetric(tree1));
        SolutionIsSymmetric.TreeNode tree2 = new SolutionIsSymmetric.TreeNode(1);
        tree2.left = new SolutionIsSymmetric.TreeNode(2);
        tree2.right = new SolutionIsSymmetric.TreeNode(2);
        tree2.left.right = new SolutionIsSymmetric.TreeNode(3);
        tree2.right.right = new SolutionIsSymmetric.TreeNode(3);
        assertFalse(solution.isSymmetric(tree2));
    }
}