package April.Week1;

public class OnesAndZeroes {
    public static void main(String[] args){
        String[] strs = {"10","0001","111001","1","0"};
        int m = 4;
        int n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int zeros = 0, ones = 0;
            for(char c : str.toCharArray()){
                if(c == '0') zeros ++;
                else ones ++;
            }
            for(int i = m; i >= zeros; i --){
                for(int j = n; j >= ones; j --){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
        
        // int answer = 0;
        // for(String str : strs){
        //     int cnt0 = 0, cnt1 = 0;
        //     for(char ch : str.toCharArray()){
        //         if(ch == '0') cnt0 ++;
        //         else cnt1 ++;
        //     }
        //     if(cnt0 < m && cnt1 < n) answer ++;
        //     else if(cnt0 == 0 && cnt1 <= n) answer ++;
        //     else if(cnt1 == 0 && cnt0 <= m) answer ++;
        // }
        // return answer;
    }
}