package April.Week3;
import java.util.*;
public class Triangle {
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(2);
        triangle.add(new ArrayList<>());
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.add(new ArrayList<>());
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.add(new ArrayList<>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {        
        int size = triangle.size();
        int[][] sum = new int[size][size];
        sum[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < size; i ++){
            sum[i][0] = sum[i - 1][0] + triangle.get(i).get(0);
            sum[i][i] = sum[i - 1][i - 1] + triangle.get(i).get(i);
        }
        for(int i = 2; i < size; i ++){
            for(int j = 1; j < triangle.get(i).size(); j ++){
                if(i == j) continue;
                sum[i][j] = Math.min(sum[i - 1][j - 1], sum[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        int answer = sum[size - 1][0];
        for(int ans : sum[size - 1]){
            answer = Math.min(answer, ans);
        }
        return answer;
    }
}