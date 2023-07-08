package KWayMerge;

import java.util.LinkedList;
import java.util.List;

public class MergeKLists {
    	public static LinkedListNode merge2Lists(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode dummy = new LinkedListNode(-1);
		LinkedListNode prev = dummy; // set prev pointer to dummy node
		// traverse over the lists until both or one of them becomes null
		while (head1 != null && head2 != null) {
			// if l1 value is<=  l2 value, add l1 node to the list
			if (head1.data<= head2.data) {
				prev.next = head1;
				head1 = head1.next;
			} else {
				// if l1 value is greater than l2 value, add l2 node to the list
				prev.next = head2;
				head2 = head2.next;
			}
			prev = prev.next;
		}

		if (head1 == null)
			prev.next = head2;
		else
			prev.next = head1;

		return dummy.next;
	}

	// Main function
	public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        int temp = 0;
		if (lists.size() > 0) {
            int step = 1;
            while(step < lists.size())
            {
                //temp = step;
                for(int i = 0; i < lists.size() - step;  i += step * 2)
                {
                    lists.get(i).head =  merge2Lists(lists.get(i).head, lists.get(i + step).head);
                }
                step *= 2;
            }
			return lists.get(0).head;
        }
		else
		    return null;
		
	}
}
