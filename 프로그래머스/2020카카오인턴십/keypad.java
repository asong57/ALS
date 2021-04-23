public class keypad {

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftPoint = 10;
        int rightPoint = 12;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                leftPoint = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                rightPoint = numbers[i];
            } else {
                int leftLength = getLength(leftPoint, numbers[i]);
                int rightLength = getLength(rightPoint, numbers[i]);
                if (leftLength > rightLength) {
                    answer.append("R");
                    rightPoint = numbers[i];
                } else if (leftLength < rightLength) {
                    answer.append("L");
                    leftPoint = numbers[i];
                } else {
                    if (hand.contains("left")) {
                        answer.append("L");
                        leftPoint = numbers[i];
                    } else {
                        answer.append("R");
                        rightPoint = numbers[i];
                    }
                }
            }
        }

        return answer.toString();
    }

    public static int getLength(int point, int number) {
        int length = 0;

        point = (point == 0) ? 11 : point;
        number = (number == 0) ? 11 : number;

        int pointX = point % 3;
        int numberX = number % 3;
        if (pointX == 0) {
            pointX = 3;
        }
        if (numberX == 0) {
            numberX = 3;
        }
        int pointY = (point + 2) / 3;
        int numberY = (number + 2) / 3;

        length = Math.abs(pointX - numberX) + Math.abs(pointY - numberY);
        return length;

    }
}
