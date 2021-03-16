package Mar.Week2;

public class SwappingNodesInALinkedList {
    public static void main(String[] args){
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(9, l1);
		ListNode l3 = new ListNode(0, l2);
		ListNode l4 = new ListNode(3, l3);
		ListNode l5 = new ListNode(8, l4);
		ListNode l6 = new ListNode(7, l5);
		ListNode l7 = new ListNode(6, l6);
		ListNode l8 = new ListNode(5, l7);
		ListNode l9 = new ListNode(9, l8);
		ListNode l10 = new ListNode(7, l9);
		int k = 5;

		ListNode head = l10;
		ListNode l = swapNodes(head, k);
		// while(l != null){
		// 	System.out.println(l.val);
		// 	l = l.next;
		// }
	}

	public static ListNode swapNodes(ListNode head, int k) {
		if(head.next == null) return head;

		ListNode curr = head;
		int cnt = 1;
		int size = 0;

		while(curr != null){
			curr = curr.next;
			size ++;
		}

		curr = head;
		ListNode prevNode1 = null;
		ListNode prevNode2 = null;
		while(curr != null && curr.next != null){
			if(cnt == k - 1) { // 바꿀 첫 번째 노드 전
				prevNode1 = curr;
				System.out.println(curr.val);
			}
			if(cnt == size - k){ // 바꿀 두 번째 노드 전
				prevNode2 = curr;
				System.out.println(curr.val);
				break;
			}
			curr = curr.next;
			cnt ++;
		}

		// swapping
		ListNode node1 = prevNode1.next; // 바꿀 첫 번째 노드
		ListNode node2 = prevNode2.next; // 바꿀 두 번째 노드
		System.out.println("1 " + node1.val);
		System.out.println("2 " + node2.val);

		ListNode node1Next = node1.next; // 첫 번쨰 노드의 다음 노드
		System.out.println("1 next " + node1Next.val);
		ListNode node2Next = node2.next;; // 두 번째 노드의 다음 노드
		System.out.println("2 next " + node2Next.val);

		if(size - k - (k - 1) == 1) { // 두 노드가 이어져 있을 때
			prevNode1.next = node2;
			prevNode2.next = node1;
			System.out.println("prev1 next " + prevNode1.next.val);
			System.out.println("prev2 next " +prevNode2.next.val);

		} else {
			prevNode1.next = node2;
			prevNode2.next = node1;
			System.out.println("prev1 next " + prevNode1.next.val);
			System.out.println("prev2 next " +prevNode2.next.val);
		}
		node1.next = node2Next;
		node2.next = node1Next;
		System.out.println("1 next " + node1.next.val);
		System.out.println("2 next " + node2.next.val);

		return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}