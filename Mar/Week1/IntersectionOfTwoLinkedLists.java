package Mar.Week1;

public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4); l2.next = l1;
		ListNode l3 = new ListNode(8); l3.next = l2;
		ListNode l4 = new ListNode(1); l4.next = l3;
		ListNode l5 = new ListNode(4); l5.next = l4;
		
		ListNode l6 = new ListNode(1); l6.next = l3;
		ListNode l7 = new ListNode(6); l7.next = l6;
		ListNode l8 = new ListNode(5); l8.next = l7;
		
		int skipA = 2, skipB = 3;
		ListNode l = getIntersectionNode(l5, l8);
		System.out.println(l.val);
		
	}
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int len1 = 0, len2 = 0;
//        ListNode p1 = headA, p2 = headB;
//        if(p1 == null || p2 == null) return null;
//        
//        while(p1 != null) {
//        	len1 ++;
//        	p1 = p1.next;
//        }
//        while(p2 != null) {
//        	len2 ++;
//        	p2 = p2.next;
//        }
//        
//        int diff = Math.abs(len1 - len2);
//        p1 = headA;
//        p2 = headB;
//        int len = 0
//        if(len1 > len2) {
//        	len = len1;
//    		for(int i = 0; i < diff; i ++) p1 = p1.next;
//        } else (len1 < len2) {
//	    	len = len2;
//			for(int i = 0; i < diff; i ++) p2 = p2ß.next;
//        }
//     
//        while(p1 != p2) {
//        	p1 = p1.next;
//        	p2 = p2.next;
//        }
//    	  return p1;
    	
    	while(headA != null) {
    		ListNode tmp = headB;
    		while(tmp != null) {
    			if(tmp == headA) return headA;
    			tmp = tmp.next;
    		}
    		headA = headA.next;
    	}
        
        return null;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}