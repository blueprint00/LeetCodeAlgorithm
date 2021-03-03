package Mar.Week1;
import java.util.*;
public class MissingNumber {
	public static void main(String[] args) {
		int[] nums = {0, 1};
		System.out.println(missingNumber(nums));
	}
	public static int missingNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        int i = 0;
        for(i = 0; i <= nums.length; i ++) {
        	if(!map.containsKey(i)) return i;
        }
        return i;
    }
}
