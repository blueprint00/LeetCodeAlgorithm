package Mar.Week2;
import java.util.*;
public class RemovePalindromicSubsequences {
	public static void main(String[] args) {
		String s = "abbab";
		System.out.println(removePalindromeSub(s));
	}
	public static int removePalindromeSub(String s) {
		if(s.length() == 0) return 0;
		return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
//		List<Character> ch = new ArrayList<>();
//		for(char c : s.toCharArray()) ch.add(c);
//		
//		int cnt = 0;
//		int left = 0;
//    	int right = ch.size() - 1;
//		while(ch.size() > 0) {
//			if(right <= 0) break;
//        	while(ch.get(left) == ch.get(right)) {
//        		System.out.println(ch.size() + " " + right);
//        		ch.remove(right);
//        		ch.remove(left);
//    			right -= 2;
//    			if(left >= right) break;
//        	}
//        	right --;
//        	cnt ++;
//        }
//		
//		return cnt;
    }
}
