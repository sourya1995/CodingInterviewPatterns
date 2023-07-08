package InPlaceReversalOfLinkedList;

public class ReversKGroups {
    public static void reverseKGroups(ListNode head, int k) {
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
                if (tracker != null) {
                    System.out.println(tracker.data);
                } else {
                    System.out.print("");
                }
            }

            if (tracker == null) {
                break;
            } else {
                System.out.println("the nodes can be reversed");
            }

            ptr = tracker;

        }
    }
}
