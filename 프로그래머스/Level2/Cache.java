import java.util.ArrayList;

public class Cache {

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        int time = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (!list.contains(city)) {
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(city);
                time += 5;
            } else {
                list.remove(city);
                list.add(city);
                time += 1;
            }
        }
        return time;
    }


    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(solution(5, cities));
    }
}
