package Week4;
import java.util.*;
public class DetermineIfTwoStringsAreClose {
	public static void main(String[] args) {
		String word1 = "abc";
		String word2 = "bca";
		System.out.println(closeStrings(word1, word2));
	}
	public static boolean closeStrings(String word1, String word2) {        
        if(word1.length() != word2.length()) return false;
        
        Map<Character, Integer> cnt1 = new HashMap<>();
        Map<Character, Integer> cnt2 = new HashMap<>();

        for(char c : word1.toCharArray()) {
        	cnt1.put(c, cnt1.getOrDefault(c, 0) + 1);
        }
        for(char c : word2.toCharArray()) {
        	cnt2.put(c, cnt2.getOrDefault(c, 0) + 1);
        }
        
        if(!cnt1.keySet().equals(cnt2.keySet())) return false;
        		
        List<Integer> freq1 = new ArrayList<>(cnt1.values());
        List<Integer> freq2 = new ArrayList<>(cnt2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);
        
        return freq1.equals(freq2);
        
    }
}
