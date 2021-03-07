package Mar.Week1;
import java.util.*;
public class DesignHashMap {
}
class MyHashMap {
    private final int BLOCK = 1000005;
	int[] nums;
	boolean[] map;
	
    /** Initialize your data structure here. */
    public MyHashMap() {
        nums = new int[BLOCK];
        map = new boolean[BLOCK];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        nums[key] = value;
        map[key] = true;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key] ? nums[key] : -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = false;
    }
}