package Week1;

public class MergeTwoSortedLists {
	
	//Definition for singly-linked list.
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		ListNode l4 = new ListNode(4);
		ListNode l_2t = new ListNode(2, l4);
		ListNode l2 = new ListNode(1, l_2t);
		
		ListNode l3 = new ListNode(3);
		ListNode l_1t = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l_1t);

		ListNode l = mergeTwoLists(l1, l2);
		while(true) {
			System.out.println(l.val);
			l = l.next;
			if(l == null) break;
		}
		
	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	
    	ListNode tmp = new ListNode(0);
        ListNode ans = tmp;
        
        while(l1 != null && l2 != null) {
        	if(l1.val > l2.val) {
        		ans.next = l2;
        		l2 = l2.next;
        	} else {
        		ans.next = l1;
        		l1 = l1.next;
        	}
        	ans = ans.next;
        }
        
        if(l1 == null) ans.next = l2;
    	if(l2 == null) ans.next = l1;
            	
        return tmp.next;
    }
}


