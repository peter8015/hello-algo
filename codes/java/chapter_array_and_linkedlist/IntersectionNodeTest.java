package chapter_array_and_linkedlist;

/**
 * @author zhanghaibing
 * @date 2024-02-04
 */
import org.junit.Assert;
import org.junit.Test;
import utils.ListNode;

public class IntersectionNodeTest {

    @Test
    public void testIntersectionNode() {
        // 创建链表A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode nodeA1 = new ListNode(4);
        ListNode nodeA2 = new ListNode(1);
        ListNode nodeA3 = new ListNode(8);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);

        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;

        // 创建链表B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode nodeB5 = new ListNode(5);
        ListNode nodeB6 = new ListNode(6);
        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB8 = new ListNode(8);
        ListNode nodeB4 = new ListNode(4);
        ListNode nodeB55 = new ListNode(5);

        nodeB5.next = nodeB6;
        nodeB6.next = nodeB1;
        nodeB1.next = nodeB8;
        nodeB8.next = nodeB4;
        nodeB4.next = nodeB55;

        // 期望的交点是2，因为2是两个链表中都有的节点
        ListNode intersection = new IntersectionNode().intersectionNode(nodeA1, nodeB5);

        // 验证结果是否正确
        Assert.assertNotNull(intersection);
        Assert.assertEquals(2, intersection.val);

        // 测试链表A为空的情况
        intersection = new IntersectionNode().intersectionNode(null, nodeB1);
        Assert.assertNull(intersection);

        // 测试链表B为空的情况
        intersection = new IntersectionNode().intersectionNode(nodeA1, null);
        Assert.assertNull(intersection);

        // 测试两个链表都没有交点的情况
        intersection = new IntersectionNode().intersectionNode(nodeA4, nodeB5);
        Assert.assertNull(intersection);
    }
}

