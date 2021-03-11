package Mar.Week2;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}
	public static int coinChange(int[] coins, int amount) {
		if(amount == 0) return 0;
		
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i <= amount; i ++) {
			for(int coin : coins) {
				if(i == coin) dp[i] = 1;
				else if(i > coin) {
					if(dp[i - coin] == Integer.MAX_VALUE) continue;
					dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
				}
			}
		}
		
		if(dp[amount] == Integer.MAX_VALUE) return -1;
		return dp[amount];
	}
}