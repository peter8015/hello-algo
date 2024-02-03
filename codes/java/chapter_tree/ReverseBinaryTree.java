package chapter_tree;

import utils.TreeNode;

/**
 * @author zhanghaibing
 * @date 2024-02-03
 */
public class ReverseBinaryTree {

    //leetcode 226. 翻转二叉树
    //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
    public TreeNode reverseTree(TreeNode root) {
        // 递归函数的终止条件，当root为空时返回空
        if(root == null) {
            return root;
        }

        // 递归交换左子树
        TreeNode left = reverseTree(root.left);
        // 递归交换右子树
        TreeNode right = reverseTree(root.right);

        // 交换左右子树
        root.left = left;
        root.right = right;

        return root;
    }
}
