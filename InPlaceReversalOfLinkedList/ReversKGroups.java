package InPlaceReversalOfLinkedList;

public class ReversKGroups {
    public static ListNode reverseKGroups(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr != null) {
            ListNode tracker = ptr;

            for (int i = 0; i < k; i++) {
                if (tracker == null) {
                    break;
                }
                tracker = tracker.next;
               
            }

            if (tracker == null) {
                break;
            } 

            ListNode[] updatedNodes = ReverseLinkedList.Reverse(ptr.next, k);
            ListNode previous = updatedNodes[0];
            ListNode current = updatedNodes[1];
            ListNode lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = current;
            ptr.next = previous;
            ptr = lastNodeOfReversedGroup;


        }

        return dummy.next;
    }
}
