package Mar.Week2;
import java.util.*;
public class CheckIfStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args){
        String s = "0110";
        int k = 2;
        System.out.println(hasAllCodes(s,k));
    }
    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<String>();

        for(int i = k; i <= s.length(); i ++){
            String a = s.substring(i - k, i);
            if(!got.contains(a)){
                got.add(a);
                need --;
                // return true when found all occurrences
                if(need == 0) return true;
            }
        }
        return false;
        
        // int bool = (int) Math.pow(2, k) - 1;
        // for(int i = bool; i >= 0; i --){
        //     String binaryStr = Integer.toBinaryString(i);
        //     String zero = "";
        //     for(int j = 0; j < k - binaryStr.length(); j ++){
        //         zero += "0";
        //     }
        //     binaryStr = zero + binaryStr;
        //     if(!s.contains(String.valueOf(binaryStr))) 
        //         return false;
        // }
        // return true;
    }
}