package Week2;
import java.util.*;

public class CreateSortedArrayThroughInstruction {
	public static void main(String[] args) {
		int[] instructions = {1,3,3,3,2,4,2,1,2};
		
		System.out.println(createSortedArray(instructions));
	}
	
	static int[] count;
	static int limit = (int)1e5 + 1;
	static int MOD = (int)1e9 + 7;
	
	public static void updateCount(int number) {
		while(number < limit) {
			count[number] ++ ;
			number += number & -number;
		}
	}
	
	public static int getCount(int number) {
		int res = 0;
		while(number > 0) {
			res += count[number];
			number -= number & -number;
		}
		return res;
	}
	
	public static int createSortedArray(int[] instructions) {
		int totalCost = 0;
		count = new int[limit];
		
		for(int i = 0; i < instructions.length; i ++) {
			int smallerNumCnt = getCount(instructions[i] - 1);
			int greaterNumCnt = i - getCount(instructions[i]);
			totalCost = (totalCost + Math.min(smallerNumCnt, greaterNumCnt)) % MOD;
			updateCount(instructions[i]);
		}
		return totalCost;
		
//		List<Integer> num = new ArrayList<>();
//		
//		int cost = 0;
//		for(int i = 0; i < instructions.length; i ++) {
//			num.add(instructions[i]);
//
//			Collections.sort(num);
//			for(int n : num) {
//				System.out.print(n + " " );
//			}System.out.println();
//			
//			int max = i;
//			int min = 0;
//			
//			int idx = num.indexOf(instructions[i]);
//			
//			if(num.get(i) == num.get(idx)) idx = i;
//			else if(num.get(0) == num.get(idx)) idx = 0;
//			
//			cost += Math.min(max - idx, idx - min);
//		}
//		return cost;
    }	
}
