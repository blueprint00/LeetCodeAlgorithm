package Week4;
import java.util.*;
public class SortTheMatrixDiagonally {
	public static void main(String[] args) {
		int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		for(int[] i : diagonalSort(mat)) {
			for(int n : i)
				System.out.print(n);
			System.out.println();
		}
	}
	public static int[][] diagonalSort(int[][] mat) {
		int row = mat.length, col = mat[mat.length - 1].length;
       
		Map<Integer, Queue<Integer>> diagonals = new HashMap<>();
		
		// insert values into HashMap
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < col; j ++) {
				diagonals.putIfAbsent(i - j, new PriorityQueue<>());
				diagonals.get(i - j).add(mat[i][j]);
			}
		}
		
		// take values back out of the HashMap
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < col; j ++) {
				mat[i][j] = diagonals.get(i - j).remove();
			}
		}
		
		return mat;
	}
}
