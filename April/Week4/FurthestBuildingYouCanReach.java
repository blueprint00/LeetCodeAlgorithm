package April.Week4;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args){
        int[] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int answer = heights.length - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < heights.length - 1; i ++){
            int diff = heights[i + 1] - heights[i];
            if(diff > 0){
                if(ladders > 0) {
                    pq.add(diff);
                    ladders --;
                } else if(pq.size() > 0 && diff > pq.peek()){
                    pq.add(diff);
                    bricks -= pq.poll();
                } else bricks -= diff;
                if(bricks < 0) return i;
            }
        }   
        return answer;
    }
}