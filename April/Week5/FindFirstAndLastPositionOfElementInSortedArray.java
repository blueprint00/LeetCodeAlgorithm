package April.Week5;
import java.util.*;
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 8, 9, 10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }
    public static int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        if(list.size() >= 2) return new int[] {list.get(0), list.get(list.size() - 1)};
        if(list.size() == 1) return new int[] {list.get(0), list.get(0)};
        return new int[] {-1, -1};
    }
}