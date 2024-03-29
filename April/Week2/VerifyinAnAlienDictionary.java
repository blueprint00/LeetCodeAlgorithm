package April.Week2;

import java.util.*;

public class VerifyinAnAlienDictionary {
    public static void main(String[] args){
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i ++){
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i ++){
            if(!verifyHelper(words[i], words[i + 1], map)){
                return false;
            }
        }
        return true;
    }

    private static boolean verifyHelper(String s1, String s2, Map<Character, Integer> map){
        int idx1 = 0, idx2 = 0;
        while(idx1 < s1.length() && idx2 < s2.length()){
            if(map.get(s1.charAt(idx1)) < map.get(s2.charAt(idx2))){
                return true;
            }
            if(map.get(s1.charAt(idx1)) > map.get(s2.charAt(idx2))){
                return false;
            }
            idx1 ++;
            idx2 ++;
        }
        return s1.length() <= s2.length();
    }
}