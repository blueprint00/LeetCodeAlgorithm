package Week2;
import java.util.*;

public class WordLadder {
	public static void main(String[] args) {
//		String beginWord = "hit";
//		String endWord = "cog";
//		List<String> wordList = new ArrayList<>();
//		wordList.add("hot");
//		wordList.add("dot");
//		wordList.add("dog");
//		wordList.add("log");
//		wordList.add("log");
//		wordList.add("cog");
		
//		String beginWord = "hot";
//		String endWord = "dog";
//		List<String> wordList = new ArrayList<>();
//		wordList.add("hot");
//		wordList.add("dog");
		
		String beginWord = "hot";
		String endWord = "dog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("cog");
		wordList.add("dog");
		wordList.add("tot");
		wordList.add("hog");
		wordList.add("hop");
		wordList.add("pot");
		wordList.add("dot");
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}
	
	
//	public static boolean isDiffOneChar(String word1, String word2) {
//		int cnt = 0;
//		for(int i = 0; i < word1.length(); i ++) {
//			if(word1.charAt(i) != word2.charAt(i)) cnt ++;
//		}
//		
//		return cnt == 1;
//	}
//	
//	public static int dfs(int idx, String word, String endWord, List<String> wordList, boolean[] visited, int cnt) {
//		
//		if(word.equals(endWord) || visited[idx]) return cnt;
//		
//		visited[idx] = true;
//		
//		int answer = 0;
//		for(int i = 0; i < wordList.size(); i ++) {
//			if(!visited[i] && idx != i && isDiffOneChar(word, wordList.get(i))) {
//        		System.out.println(answer + " " + wordList.get(i));
//				answer = dfs(i, wordList.get(i), endWord, wordList, visited, cnt + 1);
//			}
//		}
//		return answer;
//	}
//	
//	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int answer = 0;
//        boolean[] visited = new boolean[wordList.size()];
//        
//        int cnt = 0;
//        for(String word : wordList) {
//        	if(endWord.equals(word)) cnt ++;
//        }
//        if(cnt == 0) return 0;
//        
//        for(int i = 0; i < wordList.size(); i ++) {
//        	if(isDiffOneChar(beginWord, wordList.get(i))) {
//        		answer = dfs(i, wordList.get(i), endWord, wordList, visited, 1);
//        	}
//        }
//        
//        return answer + 1;
//    }
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));
		
//		if(!wordList.contains(endWord)) return 0;
		
		while(!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			
			if(word.equals(endWord)) return top.numSteps;
			
			char[] arr = word.toCharArray();
			for(int i = 0; i < arr.length; i ++) {
				for(char c = 'a'; c <= 'z'; c ++) {
					char tmp = arr[i];
					if(arr[i] != c) arr[i] = c;
					
					String newWord = new String(arr);
					if(wordList.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps + 1));
						wordList.remove(newWord);
					}
					
					arr[i] = tmp;
				}
			}
		}
		
		return 0;
	}
}
class WordNode{
	String word;
	int numSteps;
	
	public WordNode(String word, int numSteps) {
		this.word = word;
		this.numSteps = numSteps;
	}
}
