package April.Week4;
import java.util.*;
public class BrickWall {
    public static void main(String[] args){
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(new ArrayList<>());
        wall.get(0).add(1);
        wall.get(0).add(2);
        wall.get(0).add(2);
        wall.get(0).add(1);        
        wall.add(new ArrayList<>());
        wall.get(1).add(3);
        wall.get(1).add(1);
        wall.get(1).add(2);
        wall.add(new ArrayList<>());
        wall.get(2).add(1);
        wall.get(2).add(3);
        wall.get(2).add(2);
        wall.add(new ArrayList<>());
        wall.get(3).add(2);
        wall.get(3).add(4);
        wall.add(new ArrayList<>());
        wall.get(4).add(3);
        wall.get(4).add(1);
        wall.get(4).add(2);
        wall.add(new ArrayList<>());
        wall.get(5).add(1);
        wall.get(5).add(3);
        wall.get(5).add(1);
        wall.get(5).add(1);
        System.out.println(leastBricks(wall));
    }
    public static int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i ++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                cnt = Math.max(cnt, map.get(length));
            }
        }
        return wall.size() - cnt;
    }
}