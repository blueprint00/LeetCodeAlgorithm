package Mar.Week3;
import java.util.*;
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args){
        int[] prices = {1, 3, 7, 5, 10, 3};//1, 3, 2, 8, 4, 9};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n < 2) return 0;

        int buy = -prices[0] - fee;
        int sell = 0;

        for(int i = 1; i < n; i ++){
            int lastBuy = buy;
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, lastBuy + prices[i]);
        }
        return sell;
        // int[] buy = new int[n];
        // int[] sell = new int[n];
        // buy[0] = -prices[0] - fee;

        // for(int i = 1; i < n; i ++){
        //     buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);
        //     sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        // }
        // return sell[n - 1];
    }
}