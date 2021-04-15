package April.Week2;

public class BeautifulArrangement2 {
    public static void main(String[] args){
        int n = 3;
        int k = 2;

        for(int i : constructArray(n, k)) System.out.println(i);
    }
    public static int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int c = 0;
        for(int v = 1; v < n - k; v ++){
            answer[c ++] = v;
        }
        for(int i = 0; i <= k; i ++){
            answer[c ++] = (i % 2 == 0) ? (n - k + i / 2) : (n - i / 2);
        }
        return answer;
    }
}