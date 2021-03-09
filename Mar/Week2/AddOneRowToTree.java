package Mar.Week2;

public class AddOneRowToTree {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(6); t1.left = t2; t2.right = t3;
		TreeNode t4 = new TreeNode(3); t2.left = t4;
		TreeNode t5 = new TreeNode(1); t2.right = t5;
		TreeNode t6 = new TreeNode(5); t3.left = t6;
		
		int v = 1, d = 2;
		
		
	}
	public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
        	TreeNode t = new TreeNode(v);
        	t.left = root;
        	return t;
        }
        
        helper(root, v, d, 1);
        return root;
    }
	
	public static void helper(TreeNode root, int v, int d, int curLevel) {
		if(curLevel == d - 1) {
			TreeNode t1 = new TreeNode(v);
			TreeNode t2 = new TreeNode(v);
			
			t1.left = root.left;
			t2.right = root.right;
			root.left = t1;
			root.right = t2;
		}
		
		if(root.left != null) helper(root.left, v, d, curLevel + 1);
		if(root.right != null) helper(root.right, v, d, curLevel + 1);
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