package Week2;

public class CheckIfTwoStringArraysareEquivalent {
	public static void main(String[] args) {
		String[] word1 = {"a", "bc"};
		String[] word2 = {"ab", "c"};
		System.out.println(arrayStringsAreEqual(word1, word2));
	}
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		
		String str1 = "", str2 = "";
		for(String str : word1) {
			str1 += str;
		}
		for(String str : word2) {
			str2 += str;
		}
		
		if(str1.equals(str2)) return true;
		else return false;
    }
}
