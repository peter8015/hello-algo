package chapter_tree;

import utils.TreeNode;

/**
 * @author zhanghaibing
 * @date 2024-02-03
 */
public class LowestCommonAncestor {
    private TreeNode ans;

    //236. 二叉树的最近公共祖先 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    // 递归整个二叉树，判断f(x) 节点是否包含p和q，如果包含，返回true
    public TreeNode lowestAncesstor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    /**
     * 深度优先搜索二叉树，找到两个指定的节点p和q的最近公共祖先
     * @param root 二叉树的根节点
     * @param p 第一个指定的节点
     * @param q 第二个指定的节点
     * @return 如果找到了最近公共祖先，则返回true；否则返回false
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，则返回false
        if(root == null) {
            return false;
        }
        // 如果当前节点是p或q节点，则更新最近公共祖先节点为当前节点
        if(root == p || root == q) {
            ans = root;
            return true;
        }

        // 递归搜索左右子树
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if((lson && rson) || (root.val == p.val || root.val == q.val)) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
