package Week3;

import java.util.Arrays;

public class CountSortedVowelStrings {
	public static void main(String[] args) {
		int n = 1;
		System.out.println(countVowelStrings(n));
	}
	public static int countVowelStrings(int n) {
		int[][] cache = new int[52][5];
		cache[1] = new int[] {1, 1, 1, 1, 1}; //5
		cache[2] = new int[] {5, 4, 3, 2, 1}; // 15
		cache[3][0] = 15; //sum(dp[2])
		
		for(int i = 3; i <= n; i ++) {
			int sum = 0;
			for(int j = 0; j < 5; j ++) {
				if(j == 0) {
					sum += cache[i][j];
					continue;
				}
				cache[i][j] = cache[i][j - 1] - cache[i - 1][j - 1];
				sum += cache[i][j];
			}
			cache[i + 1][0] = sum;
		}
		return cache[n + 1][0];
		
//        int[] dp = new int[5];
//        Arrays.fill(dp, 1);
//        
//        for(int i = 2; i <= n; ++ i) {
//        	int[] newDp = new int[5];
//        	for(int j = 0; j < 5; j ++) {
//        		for(int k = 0; k <= j; k ++) {
//        			newDp[j] += dp[k];
//        		}
//        	}
//        	dp = newDp;
//        }
//        
//        return Arrays.stream(dp).sum();
    }
}
