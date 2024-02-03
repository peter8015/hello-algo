package chapter_tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghaibing
 * @date 2024-02-02
 */
public class Dfs {
    private static List<Integer> result = new ArrayList();

    public List<Integer> preOrder(TreeNode root) {
        if(root == null) {
            return result;
        }

        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);

        return result;
    }



    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();

        inOrder(root, result);
        return result;
    }

    //leetcode94 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
    public void inOrder(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

}
