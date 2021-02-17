package Week2;

import java.util.*;

public class MinimumOperationsToReduceXToZero {
	public static void main(String[] args) {
		int[] nums = {500, 1, 1, 4, 2, 3};
		int x = 500;
		System.out.println(minOperations(nums, x));
	}
	public static int minOperations(int[] nums, int x) {
        int answer = Integer.MAX_VALUE;
                
        int sum = 0, cnt = 0;
        int left = 0, right = nums.length - 1;  
        
        while(right >= 0 && sum < x) {
        	sum += nums[right];
        	right --;
        	cnt ++;
        }
		if(sum == x && cnt < answer) answer = cnt;
        
        if(right > -1) {
        	while(right < nums.length -1) {
        		right ++;
        		sum -= nums[right];
        		cnt --; 
        		while(left < right && sum < x) {
        			sum += nums[left];
        			left ++;
        			cnt ++;
        		}
        		if(left == nums.length) break;
        		if(sum == x && cnt < answer) answer = cnt;
        	}
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
