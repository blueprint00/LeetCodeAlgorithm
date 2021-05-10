package May.Week2;

public class CountPrimes {
    public static void main(String[] args){
        int n = 10;
        System.out.println(countPrimes(n));
    }
    public static int countPrimes(int n) {
        int[] num = new int[n];
        int cnt = 0;
        for(int i = 2; i < n; i ++)
            num[i] = i;

        for(int i = 2; i < n; i ++){
            if(num[i] == 0) continue;
            cnt ++;
            for(int j = i + i; j < n; j += i){
                num[j] = 0;
            }
        }
        return cnt;
    }
}