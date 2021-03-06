package Mar.Week1;
import java.util.*;
public class AverageOfLevelsInBinaryTree {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		
		t1.left = t2; t1.right = t3;
		t3.left = t4; t2.right = t5;
		for(double d : averageOfLevels(t1)) {
			System.out.println(d);
		}
		
	}
		
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        if(root == null) return answer;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	double sum = 0;
        	for(int i = 0; i < size; i ++) {
        		TreeNode node = q.poll();
        		sum += node.val;
        		if(node.left != null) q.add(node.left);
        		if(node.right != null) q.add(node.right);
        	}
        	answer.add(sum / size);
        }
        
        return answer;
    }
	
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}