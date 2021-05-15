public class MakingPrimeNumber {
    public int count = 0;

    public int solution(int[] nums) {
        int[] temp = new int[3];
        makeCombination(3, temp, 0, 0, nums);
        return count;
    }

    public boolean isPrimeNumber(int number) {
        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void makeCombination(int r, int[] temp, int current, int start, int[] nums) {

        if (r == current) {
            int sum = temp[0] + temp[1] + temp[2];
            if (isPrimeNumber(sum)) {
                count++;
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                temp[current] = nums[i];
                makeCombination(r, temp, current + 1, i + 1, nums);
            }
        }
    }
}
