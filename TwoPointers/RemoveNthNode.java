public class RemoveNthNode {
    public static ListNode removeNthNode(ListNode head, int n){
        ListNode right = head;
        ListNode left = head;

        for(int i = 0; i < n; i++){
            right = right.next;
        }

        if(right == null){
            return head.next;
        }

        while(right.next != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return head;
    }
}
