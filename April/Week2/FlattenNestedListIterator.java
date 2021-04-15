package April.Week2;
import java.util.*;
public class FlattenNestedListIterator {
    public static void main(String[] args){
        // List<NestedInteger> nestedList = new ArrayList<>();
        // NestedIterator i = new NestedIterator(nestedList);
        // while (i.hasNext()) v[f()] = i.next();
    }
}
class NestedIterator implements Iterator<Integer> {
    Queue<Integer> data = new LinkedList<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }
    public void flatten(List<NestedInteger> list){
        for(NestedInteger el : list){
            if(el.isInteger()) data.add(el.getInteger());
            else flatten(el.getList());
        }
    }

    @Override
    public Integer next() {
        return data.poll();
    }

    @Override
    public boolean hasNext() {
        return data.size() > 0;
    }
}
interface NestedInteger {
    
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}