package chapter_tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhanghaibing
 * @date 2024-02-02
 */
public class Bfs {

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);


        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }

    /**
     * leetcode 102 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelBfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList();

            System.out.println("size=" + size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
