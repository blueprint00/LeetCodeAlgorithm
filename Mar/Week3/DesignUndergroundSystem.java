package Mar.Week3;
import java.util.*;
public class DesignUndergroundSystem {
    public static void main(String[] args){
        // String[] order = {"UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"}
        // [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
   
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667
    }
}
class UndergroundSystem {
    Map<Integer,String> checkInMap;
    Map<String, Integer> timeMap;
    Map<String, Integer> countMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        timeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, stationName + "," + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String val = checkInMap.get(id);
        String prevStationName = val.split(",")[0];
        int prevTime = Integer.parseInt(val.split(",")[1]);
        String key = prevStationName + "|" + stationName;
        timeMap.put(key, timeMap.getOrDefault(key, 0) + t - prevTime);
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "|" + endStation;
        return (double)timeMap.get(key) / countMap.get(key);
    }

    // class Underground{
    //     int id;
    //     String startStation;
    //     String endStation;
    //     int enterTime;
    //     int arriveTime;
    
    //     Underground(int id, String startStation, String endStation, int enterTime, int arriveTime){
    //         this.id = id;
    //         this.startStation = startStation;
    //         this.endStation = endStation;
    //         this.enterTime = enterTime;
    //         this.arriveTime = arriveTime;
    //     }
    // }

    // List<Underground> under;

    // public UndergroundSystem() {

    //     under = new ArrayList<>();
    // }
    
    // public void checkIn(int id, String stationName, int t) {
    //     under.add(new Underground(id, stationName, null, t, 0));

    // }
    
    // public void checkOut(int id, String stationName, int t) {
    //     for(int i = 0; i < under.size(); i ++){
    //         if(under.get(i).id == id){
    //             under.get(i).endStation = stationName;
    //             under.get(i).arriveTime = t;
    //         }
    //     }
    // }
    
    // public double getAverageTime(String startStation, String endStation) {
    //     int sum = 0, cnt = 0;
    //     for(int i = 0; i < under.size(); i ++){
    //         Underground u = under.get(i);
    //         if(u.startStation.equals(startStation) && u.endStation.equals(endStation)){
    //             sum += (u.arriveTime - u.enterTime);
    //             cnt ++;
    //         }
    //     }
    //     return (double) sum / cnt;
    // }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */