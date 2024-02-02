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
     * BFS
     * @param root
     * @return
     */
    public List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }
}
