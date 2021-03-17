package Mar.Week3;

public class GenerateRandomPointInACircle {
    public static void main(String[] args){
        Solution obj = new Solution(10, 5, -7.5);
        for(double d : obj.randPoint()){
            System.out.println(d);
        }
    }
}
class Solution { 
    double RAD, XC, YC;
    public Solution(double radius, double x_center, double y_center) {
        RAD = radius;
        XC = x_center;
        YC = y_center;
    }
    
    // 왜 삼각형 이용해서 하는거지?????? 이해 안 감
    public double[] randPoint() {
        double angle = Math.random() * 2 * Math.PI; 
        double hyp = Math.sqrt(Math.random()) * RAD; // 삼각형의 직각 대변
        double x_point = Math.cos(angle) * hyp; 
        double y_point = Math.sin(angle) * hyp;
        return new double[] {XC + x_point, YC + y_point};
    }
}