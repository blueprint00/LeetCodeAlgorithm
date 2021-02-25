package Week4;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
	public static void main(String[] args) {
		int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
		int k = 2;
		System.out.println(kLengthApart(nums, k));
	}
	public static boolean kLengthApart(int[] nums, int k) {
		int cnt = k;
        for(int num : nums) {
        	if(num == 1) {
        		if(cnt < k) return false;
        		cnt = 0;
        	}
        	else cnt ++;
        }
        return true;
    }
}
