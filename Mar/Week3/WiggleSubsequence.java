package Mar.Week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WiggleSubsequence {
    public static void main(String[] args){
        int[] nums = {3, 3, 3, 2, 5};//0, 0, 0};//1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
    }

    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums.length;
        
        int answer = 1;

        for(int i = 1, j = 0; i < nums.length; j = i, i ++){
            if(nums[j] < nums[i]){
                answer ++;
                while(i < nums.length - 1 && nums[i] <= nums[i + 1]) i ++;
            } else if(nums[j] > nums[i]) {
                answer ++;
                while(i < nums.length - 1 && nums[i] >= nums[i + 1]) i ++;
            }
        }
        return answer;
        // List<Integer> wiggle = new ArrayList<>();
        // wiggle.add(nums[0]);
        // if(nums[1] != nums[0]) wiggle.add(nums[1]);
        
        // int diff = nums[1] - nums[0];
        // int idx = wiggle.size() - 1;
        // for(int i = 2; i < nums.length; i ++){
        //     if(diff < 0){
        //         if(nums[i] - wiggle.get(idx) > 0){
        //             diff = nums[i] - wiggle.get(idx);
        //             idx ++;
        //             wiggle.add(nums[i]);
        //         }
        //     } else if(diff > 0) {
        //         if(nums[i] - wiggle.get(idx) < 0){
        //             diff = nums[i] - wiggle.get(idx);
        //             idx ++;
        //             wiggle.add(nums[i]);
        //         }
        //     }
        // }
        // return wiggle.size();
    }
}