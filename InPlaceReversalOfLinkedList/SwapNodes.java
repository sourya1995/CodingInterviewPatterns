package InPlaceReversalOfLinkedList;

public class SwapNodes {
    public static void swap(ListNode node1, ListNode node2){
        int temp = node1.data;
        node1.data = node2.data;
        node1.data = temp;
    }

    public static ListNode swapNodes(ListNode head, int k){
        if(head == null) {
            return head;
        }
        int count = 0;

        ListNode front = null;
        ListNode end = null;
        ListNode curr = head;

        while(curr != null){
            count+=1;

            if(end != null){
                end = end.next;
            }

            if(count == k){
                front = curr;
                end = head;
            }

            curr = curr.next;
        }
        swap(front, end);
        return head;
    }
}
