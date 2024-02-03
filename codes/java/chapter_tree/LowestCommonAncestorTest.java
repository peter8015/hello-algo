package chapter_tree;

/**
 * @author zhanghaibing
 * @date 2024-02-03
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

public class LowestCommonAncestorTest {

    private LowestCommonAncestor lca;
    private TreeNode root;
    private TreeNode nodeP;
    private TreeNode nodeQ;

    @Before
    public void setUp() {
        lca = new LowestCommonAncestor();
        // 构建一棵二叉树作为测试用例
        root = new TreeNode(3);
        nodeP = new TreeNode(5);
        nodeQ = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = nodeP;
        root.left.right = new TreeNode(4);
        root.right.left = nodeQ;
        root.right.right = new TreeNode(2);
    }

    @Test
    public void testLowestCommonAncestor() {
        TreeNode result = lca.lowestAncesstor(root, nodeP, nodeQ);
        // 验证结果是否正确
        Assert.assertEquals(result.val, 3);
    }

    @Test
    public void testLowestCommonAncestorWhenPandQAreSame() {
        TreeNode result = lca.lowestAncesstor(root, nodeP, nodeP);
        // 验证结果是否正确
        Assert.assertEquals(result.val, 5);
    }

    @Test
    public void testLowestCommonAncestorWhenPandQAreDifferent() {
        TreeNode result = lca.lowestAncesstor(root, nodeP, nodeQ);
        // 验证结果是否正确
        Assert.assertEquals(result.val, 3);
    }

    @Test
    public void testLowestCommonAncestorWhenPandQAreNotInTree() {
        TreeNode result = lca.lowestAncesstor(root, new TreeNode(6), new TreeNode(7));
        // 验证结果是否正确
        Assert.assertNull(result);
    }
}
