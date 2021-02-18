package Week3;

public class GetMaximumInGeneratedArray {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(getMaximumGenerated(n));
	}
	public static int getMaximumGenerated(int n) {
		if(n == 0) return 0;
	    if(n == 1) return 1;
	        
        int[] nums = new int[n + 1];   
        nums[0] = 0;
        nums[1] = 1;
        
        int max = 0;
        for(int i = 2; i <= n; i ++) {
        	if(i % 2 == 0) nums[i] = nums[i / 2];
        	else nums[i] = nums[i / 2] + nums[i / 2 + 1];
        	
    		max = max < nums[i] ? nums[i] : max;
        }
               
        return max;
    }
}
