public class Kakao2020_KeyPad {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        if (hand.equals("right")) {
            hand = "R";
        } else {
            hand = "L";
        }
        int left = 4;
        int right = 4;
        int middle = -1;
        int[] middleCheck = {1, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i] / 3 + 1;
                middleCheck[0] = 1;
                continue;
            }
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i] / 3;
                middleCheck[1] = 1;
                continue;
            }

            middle = numbers[i] / 3 + 1;
            if (numbers[i] == 0) {
                middle = 4;
            }

            if (Math.abs(middle - left) + middleCheck[0] < Math.abs(middle - right) + middleCheck[1]) {
                answer += "L";
                left = middle;
                middleCheck[0] = 0;
                continue;
            } else if (Math.abs(middle - left) + middleCheck[0] == Math.abs(middle - right) + middleCheck[1]) {
                answer += hand;

                if (hand.equals("L")) {
                    left = middle;
                    middleCheck[0] = 0;
                } else {
                    right = middle;
                    middleCheck[1] = 0;
                }
                continue;
            } else {
                middleCheck[1] = 0;
                answer += "R";
                right = middle;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(solution(numbers, "right"));
    }
}
