package April.Week2;
import java.util.*;
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args){
        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
    // public static void dfs(int[][] matrix, int i, int j, int[] max, int len){
    //     max[0] = Math.max(max[0], len);

    //     int m = matrix.length;
    //     int n = matrix[0].length;

    //     int[] dx = {-1, 0, 1, 0};
    //     int[] dy = {0, 1, 0, -1};

    //     for(int k = 0; k < 4; k ++){
    //         int x = i + dx[k];
    //         int y = j + dy[k];

    //         if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
    //             dfs(matrix, x, y, max, len + 1);
    //         }
    //     }
    // }

    public static int dfs(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j] != 0) return cache[i][j];
        int[][] dirs = {{0 ,1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length; 
        for(int[] d : dirs){
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        return ++ cache[i][j];
    }
    
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length; 
        int[][] cache = new int[m][n];
        int answer = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                answer = Math.max(answer, dfs(matrix, i, j, cache));
            }
        }
        return answer;
    //     int[] max = new int[1];
    //     for(int i = 0; i < matrix.length; i ++){
    //         for(int j = 0; j < matrix[i].length; j ++){
    //             dfs(matrix, i, j, max, 1);
    //         }
    //     }
    //     return max[0];
    }
}