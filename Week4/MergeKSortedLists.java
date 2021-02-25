package Week4;
import java.util.*;
public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		ListNode l0 = new ListNode(6);
		ListNode l1 = new ListNode(2, l0);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3, l2);
		ListNode l4 = new ListNode(1, l3);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(4, l5);
		ListNode l7 = new ListNode(1, l6);
		lists[0] = l7;
		lists[1] = l4;
		lists[2] = l1;
		
		ListNode l = new ListNode();
		for(ListNode ln : lists) {
        	while(ln != null){
        		System.out.print(ln.val);
        		ln = ln.next;
        	}System.out.println();
        }
		
		ListNode ll = mergeKLists(lists);
		while(ll != null) {
			System.out.println(ll.val);
			ll = ll.next;
		}
	}
	public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode ln : lists) {
        	while(ln != null) {
        		list.add(ln.val);
        		ln = ln.next;
        	}
        }
        
        Collections.sort(list);
        
        ListNode tmp = new ListNode(0);
        ListNode l = tmp;
        
        int idx = 0;
        while(idx < list.size()) {
        	l.next = new ListNode(list.get(idx ++));
        	l = l.next;
        }
        return tmp.next;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}