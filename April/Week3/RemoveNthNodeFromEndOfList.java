package April.Week3;

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null, curr = head;
        int size = 0;
        ListNode tmp = head;
        while(tmp != null){
            size ++;
            tmp = tmp.next;
        }
        if(size == 1) return null;
        
        for(int i = 0; i < size - n; i ++){
            prev = curr;
            curr = curr.next;
        }
        if(prev != null) prev.next = curr.next;
        else head = head.next;
        
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