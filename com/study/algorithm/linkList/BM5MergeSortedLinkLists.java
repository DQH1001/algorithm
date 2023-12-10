package com.study.algorithm.linkList;

import java.util.ArrayList;

/**
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 */
public class BM5MergeSortedLinkLists {
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val <= pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }
        if (pHead1 != null) {
            cur.next = pHead1;
        }
        if (pHead2 != null) {
            cur.next = pHead2;
        }
        // 去掉表头
        return head.next;
    }

    ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return lists.get(left);
        }
        int mid = (left + right) / 2;
        return Merge(divideMerge(lists, left, mid), divideMerge(lists, mid + 1, right));
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideMerge(lists, 0, lists.size() - 1);
    }
}
