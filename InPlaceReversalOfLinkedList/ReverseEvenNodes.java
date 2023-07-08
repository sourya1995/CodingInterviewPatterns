package InPlaceReversalOfLinkedList;

public class ReverseEvenNodes {
    public static ListNode reverseEvenNodes(ListNode head){
        ListNode prev = head;
        ListNode node, reverse, nodeNext, curr, prevNext = null;
        int l = 2;
        int n = 0;
        while(prev.next != null){
            node = prev;
            n = 0;
            for(int i = 0; i < l; i++){
                if(node.next == null)
                    break;
                n += 1;
                node = node.next;
            }
            if(n % 2 != 0)
                prev = node;
            else{
                reverse = node.next;
                curr = prev.next;
                for(int j = 0; j < n; j++){
                    nodeNext = curr.next;
                    curr.next = reverse;
                    reverse = curr;
                    curr = nodeNext;
                }
                prevNext = prev.next;
                prev.next = node;
                prev = prevNext;
            }
            l += 1;
            
        }
        return head;
    }
}
