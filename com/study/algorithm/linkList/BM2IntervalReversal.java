package com.study.algorithm.linkList;

/**
 * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
 * 例如：
 * 给出的链表为 1→2→3→4→5→NULL,m=2,n=4,
 * 返回 1→4→3→2→5→NULL.
 * <p>
 * <p>
 * 数据范围：链表长度 0<size≤1000，0<m≤n≤size，链表中每个节点的值满足 0∣val∣≤1000
 * 要求：时间复杂度 O(n)，空间复杂度 O(n)
 * 进阶：时间复杂度 O(n)，空间复杂度 O(1)
 */
public class BM2IntervalReversal {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 加一个前置节点，确保第一个节点有前序节点
        ListNode result = new ListNode(-1);
        result.next = head;

        // 前序节点
        ListNode pre = result;
        // 当前节点
        ListNode current = head;
        // 找到m的前序节点和当前节点
        for (int i = 1; i < m; i++) {
            pre = current;
            current = current.next;
        }
        // 1->2->3->4->5,假设m（current）为2，n为4
        for (int i = m; i < n; i++) {
            // 先拿到节点3 | 4
            ListNode temp = current.next;
            // 那么2指向3的指针就可以变更为2->4 | 2->4变为2->5
            current.next = temp.next;
            // 3指向4的指针变为3->2 | 4->5变为4->3
            temp.next = pre.next;
            // 1指向2的指针变为1->3 | 1->3变为1->4
            pre.next = temp;
            // 1->2->3->4->5
            // 第一次遍历完之后为：1->3->2->4->5
            // 第二次遍历完之后为：1->4->3->2->5
        }
        // 去掉头节点
        return result.next;
    }
}
