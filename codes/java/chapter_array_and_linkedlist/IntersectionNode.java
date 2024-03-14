package chapter_array_and_linkedlist;

import utils.ListNode;

/**
 * @author zhanghaibing
 * @date 2024-02-04
 */
public class IntersectionNode {

    // leetcode 160 相交链表
    //    给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
    //    如果两个链表不存在相交节点，返回 null 。
    // 思路：(参考高手)一定要理解题意，两个链表的遍历不是第一次就能相遇的。一图胜千言
    // 1. 指针p1指向headA链表，指针p2指向headB链表。
    // 2. 如果p1到了末尾，则p1 = headB继续遍历。
    // 3. 如果p2到了末尾，则p2 = headA继续遍历。
    // 4. 关键是消除长度差，长链表指针指向短链表的head时会消除。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 指针p1指向headA链表，指针p2指向headB链表。
        ListNode p1 = headA;
        ListNode p2 = headB;

        // 2. 如果p1到了末尾，则p1 = headB继续遍历。
        // 3. 如果p2到了末尾，则p2 = headA继续遍历。
        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
