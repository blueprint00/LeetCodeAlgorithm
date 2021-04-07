package April.Week1;

public class MinimumOperationsToMakeArrayEqual {
    public static void main(String[] args){
        int n = 6;
        System.out.println(minOperations(n));
    }
    public static int minOperations(int n) {
        int answer = 0;
        int length = 0, middle = 0;
        if(n % 2 == 0){
            length = n / 2;
            middle = length * 2;
        } else {
            length = n / 2 + 1;
            middle = length * 2 - 1;
        }

        for(int i = 0; i < length; i ++){
            int arr = i * 2 + 1;
            answer += middle - arr;
        }
        
        return answer;
    }
}