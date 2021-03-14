package Mar.Week2;
import java.util.*;
public class BinaryTreesWithFactors {
    public static void main(String[] args){
        int[] arr = {2, 4};
        System.out.println(numFactoredBinaryTrees(arr));
    }
    public static int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        int N = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < N; i ++) index.put(arr[i], i);

        for(int i = 0; i < N; i ++){
            for(int j = 0; j < i; j ++){
                if(arr[i] % arr[j] == 0) { // A[j] is left child
                    int right = arr[i] / arr[j];
                    if(index.containsKey(right)){
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        }

        long answer = 0;
        for (long l : dp) answer += l;
        return (int) (answer % MOD);
    }
}