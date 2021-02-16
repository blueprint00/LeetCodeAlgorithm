package Week2;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(4, l1);
		ListNode l3 = new ListNode(2, l2);
		
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(6, l4);
		ListNode l6 = new ListNode(5, l5);
		
		ListNode ln = new ListNode();
		ln = addTwoNumbers(l3, l6);
		for(int i = 0 ; i < 3 ; i ++) {
			System.out.println(ln.val);
			ln = ln.next;
		}
		
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        
        ListNode tmp = new ListNode(0);
        ListNode ans = tmp;
        
        int size1 = 0, size2 = 0;
        while(l1 != null) {
        	if(size1 == 0) ln1 = new ListNode(l1.val);
        	else ln1 = new ListNode(l1.val, ln1);
        	l1 = l1.next;
        	size1 ++;
        }
        while(l2 != null) {
        	if(size2 == 0) ln2 = new ListNode(l2.val);
        	else ln2 = new ListNode(l2.val, ln2);
        	l2 = l2.next;
        	size2 ++;
        }
        
        int num1 = 0, num2 = 0;
        for(int i = 0; i < size1; i ++) {
        	num1 += (ln1.val * Math.pow(10, i));
        	ln1 = ln1.next;
        }
        for(int i = 0; i < size2; i ++) {
        	num2 += (ln2.val * Math.pow(10, i));
        	ln2 = ln2.next;
        }
        
        int num = num1 + num2; // 807 = 342 + 465
        
        if(num == 0) return tmp;
        while(num > 0) {
        	ListNode l = new ListNode(num % 10);
        	num = num / 10;
        	ans.next = l;
        	ans = ans.next;
        }
        
        return tmp.next; // 7 0 8
    }
}
