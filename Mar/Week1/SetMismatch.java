package Mar.Week1;
import java.util.*;
public class SetMismatch {
	public static void main(String[] args) {
		int[] nums = {1, 3, 3};
		for(int i : findErrorNums(nums))
			System.out.println(i);
	}
	public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int[] answer = new int[2];
        for(int i = 1; i <= nums.length; i ++) {
        	if(!map.containsKey(i)) answer[1] = i;
        	else if(map.get(i) > 1) {
        		answer[0] = i;
        	}
        }
        return answer;
    }
}
