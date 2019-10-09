package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionSameTreeTest {

    @Test
    void isSameTree() {
        SolutionSameTree solution = new SolutionSameTree();
        assertTrue(solution.isSameTree(null, null));
        assertFalse(solution.isSameTree(new SolutionSameTree.TreeNode(0), null));
        assertFalse(solution.isSameTree(null, new SolutionSameTree.TreeNode(0)));
        assertTrue(solution.isSameTree(new SolutionSameTree.TreeNode(0),
                new SolutionSameTree.TreeNode(0)));
        SolutionSameTree.TreeNode eg1tree1 = new SolutionSameTree.TreeNode(1);
        eg1tree1.left = new SolutionSameTree.TreeNode(2);
        eg1tree1.right = new SolutionSameTree.TreeNode(3);
        SolutionSameTree.TreeNode eg1tree2 = new SolutionSameTree.TreeNode(1);
        eg1tree2.left = new SolutionSameTree.TreeNode(2);
        eg1tree2.right = new SolutionSameTree.TreeNode(3);
        assertTrue(solution.isSameTree(eg1tree1, eg1tree2));
        SolutionSameTree.TreeNode eg2tree1 = new SolutionSameTree.TreeNode(1);
        eg2tree1.left = new SolutionSameTree.TreeNode(2);
        SolutionSameTree.TreeNode eg2tree2 = new SolutionSameTree.TreeNode(1);
        eg2tree2.right = new SolutionSameTree.TreeNode(2);
        assertFalse(solution.isSameTree(eg2tree1, eg2tree2));
        SolutionSameTree.TreeNode eg3tree1 = new SolutionSameTree.TreeNode(1);
        eg3tree1.left = new SolutionSameTree.TreeNode(2);
        eg3tree1.right = new SolutionSameTree.TreeNode(1);
        SolutionSameTree.TreeNode eg3tree2 = new SolutionSameTree.TreeNode(1);
        eg3tree2.right = new SolutionSameTree.TreeNode(2);
        eg3tree2.left = new SolutionSameTree.TreeNode(1);
        assertFalse(solution.isSameTree(eg3tree1, eg3tree2));
    }
}