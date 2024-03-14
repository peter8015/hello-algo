package cases;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghaibing
 * @date 2024-03-14
 * <p>
 * Coding case:
 * 题目描述：离线数据处理：一个表依赖多个表，多个表又依赖于其他表，其中一个表处理失败时，如何重启批处理。
 * 如表B依赖ACD，D又依赖于H，写出代码。关键是如果通过表B找到多级依赖。
 * 关键思路：如何根据一个节点找到多个关联节点：深度遍历；如果定义结构和方法：领域模型的创建
 * 注意点：
 * 1. 此题为coding题目，重点在于澄清需求，接口定义，定义数据模型，产出逻辑代码，要简化系统设计的步骤。
 * 2. 需要思考逻辑中涉及的算法。
 *
 * 系统设计思路进行分析：
 * 1. 需求澄清：解决什么问题，产出流程图（领域划分）
    * - 多个处理节点nodes，每个节点处理一些表tables?
    * - 节点间的依赖关系是什么样的？或者说是一个什么样的结构？在哪里维护？
    * - 单个节点处理逻辑中包含的表是哪来的？
    * - 其中一个节点处理失败后，会找到所有相关的节点，重新处理？
    * - 有没有相互依赖的可能？B -> A ->B
    * - 处理流程：先找到相关节点，需要从根节点一步一步按先后的顺序处理？
 * 2. 系统接口定义：希望系统解决什么问题，产出API
     * - restart(nodeId, TreeNode)  //重启节点逻辑
     * - processNodeData()  //节点数据处理
 * 3. 粗略估算: 容量、性能
 *  - 多少个节点？10个处理节点。
 *  - 一个节点多少张表？单表最大多少数据？ 占用内存？一个节点涉及10张表，单表最大1000w条。
 *  - 一个节点处理数据，需要多长时间？
 *
 * 4. 定义数据模型：E-R图
 * - 实体定义：表、节点、处理最大时间、重试次数
 *
 * 5. 高级设计：识别模块，产出类图
 * 6. 细节设计：对模块进行设计，产出不同的方案，进行tradeoff。
 * 7. 解决系统瓶颈：找出风险点，做好预案（涉及非功能性设计）
 */
public class coupang {

    /**
     * Get all nodes base specific node;
     *
     * @param node
     * @return List<TreeNode>
     */
    private List<TreeNode> getAllNodes(TreeNode node) {
        // dfs
        List<TreeNode> nodes = new ArrayList<>();


        System.out.println("Get all nodes!");
        return nodes;
    }



    @Test
    public void testGetAllNodes() {
        System.out.println("Test get all nodes!");

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;

        List<TreeNode> nodes = getAllNodes(left1);

        nodes.stream().forEach(System.out::println);

    }

    @Test
    public void testProcessNodeData() {
        System.out.println("test process node data!");

    }

    @Testable
    public void test() {
        testGetAllNodes();
        testProcessNodeData();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}