package Week1;

public class BeautifulArrangement {
	public static void main(String[] args) {
		System.out.println(countArrangement(1));
	}
	
	static boolean[] used;
	static int answer;
	public static int countArrangement(int n) {
		answer = 0;
		used = new boolean[n + 1];
		
		beautiful(n, 1); // index starts from 1
		
		return answer;
	}
	
	public static void beautiful(int n, int index) {
		if(index > n) {
			answer ++;
			return ;
		}
		
		for(int i = 1; i <= n; i ++) {
			if(!used[i] && (i % index == 0 || index % i == 0)) {
				used[i] = true;
                beautiful(n, index + 1);
				used[i] = false;
			}
		}
	}
}
