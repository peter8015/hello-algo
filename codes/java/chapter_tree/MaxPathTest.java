package chapter_tree;

/**
 * @author zhanghaibing
 * @date 2024-02-03
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

public class MaxPathTest {

    private MaxPath maxPath;

    @Before
    public void setUp() {
        maxPath = new MaxPath();
    }

    @Test
    public void testMaxPathSum_PositiveCase() {
        // 构造测试用例
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 执行测试
        int result = maxPath.maxPathSum(root);

        // 验证结果
        int expectedMaxPathSum = 42; // 1 + (-2) + 4 + 5 = 7
        Assert.assertEquals(expectedMaxPathSum, result);
    }

    @Test
    public void testMaxPathSum_NegativeCase() {
        // 构造测试用例
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);

        // 执行测试
        int result = maxPath.maxPathSum(root);

        // 验证结果
        int expectedMaxPathSum = 0; // 最大路径和为0
        Assert.assertEquals(expectedMaxPathSum, result);
    }

    @Test
    public void testMaxPathSum_LeafNode() {
        // 构造测试用例
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 执行测试
        int result = maxPath.maxPathSum(root);

        // 验证结果
        int expectedMaxPathSum = 6; // 1 + 2 + 3 = 6
        Assert.assertEquals(expectedMaxPathSum, result);
    }

    // 可以添加更多测试用例来覆盖不同的场景，例如只有左子树、只有右子树、空树等
}

