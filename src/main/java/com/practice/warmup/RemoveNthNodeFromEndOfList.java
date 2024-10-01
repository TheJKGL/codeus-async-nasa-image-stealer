package com.practice.warmup;

public class RemoveNthNodeFromEndOfList {

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     *
     * Example 1:
     *      Input: head = [1,2,3,4,5], n = 2
     *      Output: [1,2,3,5]
     *          [1 -> 2 -> 3 -> 4 -> 5]
     *          [1 -> 2 -> 3 ------> 5]
     * Example 2:
     *      Input: head = [1], n = 1
     *      Output: []
     * Example 3:
     *      Input: head = [1,2], n = 1
     *      Output: [1]
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        throw new RuntimeException("Not Implemented");
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
