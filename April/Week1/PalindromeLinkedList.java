package April.Week1;

public class PalindromeLinkedList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode head = new ListNode(1, l3);

        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        StringBuffer sb = new StringBuffer();

        while(head != null){
            sb.append(String.valueOf(head.val));
            head = head.next;
        }        
        return sb.toString().equals(sb.reverse().toString());
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}