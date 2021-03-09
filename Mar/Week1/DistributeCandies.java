package Mar.Week1;
import java.util.*;
public class DistributeCandies {
	public static void main(String[] args) {
		int[] candyType = {1, 2, 3, 4};
		System.out.println(distributeCandies(candyType));
	}
	public static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();s
        for(int candy : candyType) set.add(candy);
        return Math.min(set.size(), candyType.length / 2);
    }
}
