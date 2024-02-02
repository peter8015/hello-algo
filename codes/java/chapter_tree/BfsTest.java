package chapter_tree;

/**
 * @author zhanghaibing
 * @date 2024-02-02
 */
import org.junit.Before;
import org.junit.Test;
import utils.PrintUtil;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class BfsTest {

    private Bfs bfs;
    private TreeNode root;

    @Before
    public void setUp() {
        bfs = new Bfs();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }

    @Test
    public void testBfs() {
        // 测试树的深度优先遍历
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(3);
        expectedResult.add(4);
        expectedResult.add(5);
        expectedResult.add(6);
        expectedResult.add(7);

        List<Integer> actualResult = bfs.bfs(root);

        actualResult.stream().forEach(val -> System.out.println(val));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBfsWithEmptyTree() {
        // 测试空树
        List<Integer> actualResult = bfs.bfs(null);

        assertTrue(actualResult.isEmpty());
    }

    @Test
    public void testBfsWithSingleNode() {
        // 测试只有一个节点的树
        TreeNode singleNode = new TreeNode(1);
        List<Integer> actualResult = bfs.bfs(singleNode);
        System.out.println(actualResult.get(0));

        assertEquals(1, actualResult.size());
        assertEquals(1, actualResult.get(0).intValue());
    }

}
