package SlowAndFastPointers;

public class PalindromeLinkedList {

    public static boolean palindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revertData = LinkedListReversal.reverseLinkedList(slow);
        boolean check = compareTwoHalves(head, revertData);
        revertData = LinkedListReversal.reverseLinkedList(revertData);
        if(check){
            return true;
        }
        return false;
    }
    public static boolean compareTwoHalves(ListNode firstHalf, ListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if(firstHalf.data != secondHalf.data){
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }
        return true;
    }
}
