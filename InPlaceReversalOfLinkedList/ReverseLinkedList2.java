package InPlaceReversalOfLinkedList;

public class ReverseLinkedList2 {
    public static ListNode reverse(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        while (right >= left) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode lpn = null;
        ListNode right_n = null;
        ListNode reverse_head = null;

        int count = 1;
        while (count < left && curr != null) {
            lpn = curr;
            curr = curr.next;
            count++;
        }

        if (curr != null) {
            ListNode rpn = curr;
            while (count <= right && rpn != null) {
                right_n = rpn;
                rpn = right_n.next;
                count++;
            }

            if (right_n != null) {
                reverse_head = reverse(curr, left, right);
            }
            if (lpn != null) {
                lpn.next = reverse_head;
            }
            if (rpn != null) {
                ListNode temp = reverse_head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = rpn;
            }
        }

        if (lpn != null) {
            return head;
        } else {
            return reverse_head;
        }
    }
}
