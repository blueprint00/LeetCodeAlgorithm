package Week4;

import java.util.*;

public class PathWithMinimumEffort {
	public static void main(String[] args) {
		int[][] heights = {{1,10,6,7,9,10,4,9}};//{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
		System.out.println(minimumEffortPath(heights));
	}
	
	public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[rows - 1].length;
        int[][] efforts = new int[rows][cols];
        
        for(int i = 0; i < rows; i ++) {
        	Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        
        efforts[0][0] = 0;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[] {0, 0, 0}); // row, col, effort
        
        int[][] directions = {{1 ,0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!minHeap.isEmpty()) {
        	int[] mat = minHeap.poll();
        	if(mat[0] == rows - 1 && mat[1] == cols - 1) {
        		return mat[2];
        	}
        	
        	for(int[] direction : directions) {
        		int row = mat[0] + direction[0];
        		int col = mat[1] + direction[1];
        		
        		if(row < 0 || row == rows || col < 0 || col == cols) continue;
        		
        		int effort = Math.max(mat[2], Math.abs(heights[row][col] - heights[mat[0]][mat[1]]));
        		if(effort < efforts[row][col]) {
        			efforts[row][col] = effort;
        			minHeap.offer(new int[] {row, col, effort});
        		}
        	}
        }
        
		return -1;
    }
}
