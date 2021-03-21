package Mar.Week3;

import java.util.Arrays;

public class ReorderedPowerOf2 {
    public static void main(String[] args){
        int N = 10;
        System.out.println(reorderedPowerOf2(N));
    }
    public static boolean reorderedPowerOf2(int N){
        char[] ch = String.valueOf(N).toCharArray();
        Arrays.sort(ch);
        for(int i = 0; i < 30; i ++){
            char[] tmp = String.valueOf(1 << i).toCharArray();
            Arrays.sort(tmp);
            if(Arrays.equals(ch, tmp)) return true;
        }
        return false;
    }
}