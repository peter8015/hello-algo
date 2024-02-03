package chapter_tree;

import utils.TreeNode;

/**
 * @author zhanghaibing
 * @date 2024-02-03
 */
public class MaxPath {
    int max = Integer.MIN_VALUE;

    // 124 二叉树中的最大路径和
    // 给你一个二叉树的根节点 root ，返回其最大路径和 。
    //    二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
    //    同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归计算左右子节点的最大路径和
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        int r = left + right + root.val;

        max = Math.max(max, r);
        return root.val + Math.max(left, right);
    }
}
