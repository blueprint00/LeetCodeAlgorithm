package Week3;

import java.util.*;

public class FindTheMostCompetitiveSubsequence {
	public static void main(String[] args) {
		int[] nums = {2,4,3,3,5,4,9,6};
		int k = 4;
		for(int n : mostCompetitive(nums, k)) {
			System.out.println(n);
		}
	}
	public static int[] mostCompetitive(int[] nums, int k) {
        int[] answer = new int[k];
        Stack<Integer> stack = new Stack<>();
        int elementsToBeRemoved = nums.length - k;
        
        for(int n : nums) {
        	while(!stack.isEmpty() && stack.peek() > n && elementsToBeRemoved > 0) {
        		stack.pop();
        		elementsToBeRemoved --;
        	}
        	stack.push(n);
        }
        
        while(!stack.isEmpty() && elementsToBeRemoved -- > 0) {
        	stack.pop();
        }
        
        for(int i = k - 1; i >= 0; i --) {
        	answer[i] = stack.pop();
        }
        
        return answer;
    }
}
