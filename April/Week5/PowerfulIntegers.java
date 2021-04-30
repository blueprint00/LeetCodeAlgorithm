package April.Week5;
import java.util.*;
public class PowerfulIntegers {
    public static void main(String[] args){
        int x = 2, y = 3;
        int bound = 10;
        for(int i : powerfulIntegers(x, y, bound)){
            System.out.println(i);
        }
    }
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        int a = 0, b = 0;
        if(x != 1) {
            while(Math.pow(x, a) <= bound){
                a ++;
            }
        }
        if(y != 1){
            while(Math.pow(y, b) <= bound){
                b ++;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i <= a; i ++){
            for(int j = 0; j <= b; j ++){
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if(sum <= bound && !answer.contains(sum)){
                    answer.add(sum);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}