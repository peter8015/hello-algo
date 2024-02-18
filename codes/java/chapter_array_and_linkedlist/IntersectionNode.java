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
    // 方法一：快慢指针 方法2： 使用哈希表
    // 问题：1. 测试有问题
    public ListNode intersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

}
