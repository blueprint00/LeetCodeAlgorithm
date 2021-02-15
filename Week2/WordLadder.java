package Week2;
import java.util.*;

public class WordLadder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("dot");
		wordList.add("log");
		wordList.add("log");
		wordList.add("cog");
		
//		String beginWord = "hot";
//		String endWord = "dog";
//		List<String> wordList = new ArrayList<>();
//		wordList.add("hot");
//		wordList.add("dog");
		
//		String beginWord = "hot";
//		String endWord = "dog";
//		List<String> wordList = new ArrayList<>();
//		wordList.add("hot");
//		wordList.add("cog");
//		wordList.add("dog");
//		wordList.add("tot");
//		wordList.add("hog");
//		wordList.add("hop");
//		wordList.add("pot");
//		wordList.add("dot");
		
		System.out.println(ladderLength(beginWord, endWord, wordList));

	}
	public static boolean isDiffOneChar(String word1, String word2) {
		int cnt = 0;
		for(int i = 0; i < word1.length(); i ++) {
			if(word1.charAt(i) != word2.charAt(i)) cnt ++;
		}
		
		return cnt == 1;
	}
	
	public static int dfs(int idx, String word, String endWord, List<String> wordList, boolean[] visited, int cnt) {
		
		if(word.equals(endWord) || visited[idx]) return cnt + 1;
		
		visited[idx] = true;
		
		int answer = 0;
		for(int i = 0; i < wordList.size(); i ++) {
			if(!visited[i] && idx != i && isDiffOneChar(word, wordList.get(i))) {
        		System.out.println(answer + " " + wordList.get(i));
				answer = dfs(i, wordList.get(i), endWord, wordList, visited, cnt + 1);
			}
		}
		return answer;
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int answer = 0;
        boolean[] visited = new boolean[wordList.size()];
        
        int cnt = 0;
        for(String word : wordList) {
        	if(endWord.equals(word)) cnt ++;
        }
        if(cnt == 0) return 0;
        
        for(int i = 0; i < wordList.size(); i ++) {
        	if(isDiffOneChar(beginWord, wordList.get(i))) {
        		answer = dfs(i, wordList.get(i), endWord, wordList, visited, 2);
        	}
        }
        
        return answer;
    }
}
