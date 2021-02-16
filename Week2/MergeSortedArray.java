package Week2;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = {2, 5, 6};
		int n = 3;
		
		merge(nums1, m, nums2, n);
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] rst = new int[m + n];
		Arrays.sort(nums1);
		
		int idx = 0, idx1 = 0, idx2 = 0;
		while(idx < m + n) {
        	if(idx1 < m + n && nums1[idx1] == 0) {
        		idx1 ++;
        		continue;
        	}
        	
        	if(nums1[idx1] <= nums2[idx2]) rst[idx ++] = nums1[idx1 ++];
        	else rst[idx ++] = nums2[idx2 ++];
        	
        	
        }
        
        for(int r : rst) System.out.println(r + ",");
    }
}
