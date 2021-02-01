package Week1;

public class CheckArrayFormationThroughConcatenation {
	public static void main(String[] args) {
		int[] arr = {7, 4, 64, 19};
		int[][] pieces = {{19}, {4, 64}, {7}};
		System.out.println(canFormArray(arr, pieces));
	}
	
	public static boolean canFormArray(int[] arr, int[][] pieces) {
		int cnt = 0;
		for(int i = 0; i < arr.length; i ++) {
			for(int j = 0; j < pieces.length; j ++) {
				int length = pieces[j].length;
				if(arr[i] == pieces[j][0]) {
					cnt ++;
					if(length > 1) {
						cnt --;
						for(int piece : pieces[j]) {
							if(arr[i ++] == piece) {
								if(i == arr.length) break;
								cnt ++;
							}
							i --;
						}
					}
				}
			}
		}
        if(cnt == arr.length) return true;
        else return false;
    }
}
