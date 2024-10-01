package com.practice.warmup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static com.practice.warmup.RemoveNthNodeFromEndOfList.ListNode;

public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void testRemoveNthFromEnd_middleNode() {
        // Setup: List [1 -> 2 -> 3 -> 4 -> 5], remove 2nd from end (4)
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, 2);

        // Expected: [1 -> 2 -> 3 -> 5]
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(3, head.next.next.val);
        assertEquals(5, head.next.next.next.val);
        assertNull(head.next.next.next.next);
    }

    @Test
    public void testRemoveNthFromEnd_firstNode() {
        // Setup: List [1 -> 2 -> 3 -> 4 -> 5], remove 5th from end (1)
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, 5);

        // Expected: [2 -> 3 -> 4 -> 5]
        assertEquals(2, head.val);
        assertEquals(3, head.next.val);
        assertEquals(4, head.next.next.val);
        assertEquals(5, head.next.next.next.val);
        assertNull(head.next.next.next.next);
    }

    @Test
    public void testRemoveNthFromEnd_lastNode() {
        // Setup: List [1 -> 2 -> 3 -> 4 -> 5], remove 1st from end (5)
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, 1);

        // Expected: [1 -> 2 -> 3 -> 4]
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(3, head.next.next.val);
        assertEquals(4, head.next.next.next.val);
        assertNull(head.next.next.next.next);
    }

    @Test
    public void testRemoveNthFromEnd_singleNode() {
        // Setup: List [1], remove 1st from end (1)
        ListNode head = new ListNode(1);

        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, 1);

        // Expected: null (empty list)
        assertNull(head);
    }

    @Test
    public void testRemoveNthFromEnd_twoNodeList_removeFirst() {
        // Setup: List [1 -> 2], remove 2nd from end (1)
        ListNode head = new ListNode(1, new ListNode(2));

        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, 2);

        // Expected: [2]
        assertEquals(2, head.val);
        assertNull(head.next);
    }

    @Test
    public void testRemoveNthFromEnd_twoNodeList_removeSecond() {
        // Setup: List [1 -> 2], remove 1st from end (2)
        ListNode head = new ListNode(1, new ListNode(2));

        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, 1);

        // Expected: [1]
        assertEquals(1, head.val);
        assertNull(head.next);
    }
}
