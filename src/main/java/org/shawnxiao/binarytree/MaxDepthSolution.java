package org.shawnxiao.binarytree;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 思路：利用前中后序遍历的各个时间点  来计算最大二叉树深度
 */
public class MaxDepthSolution {
    int maxDepth = 0;
    int depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历操作
        depth++;
        traverse(root.left);
        // 中序遍历操作
        maxDepth = Math.max(maxDepth, depth);
        traverse(root.right);
        // 后续遍历操作
        depth--;
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), right);

        MaxDepthSolution solution = new MaxDepthSolution();
        checkArgument(solution.maxDepth(root) == 3);
    }
}
