public class CalculateNecessaryMoney {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            long temp = price * i;
            sum += temp;
        }
        if (sum < money) {
            return 0;
        } else {
            return sum - money;
        }
    }
}
