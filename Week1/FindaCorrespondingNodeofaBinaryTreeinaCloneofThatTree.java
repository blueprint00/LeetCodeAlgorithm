package Week1;
import java.util.*;
import javax.swing.tree.TreeNode;

public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {
	// Definition for a binary tree node.
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static Stack<Character> getPath(TreeNode original, TreeNode target){
		if(original == null) return null;
		if(original == target) {
			Stack<Character> ans = new Stack<>();
			ans.push('c');
			return ans;
		}
		
		//if not target node
		//search left tree
		Stack<Character> left = getPath(original.left, target);
		if(left != null) {
			left.push('l');
			return left;
		}
		
		//search right tree
		Stack<Character> right = getPath(original.right, target);
		if(right != null) {
			right.push('r');
			return right;
		}
		
		return null;
	}
	
    public final TreeNode traversePath(TreeNode node, Stack<Character> path){
    	if(node == null || path.size() <= 0 || path == null || path.pop() == 'c') return null;
    	
    	char c = path.pop();
    	switch(c) {
	    	case 'l' : return traversePath(node.left, path);
	    	case 'r' : return traversePath(node.right, path);
    	}
    	
    	return node;
    }	
	
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    	Stack<Character> path = getPath(original, target);
    	return traversePath(cloned, path);
    }
	
	/*
	//first method to store the path by traversing the original tree
    public static Stack<Character> getPath(TreeNode original, TreeNode target){
        //base case - if tree null at any recursion then target cannot be found so no path
        if(original==null)
            return null;
        
        //if target found, then create a stack and store 'c' to represent this is target node
        if(original==target){
            Stack<Character> ans = new Stack<Character>();
            ans.push('c');
            return ans;
        }
        
        //if not target node
        //search left tree 
        Stack<Character> left = getPath(original.left, target);
        //if left stack is null then target node not in left sub tree
        if(left!=null){
            //if not null then target in left sub tree of current node, so push 'l'
            left.push('l');
            //return the path to parent node
            return left;
        }
        //only checked if node not in left sub tree
        //if right stack is null then target node not in right sub tree
        Stack<Character> right = getPath(original.right, target);
        if(right!=null){
            //push r for second case
            right.push('r');
            return right;
        }
        
        //if node not in both left and right subtree then return no path to parent
        return null;
    }
    public final TreeNode traversePath(TreeNode node, Stack<Character> path){
        //handle all base cases
        if(node==null || path.size()<=0 || path==null || path.peek()=='c')
            return node;
        //find direction for next recursion
        Character c = path.pop();
        
        //case 1
        if(c=='l'){
            return traversePath(node.left, path);
        }
        //case 2
        else if(c=='r'){
            return traversePath(node.right, path);
        }
        
        return node;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //get path in original array
        Stack<Character> path = getPath(original, target);
        //traverse path in cloned array
        return traversePath(cloned, path);
    }
    */
}
