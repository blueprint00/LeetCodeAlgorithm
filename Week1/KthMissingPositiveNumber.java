package Week1;

public class KthMissingPositiveNumber {
	public static void main(String[] args) {
		int[] arr = {2,3,4,7,11};//1, 2, 3, 4};
		int k = 5;
		System.out.println(findKthPositive(arr,k));
	}
	public static int findKthPositive(int[] arr, int k) {
		int[] missing = new int[k + 1];
		int i = 0, idx = 0;
		int p = 1;
		
		while(idx < k) {
			if(i < arr.length && p == arr[i]) {
				i ++;
				p ++;
				continue;
			}
			
			missing[idx] = p;
			idx ++;
			p ++;
		}
		
		return missing[k - 1];
    }
}
