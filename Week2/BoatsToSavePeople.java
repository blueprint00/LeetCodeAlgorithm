package Week2;

import java.util.Arrays;

public class BoatsToSavePeople {
	public static void main(String[] args) {
		int[] people = {3, 2, 2, 1};
		int limit = 3;
		System.out.println(numRescueBoats(people, limit));
	}
	public static int numRescueBoats(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		
		int right = people.length - 1;
		for(int left = 0; left <= right; ) {
			if(people[left] + people[right] <= limit) {
				left ++;
				right --;
				answer ++;
			} else {
				right --;
				answer ++;
			}
		}
		
		return answer;
    }
}