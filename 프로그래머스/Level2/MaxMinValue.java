import java.util.Arrays;

public class MaxMinValue {
    public static String solution(String s) {
        String answer = "";
        String[] values = new String[s.length()];
        values = s.split(" ");
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        Arrays.sort(numbers);
        answer = numbers[0] + " " + numbers[numbers.length - 1];

        return answer;
    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        solution(s);
    }
}
