package chapter_tree;

/**
 * @author zhanghaibing
 * @date 2024-02-02
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DfsTest {

    private Dfs dfs;
    private TreeNode root;

    @Before
    public void setUp() {
        dfs = new Dfs();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
    }

    @Test
    public void testPreOrderTraversal() {
        // Arrange
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);

        // Act
        List<Integer> actual = dfs.preOrder(root);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testInOrder() {
        List<Integer> result = new ArrayList<>();
        dfs.inOrder(root, result);

        // 预期结果
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 3));

        // 验证结果是否符合预期
        Assert.assertEquals(expected, result);
    }

}

