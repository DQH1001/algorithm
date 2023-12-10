package com.study.algorithm.linkList;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 */
public class BM6HasCycle {
    List<ListNode> data = new ArrayList<>();
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (data.contains(head)) {
                return true;
            }
            data.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 知识点：双指针
     * 双指针指的是在遍历对象的过程中，不是普通的使用单个指针进行访问，而是使用两个指针（特殊情况甚至可以多个），
     * 两个指针或是同方向访问两个链表、或是同方向访问一个链表（快慢指针）、或是相反方向扫描（对撞指针），
     * 从而达到我们需要的目的。
     *
     * 思路：
     *
     * 我们都知道链表不像二叉树，每个节点只有一个val值和一个next指针，也就是说一个节点只能有一个指针指向下一个节点，
     * 不能有两个指针，那这时我们就可以说一个性质：环形链表的环一定在末尾，末尾没有NULL了。
     * 如果是普通线形链表末尾一定有NULL，那我们可以根据链表中是否有NULL判断是不是有环。
     *
     * 但是，环形链表遍历过程中会不断循环，线形链表遍历到NULL结束了，但是环形链表何时能结束呢？我们可以用双指针技巧，
     * 同向访问的双指针，速度是快慢的，只要有环，二者就会在环内不断循环，且因为有速度差异，二者一定会相遇。
     *
     * 具体做法：
     * step 1：设置快慢两个指针，初始都指向链表头。
     * step 2：遍历链表，快指针每次走两步，慢指针每次走一步。
     * step 3：如果快指针到了链表末尾，说明没有环，因为它每次走两步，所以要验证连续两步是否为NULL。
     * step 4：如果链表有环，那快慢双指针会在环内循环，因为快指针每次走两步，因此快指针会在环内追到慢指针，
     * 二者相遇就代表有环。
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
