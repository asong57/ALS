import java.util.ArrayList;

public class Kakao2018ONE {
    public static int solution(int cacheSize, String[] cities) {
        int sum = 0;
        ArrayList<String> list = new ArrayList<>();
        if (cacheSize == 0) {
            sum = 5 * cities.length;
            return sum;
        }

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (!list.contains(city)) {
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(city);
                sum += 5;
            } else {
                list.remove(list.indexOf(city));
                list.add(city);
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(3, cities));
    }
}
