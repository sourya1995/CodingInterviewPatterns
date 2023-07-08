package InPlaceReversalOfLinkedList;

public class ReverseLinkedList {
    public static ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
