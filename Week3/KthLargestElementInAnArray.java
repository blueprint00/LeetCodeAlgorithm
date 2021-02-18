package Week3;
import java.util.*;
public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 4, 6, 5};
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}
	public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
