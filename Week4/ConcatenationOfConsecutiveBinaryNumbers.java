package Week4;

public class ConcatenationOfConsecutiveBinaryNumbers {
	public static void main(String[] args) {
		int n = 42;
		System.out.println(concatenatedBinary(n));
	}
	public static int concatenatedBinary(int n) {
//		String str = "";
//        for(int i = 1; i <= n; i ++) {
//        	String tmp = Integer.toBinaryString(i);
//        	str += tmp;
//        }
//        System.out.println(str);
//        
//        int answer = 0;
//        for(int i = 0; i < str.length(); i ++) {
//        	int tmp = Integer.parseInt(str.substring(i, i + 1));
//        	answer += tmp * Math.pow(2, i);
//        }
//           
//        if(answer >= Math.pow(10, 9) + 7) answer %= Math.pow(10, 9) + 7;
		long ans = 0;
		int digits = 0;
		int mod = 1_000_000_007;
		for(int i = 1; i <= n; i ++){
			if((i & i - 1) == 0) ++ digits;
			
			ans = ((ans << digits) | i) % mod;
		}
    	return (int) ans;
    }
}
