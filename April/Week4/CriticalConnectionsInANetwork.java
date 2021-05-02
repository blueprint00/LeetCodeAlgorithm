package April.Week4;
import java.util.*;
public class CriticalConnectionsInANetwork {
    public static void main(String[] args){
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>());
        connections.get(0).add(0);
        connections.get(0).add(1);
        connections.add(new ArrayList<>());
        connections.get(1).add(1);
        connections.get(1).add(2);
        connections.add(new ArrayList<>());
        connections.get(2).add(2);
        connections.get(2).add(0);
        connections.add(new ArrayList<>());
        connections.get(3).add(1);
        connections.get(3).add(3);
        for(List<Integer> list : criticalConnections(n, connections)){
            for(int l : list){
                System.out.println(l);
            }
        }
    }
    static List<List<Integer>> answer = new ArrayList<>();
    static Map<Integer, List<Integer>> edgeMap = new HashMap<>();
    static int[] disc, low;
    static int time = 1;
    
    public static void dfs(int curr, int prev){
        disc[curr] = low[curr] = time ++;
        for(int next : edgeMap.get(curr)){
            if(disc[next] == 0){
                dfs(next, curr);
                low[curr] = Math.min(low[curr], low[next]);
            } else if(next != prev){
                low[curr] = Math.min(low[curr], disc[next]);
            }
            if(low[next] > disc[curr]) answer.add(Arrays.asList(curr, next));
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        for(int i = 0; i < n; i ++) edgeMap.put(i, new ArrayList<Integer>());
        for(List<Integer> conn : connections){
            edgeMap.get(conn.get(0)).add(conn.get(1));
            edgeMap.get(conn.get(1)).add(conn.get(0));
        }
        dfs(0, -1);
        return answer;
    }  
}