package April.Week2;
import java.util.*;
public class DeepestLeavesSum {
    public static void main(String[] args){
    }
    static int sum = 0;
    static int maxLevel = 0;
    public static void dfs(TreeNode node, int level){
        if(level > maxLevel){
            sum = 0;
            maxLevel = level;
        }

        if(level == maxLevel){
            sum += node.val;
        }

        if(node.left != null){
            dfs(node.left, level + 1);
        }
        if(node.right != null){
            dfs(node.right, level + 1);
        }

    }
    public static int deepestLeavesSum(TreeNode root) {
        int level = 0;
        if(root != null){
            dfs(root, level);
        }
        return sum;
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