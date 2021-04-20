package April.Week3;
import java.util.*;
public class CombinationSum4 {
    public static void main(String[] args){
        int[] nums = {2, 1, 3};
        int target = 35;
        System.out.println(combinationSum4(nums, target));
    }
    public static int combinationSum4(int[] nums, int target) {
        // int answer = 0;
        // if(target == 0) return 1;
        // for(int i = 0; i < nums.length; i ++){
        //     if(target >= nums[i])
        //         answer += combinationSum4(nums, target - nums[i]);
        // }
        // return answer;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i ++){
            for(int num : nums){
                if(num <= i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}