import java.util.HashSet;

public class Programmers_PrimeNumber {
    static int[] arr;
    static int count;
    HashSet<Integer> hs;

    public int solution(String numbers) {
        arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        count = 0;
        hs = new HashSet<>();
        for (int i = 1; i <= numbers.length(); i++) {
            int[] temp = new int[i];
            boolean visit[] = new boolean[arr.length];
            makeCombination(i, temp, 0, visit);
        }
        return count;
    }

    public void makeCombination(int r, int[] temp, int current, boolean[] visit) {
        if (r == current) {
            String num = "";
            for (int i = 0; i < temp.length; i++) {
                num += temp[i];
            }
            if (num.charAt(0) == '0' && num.length() > 1) {
                num = num.substring(1);
            }
            int number = Integer.parseInt(num);

            if (number == 1 || number == 0) {
                return;
            }

            if (hs.contains(number)) {
                return;
            } else {
                hs.add(number);
            }

            if (number == 2) {
                count++;
                return;
            }
            
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return;
                }
            }
            count++;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    temp[current] = arr[i];
                    makeCombination(r, temp, current + 1, visit);
                    visit[i] = false;
                }

            }
        }
    }
}
