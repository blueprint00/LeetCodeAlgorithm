package Week4;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
	public static void main(String[] args) {
		int n = 5;
		int k = 73;
		System.out.println(getSmallestString(n, k));
	}
	
	public static String getSmallestString(int n, int k) {
		// a ~ z = 26
        char[] ch = new char[n];
        Arrays.fill(ch,  'a');
        
        // Iterator from the last position in the array
        for(int i = n - 1; i >= 0; i --) {
        	k -= i;
        	
        	if(k >= 0) {
        		if(k >= 26) {
        			ch[i] = 'z';
        			k -= 26;
        		} else {
        			ch[i] = (char)(k + 'a' - 1);
        			k -= ch[i] - 'a' + 1;
        		}
        	} else break;
        	
        	k += i;
        }
        
        return new String(ch);
    }
}
