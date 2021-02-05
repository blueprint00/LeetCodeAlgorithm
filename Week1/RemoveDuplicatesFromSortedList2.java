package Week1;
import java.util.*;
public class RemoveDuplicatesFromSortedList2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4, l1);
		ListNode l3 = new ListNode(4, l2);
		ListNode l4 = new ListNode(3, l3);
		ListNode l5 = new ListNode(3, l4);
		ListNode l6 = new ListNode(2, l5);
		ListNode l = new ListNode(1, l6);
		
		ListNode node = deleteDuplicates(l);
		while(true) {
			System.out.println(node.val);
			node = node.next;
			if(node == null) break;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode node = new ListNode(0);
		node.next = head;
		
		ListNode p = node;
		while(p.next != null && p.next.next != null) {
			if(p.next.val == p.next.next.val) {
				int dup = p.next.val;
				while(p.next != null && p.next.val == dup) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}
		}
		
//		int cnt = 0;
//		int min = head.val;
//		while(head.next != null) {
//			int tmp = head.val;
//			if(head.next == null) head.val = min;
//			
//			if(tmp == head.val) {
//				cnt ++;
//			} else {
//				if(cnt == 0) {
//					ans.next = new ListNode(tmp);
//					ans = ans.next;
//					System.out.println(tmp);
//				} else {
//					head = head.next;
//					cnt = 0;
//				}
//			}
//			
//		}
		return node.next;
    }
}
class ListNode {
	int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}