package Week1;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
		if (s.isEmpty()) return 0; 
		int result = 1; 
		int i = 0, j = 1; 
		Set<Character> set = new HashSet<>(); 
		while (i < s.length() && j < s.length()) { 
			if (!set.contains(s.charAt(j)) && s.charAt(i) != s.charAt(j)) { 
				set.add(s.charAt(j)); 
				result = Math.max(result, j - i + 1); 
				j += 1; 
			} else { 
				set = new HashSet<>(); 
				i ++; 
				j = i + 1; 
			}
		} 
		
		return result;


//		LinkedHashSet<Character> set = new LinkedHashSet<>();
//        for(char c : s.toCharArray()) {
//        	set.add(c);
//        }
//        
//        String str = "";
//        for(Object c : set.toArray()) {
//        	str += c;
//        	if(!s.contains(str)) {
//        		str = str.substring(1);
//        	}
//        }
//        
//        return str.length();
    }
}
