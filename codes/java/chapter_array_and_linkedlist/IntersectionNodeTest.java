package chapter_array_and_linkedlist;

/**
 * @author zhanghaibing
 * @date 2024-02-04
 */
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.*;

public class IntersectionNodeTest {

    private IntersectionNode solution = new IntersectionNode();

    @Test
    public void testGetIntersectionNode() {
        // 测试用例1：无相交链表
        ListNode headA1 = new ListNode(1);
        headA1.next = new ListNode(2);
        ListNode headB1 = new ListNode(3);
        headB1.next = new ListNode(4);
        assertNull(solution.getIntersectionNode(headA1, headB1));

        // 测试用例2：有相交链表，相交点在尾部
        ListNode nodeC = new ListNode(5);
        ListNode tailA = new ListNode(6);
        ListNode tailB = new ListNode(7);
        headA1.next.next = nodeC;
        headB1.next.next = nodeC;

        assertEquals(nodeC, solution.getIntersectionNode(headA1, headB1));

        // 测试用例3：有相交链表，相交点在中间
        ListNode headA2 = new ListNode(8);
        ListNode headB2 = new ListNode(9);
        ListNode nodeE = new ListNode(10);
        ListNode nodeD = new ListNode(11);
        headA2.next = nodeD;
        headB2.next = nodeE;
        nodeD.next = nodeE;

        assertEquals(nodeE, solution.getIntersectionNode(headA2, headB2));
    }
}

