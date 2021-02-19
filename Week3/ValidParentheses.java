package Week3;
import java.util.*;
public class ValidParentheses {
	public static void main(String[] args) {
		String s = "({)}";
		System.out.println(isValid(s));
	}
	public static boolean isValid(String s) {
		HashMap<Character, Character> mappings = new HashMap<>();
		mappings.put(')', '(');
		mappings.put('}', '{');
		mappings.put(']', '[');
		
		Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
        	if(mappings.containsKey(c)) {
	        	char topElement = stack.empty() ? '-' : stack.pop();
	        	if(topElement != mappings.get(c)) return false;
        	} else {
        		stack.push(c);
        	}
        }
        return stack.isEmpty();
    }
}
