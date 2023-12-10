package com.study.algorithm.linkList;

/**
 * 给定一个单链表的头结点,反转该链表
 * 数据范围：0≤n≤1000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)。
 *
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 */
public class BM1ReverseLinkedList {
    public ListNode ReverseList (ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            // 临时存下一个节点
            ListNode temp = head.next;

            // 反转 当前节点的下一个节点为新链表
            head.next = newHead;

            // 更新新链表的头节点
            newHead = head;

            // 重置当前节点为下一个节点
            head = temp;
        }
        return newHead;
    }
}
