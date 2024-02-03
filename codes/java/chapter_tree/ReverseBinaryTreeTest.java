package chapter_tree;

/**
 * @author zhanghaibing
 * @date 2024-02-03
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

public class ReverseBinaryTreeTest {

    private ReverseBinaryTree reverseBinaryTree;

    @Before
    public void setUp() {
        reverseBinaryTree = new ReverseBinaryTree();
    }

    @Test
    public void testReverseTree() {
        // 构建测试用的树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // 翻转树
        TreeNode reversedRoot = reverseBinaryTree.reverseTree(root);

        // 验证翻转后的树是否正确
        Assert.assertEquals(4, (int) reversedRoot.val);
        Assert.assertEquals(2, (int) reversedRoot.left.val);
        Assert.assertEquals(1, (int) reversedRoot.left.left.val);
        Assert.assertEquals(3, (int) reversedRoot.left.right.val);
        Assert.assertEquals(7, (int) reversedRoot.right.val);
        Assert.assertEquals(6, (int) reversedRoot.right.left.val);
        Assert.assertEquals(9, (int) reversedRoot.right.right.val);
    }

    @Test
    public void testReverseTreeWithEmptyTree() {
        // 构建空树
        TreeNode root = null;

        // 翻转空树
        TreeNode reversedRoot = reverseBinaryTree.reverseTree(root);

        // 验证翻转后的树是否为空
        Assert.assertNull(reversedRoot);
    }

    @Test
    public void testReverseTreeWithSingleNode() {
        // 构建只有一个节点的树
        TreeNode root = new TreeNode(5);

        // 翻转只有一个节点的树
        TreeNode reversedRoot = reverseBinaryTree.reverseTree(root);

        // 验证翻转后的树是否正确
        Assert.assertEquals(5, (int) reversedRoot.val);
    }

    // 可以添加更多的测试用例来覆盖不同的场景，例如具有多个子节点的树，具有空子节点的树等。
}
