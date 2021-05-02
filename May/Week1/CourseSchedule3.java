package May.Week1;

import java.util.*;

public class CourseSchedule3 {
    public static void main(String[] args){
        int[][] courses = {{5, 5}, {4, 6}, {2, 6}};//100, 200},{200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses));
    }
    public static int scheduleCourse(int[][] courses) {
        // int answer = 0;
        // int currTotalTime = 0;
        // Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        // for(int i = 0; i < courses.length; i ++){
        //     if(currTotalTime + courses[i][0] <= courses[i][1]) {
        //         currTotalTime += courses[i][0];
        //         System.out.println(currTotalTime);
        //         answer ++;
        //     }
        // }
        // return answer;
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int currTotalTime = 0;

        for(int i = 0; i < courses.length; i ++){
            if(currTotalTime + courses[i][0] <= courses[i][1]){
                q.offer(courses[i][0]);
                currTotalTime += courses[i][0];
            } else if(!q.isEmpty() && q.peek() > courses[i][0]) {
                currTotalTime += courses[i][0] - q.poll();
                q.offer(courses[i][0]);
            }
        }
        return q.size();
    }
}