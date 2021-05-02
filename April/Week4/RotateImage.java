package April.Week4;

public class RotateImage {
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < (n + 1) / 2; i ++){
            for(int j = 0; j < n / 2; j ++){
                int tmp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}