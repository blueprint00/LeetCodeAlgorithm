package Mar.Week4;
import java.util.*;
public class ThreeSumWithMultiplicity {
    public static void main(String[] args){
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        System.out.println(threeSumMulti(arr, target));
    }
    public static int threeSumMulti(int[] arr, int target) {
        int answer = 0;
        int MOD = 1_000_000_007;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i ++){
            // We'll try to find the number of i < j < k
            // with arr[j] + arr[k] == T, where T = target - arr[i].
            int T = target - arr[i];
            int j = i + 1, k = arr.length - 1;

            while(j < k){
                if(arr[j] + arr[k] < T) j ++;
                else if(arr[j] + arr[k] > T) k --;
                else if(arr[j] != arr[k]){
                    // We have arr[j] + arr[k] == T.
                    // Let's count "left": the number of arr[j] == arr[j+1] == arr[j+2] == ...
                    // And similarly for "right".
                    int left = 1, right = 1;
                    while(j + 1 < k && arr[j] == arr[j + 1]){
                        left ++;
                        j ++;
                    }
                    while(k - 1 > j && arr[k] == arr[k - 1]){
                        right ++;
                        k --;
                    }

                    answer += left * right;
                    answer %= MOD;
                    j ++; k --;
                } else {
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    answer += (k - j + 1) * (k - j) / 2;
                    answer %= MOD;
                    break;
                }
            }
        }
        return answer;

        // for(int i = 0; i < arr.length - 2; i ++){
        //     for(int j = i + 1; j < arr.length - 1; j ++){
        //         for(int k = j + 1; k < arr.length; k ++){
        //             if(arr[i] + arr[j] + arr[k] == target) answer ++; 
        //         }
        //     }
        // }
        // return answer % MOD;
    }
}