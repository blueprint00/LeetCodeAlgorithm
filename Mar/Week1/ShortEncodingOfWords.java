package Mar.Week1;
import java.util.*;
public class ShortEncodingOfWords {
	public static void main(String[] args) {
		String[] words = {"feipyxx", "e"};//"time", "me", "bell"};
		System.out.println(minimumLengthEncoding(words));
	}
	public static int minimumLengthEncoding(String[] words) {
		if (words == null || words.length == 0) {
            return 1;
        }
		
		Set<String> strings = new HashSet<>();// 중복 제거
		Collections.addAll(strings, words);
		
		Iterator<String> strs = strings.iterator();
		int size = 0;
		while(strs.hasNext()) {
			words[size ++] = strs.next();
		}
		
		int result = 0, add;
		for(int i = 0; i < size; i ++) {
			add = words[i].length() + 1;// 1 == "#"
			for(int j = 0; j < size; j ++) {
				//만약 words[i]가 words[j]의 접미사일 경우 최종 스트링에 더할 필요 없음 
				if(i != j && words[j].endsWith(words[i])) {
					add = 0;
					break;
				}
			}
			result += add;
		}
		return result;
		
//		StringBuffer s = new StringBuffer(words[0] + "#");
//		
//		for(int i = 1; i < words.length; i ++) {
//			String tmp = "";
//			for(char ch : s.toString().toCharArray()) {
//				if(ch != '#') tmp += ch;
//			}
//			if(s.toString().contains(words[i])) continue;
//			if(words[i].contains(tmp)) {
//				int first = s.indexOf(tmp);
//				String tmp2 = s.substring(first + tmp.length() + 1);
//				s.delete(first, first + tmp.length());
//				s.insert(first, words[i]);
//			} else {
//				s.append(words[i] + "#");
//			}
//		}
//		System.out.println(s);
//        return s.length();
    }
}
