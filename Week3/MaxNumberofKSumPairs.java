package Week3;
import java.util.*;
public class MaxNumberofKSumPairs {
	public static void main(String[] args) {
		int[] nums = {3, 1, 3, 2, 3};//4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
		int k = 6; //2;
		System.out.println(maxOperations(nums, k));
	}
	public static int maxOperations(int[] nums, int k) {
		//using Sort
		int answer = 0;
		Arrays.sort(nums);
		int i, j;
		for(i = 0, j = nums.length - 1; i < nums.length && j >= 0; ) {
			if(j <= i) break;
			
			if(nums[i] + nums[j] == k) {
				i ++;
				j --;
				answer ++;
			} else if(nums[i] + nums[j] > k) {
				j --;
			} else i ++;
		}
		return answer;
		
		
		//?????? using Map
//		Map<Integer, Integer> map = new HashMap<>();
//		for(int i : nums) {
//			if(map.containsKey(i))
//				map.put(i, map.get(i) + 1);
//			else map.put(i, 1);
//		}
//		
//		int answer = 0;
//		for(int i = 0; i < nums.length; i ++) {
//			if(nums[i] > k) continue;
//		
//			int second_num = k - nums[i];
//			int value = map.get(nums[i]);
//			map.put(nums[i], value - 1);
//			
//			if(!map.containsKey(second_num) || map.get(second_num) <= 0) continue;
//			
//			int value2 = map.get(second_num);
//			map.put(nums[i], value2 - 1);
//			
//			if(value <= 0 || value2 <= 0) continue;
//			answer ++;			
//		}
//		
//		return answer;
		
//        int answer = 0;
//        
//        List<Integer> arr = new ArrayList<>();
//		for(int n : nums) arr.add(n);
//        
//		int idx = 0;
//		while(idx < arr.size()){
//			int n = arr.get(idx);
//			if(arr.contains(k - n) && idx != arr.indexOf(k - n)) {
//				arr.remove(idx);
//				arr.remove(arr.indexOf(k - n));
//				answer ++;
//			} else {
//				idx ++;
//			}
//		}
//        
//		return answer;
    }
}