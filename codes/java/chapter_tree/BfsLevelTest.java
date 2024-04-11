package chapter_tree;

/**
 * @author zhanghaibing
 * @date 2024-02-02
 */
import org.junit.Test;
import utils.TreeNode;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BfsLevelTest {

    @Test
    public void testLevelOrderTraversal() {
        BfsLevel bfs = new BfsLevel();

        // 测试用例3：具有多个节点的完全平衡树
        TreeNode tree3 = new TreeNode(3);
        tree3.left = new TreeNode(9);
        tree3.right = new TreeNode(20);
        tree3.left.left = null;
        tree3.left.right = null;
        tree3.right.left = new TreeNode(15);
        tree3.right.right = new TreeNode(7);
        assertEquals(
                Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                bfs.levelOrder(tree3)
        );
    }
}
