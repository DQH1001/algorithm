package com.study.algorithm.linkList;

/**
 * 将给出的链表中的节点每 k个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * <p>
 * 例如：
 * 给定的链表是 1→2→3→4→5
 * 对于 k=2, 你应该返回 2→1→4→3→5
 * 对于 k=3, 你应该返回 3→2→1→4→5
 */
public class BM3ReverseGourpByK {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        // 遍历找到尾节点，如果尾节点为null说明不够k个，直接返回
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            // 保存当前节点的下一个节点
            ListNode temp = cur.next;
            // 反转，当前节点指向上一个节点
            cur.next = pre;
            // 更新上一个节点与当前节点
            pre = cur;
            cur = temp;
        }
        // 当前的尾节点，指向下一段的尾节点
        head.next = reverseKGroup(tail, k);
        return pre;
    }
}
