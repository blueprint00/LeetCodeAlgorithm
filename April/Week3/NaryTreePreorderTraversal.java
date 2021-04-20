package April.Week3;
import java.util.*;
public class NaryTreePreorderTraversal {
    public static void main(String[] args){
    
    }
    public static void preorderHelper(Node root, List<Integer> answer){
        if(root == null) return ;

        answer.add(root.val);
        for(Node n : root.children){
            preorderHelper(n, answer);
        }
    }
    public static List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        preorderHelper(root, answer);
        // Stack<Node> deq = new Stack<>();
        // deq.add(root);
        // while(!deq.isEmpty()){
        //     Node node = deq.pop();
        //     answer.add(node.val);
        //     if(node.children != null){
        //         Collections.reverse(node.children);
        //         for(Node n : node.children){
        //             deq.push(n);
        //         }
        //     }
        // }
        return answer;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}