package Week1;
import java.util.*;

public class CheckArrayFormationThroughConcatenation {
	public static void main(String[] args) {
		int[] arr = {7, 4, 64, 19};
		int[][] pieces = {{19}, {4, 64}, {7}};
		System.out.println(canFormArray(arr, pieces));
	}
	
	public static boolean canFormArray(int[] arr, int[][] pieces) {
//		int cnt = 0;
//		for(int i = 0; i < arr.length; i ++) {
//			for(int j = 0; j < pieces.length; j ++) {
//				int length = pieces[j].length;
//				if(arr[i] == pieces[j][0]) {
//					cnt ++;
//					if(length > 1) {
//						cnt --;
//						for(int piece : pieces[j]) {
//							if(arr[i ++] == piece) {
//								if(i == arr.length) break;
//								cnt ++;
//							}
//						}
//					}
//				}
//			}
//		}
//        if(cnt == arr.length) return true;
//        else return false;
		
		Map<Integer, int[]> map = new HashMap<>();
		for(int[] piece : pieces) {
			map.put(piece[0], piece);
		}
	
		for(int i = 0 ; i < arr.length; ) {
			int curVal = arr[i];
			if(map.containsKey(curVal)) {
				int[] piece = map.get(curVal);
				for(int value : piece) {
					if(value == arr[i]) i ++;
					else return false;
				}
			} else return false;
		}
		
		return true;
    }
}
