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


}
