package April.Week3;
import java.util.*;
public class RemoveAllAdjacentDuplicatesInString2 {
    public static void main(String[] args){
        String s = "pbbcggttciiippooaais";
        int k = 2;
        System.out.println(removeDuplicates(s, k));
    }
    public static String removeDuplicates(String s, int k) {
        // StringBuilder sb = new StringBuilder(s);

        // while(true){
        //     boolean duplicateSubExist = false;

        //     for(int i = 0; i <= sb.length() - k; i ++){
        //         boolean duplicate = true;
        //         for(int j = 1; j < k; j ++){
        //             if(sb.charAt(i + j) != sb.charAt(i)){
        //                 duplicate = false;
        //                 break;
        //             }
        //         }
        //         if(duplicate){
        //             for(int j = 0; j < k; j ++){
        //                 sb.deleteCharAt(i);
        //             }
        //             duplicateSubExist = true;
        //         }
        //     }
        //     if(!duplicateSubExist) break;
        // }
        // return sb.toString();

        Stack<Pair> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().c == ch){
                stack.peek().freq ++;
            } else {
                stack.push(new Pair(ch, 1));
            }
            if(stack.peek().freq == k){
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair peek = stack.pop();
            for(int i = 0; i < peek.freq; i ++){
                sb.append(peek.c);
            }
        }
        return sb.reverse().toString();
    }
    static class Pair{
        char c;
        int freq;
        public Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
}
