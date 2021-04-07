package April.Week1;

public class DesignCircularQueue {
    public static void main(String[] args){
        // MyCircularQueue obj = new MyCircularQueue(5);
        // boolean param_1 = obj.enQueue(3);
        // boolean param_2 = obj.deQueue();
        // int param_3 = obj.Front();
        // int param_4 = obj.Rear();
        // boolean param_5 = obj.isEmpty();
        // boolean param_6 = obj.isFull();

        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
class MyCircularQueue {

    ListNode head = null, tail = null;
    int maxSize = 0, size = 0;

    public MyCircularQueue(int k) {
        maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        ListNode newNode = new ListNode(value, null);
        if(isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size ++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        head = head.next;
        size --;
        return true;    
    }
    
    public int Front() {
        return isEmpty() ? -1 : head.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}