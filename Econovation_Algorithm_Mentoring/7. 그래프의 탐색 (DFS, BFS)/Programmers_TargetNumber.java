import java.util.Arrays;

public class Programmers_TargetNumber {
    static char[] arr;
    static int Target;
    static int count;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        arr = new char[]{'+', '-'};
        Target = target;
        count = 0;
        char[] temp = new char[numbers.length];
        makeCombination(target, temp, 0, 0, numbers);
        return count;
    }

    public void makeCombination(int r, char[] temp, int current, int start, int[] numbers) {
        if (temp.length == current) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (temp[i] == '-') {
                    sum -= numbers[i];
                } else {
                    sum += numbers[i];
                }
            }
            if (Target == sum) {
                count++;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                makeCombination(r, temp, current + 1, i, numbers);
            }
        }
    }
}
