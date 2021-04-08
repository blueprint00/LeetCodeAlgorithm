package April.Week2;
import java.util.*;
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args){
        String digits = "23";
        for(String str : letterCombinations(digits)){
            System.out.println(str);
        }
    }
    static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void combination(String prefix, String digits, int offset, List<String> ret){
        if(offset >= digits.length()){
            ret.add(prefix);
            return ;
        }

        String str = mapping[digits.charAt(offset) - '0'];
        for(int i = 0; i < str.length(); i ++){
            combination(prefix + str.charAt(i), digits, offset + 1, ret);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits.length() == 0) return ret;

        combination("", digits, 0, ret);

        return ret;
    }
}