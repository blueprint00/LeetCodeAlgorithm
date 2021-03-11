package Mar.Week2;

public class IntegerToRoman {
	public static void main(String[] args) {
		int num = 1994;
		System.out.println(intToRoman(num));
	}
	public static String makeString(int tmp, String x, String y, String z) {
		String answer = "";
		if(tmp == 9) {
			answer += z;
			answer += x;
		} else if(tmp >= 5) {
			answer+= y;
			for(int i = 0; i < tmp - 5; i ++) {
				answer += z; 
			}
		} else if(tmp == 4){
			answer += z;
			answer += y;
		} else {
			for(int i = 0; i < tmp; i ++) {
				answer += z;
			}
		}
		return answer;
	}
    public static String intToRoman(int num) {
    	String answer = "";
    	char[] ch = String.valueOf(num).toCharArray();    
    	System.out.println(ch.length);
    	int length = ch.length;
    	
    	while(num > 0) {
    		int div = (int) Math.pow(10, length - 1);
    		int tmp = num / div;
    		if(length == 4) { // 천의 자리
    			for(int i = 0; i < tmp; i ++) {
    				answer += "M";
    			}
    		} else if(length == 3) { // 백의 자리
    			answer += makeString(tmp, "M", "D", "C");
    		} else if(length == 2) { // 십의 자리
    			answer += makeString(tmp, "C", "L", "X");
    		} else {
    			answer += makeString(tmp, "X" ,"V", "I");
    		}
    		num %= div;
    		length --;
    	}
    	return answer;
    }
}

