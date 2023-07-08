package InPlaceReversalOfLinkedList;

public class SwapPairs {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head; //connects dummy node to original list

        while(head != null && head.next != null){
            ListNode firstNode = head; //first node in pair
            ListNode secondNode = head.next; //second node in pair

            //swapping
            prev.next = secondNode; //connects previous node to second node
            firstNode.next = secondNode.next; //connects first node to node after second node
            secondNode.next = firstNode; //connects second node to first node

            prev = firstNode; //move prev to next pair
            head = firstNode.next;
        }

        return dummy.next;
    }
}

