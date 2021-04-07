package April.Week1;

public class GlobalAndLocalInversions {
    public static void main(String[] args){
        int[] A = {1, 0, 2};
        System.out.println(isIdealPermutation(A));;
    }
    
    public static boolean isIdealPermutation(int[] A) {
        int global = 0, local = 0;

        for(int i = 0; i < A.length - 1; i ++){
            for(int j = i + 1; j < A.length; j ++){
                if(A[i] > A[j]) global ++;
            }
            if(A[i] > A[i + 1]) local ++;
        }
        return global == local;
    }
}