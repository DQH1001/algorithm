package com.study.algorithm.linkList;

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}
 */
public class BM4MergeSortedLinkList {
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }

        if (pHead1.val <= pHead2.val) {
            pHead1.next = Merge(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = Merge(pHead1, pHead2.next);
            return pHead2;
        }
    }
}
