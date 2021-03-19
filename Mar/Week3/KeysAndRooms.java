package Mar.Week3;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args){
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<>();
        arr.add(0); rooms.add(arr);
        arr.clear(); arr.add(3); arr.add(0); arr.add(1); rooms.add(arr);
        arr.clear(); arr.add(2); rooms.add(arr);
        arr.clear(); arr.add(0); rooms.add(arr);
        System.out.println(canVisitAllRooms(rooms));
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>(); // 내가 방문한 방
        Set<Integer> set = new HashSet<>(); // 내가 방문한 방 중 중복 제거
        stack.add(0); set.add(0);

        while(!stack.isEmpty()){
            int s = stack.pop();
            List<Integer> keys = rooms.get(s);
            for(int key : keys){
                if(!set.contains(key)){ // stack으로 하면 중복이 있어서 끊기질 않아서 그런건가?
                    stack.add(key);
                    set.add(key);
                }
            }
        }
        return set.size() == rooms.size();
    }
}