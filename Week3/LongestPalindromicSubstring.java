package Week3;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
	public static String longestPalindrome(String s) {	
		if(s.length() == 0) return "";
		
		int left = 0, right = 0;
        for(int i = 0; i < s.length(); i ++) {
        	int len1 = expandAroundCenter(s, i, i);
        	int len2 = expandAroundCenter(s, i, i + 1);
        	int len = Math.max(len1, len2);
        	if(len > right - left) {
        		left = i - (len - 1) / 2;
        		right = i + len / 2;
        	}
        }
        return s.substring(left, right + 1);
    }
	public static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L --;
			R ++;
		}
		return R - L - 1;
	}
}