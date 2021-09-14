import java.util.PriorityQueue;

public class VowelDictionary {
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static PriorityQueue<String> pq;

    public static int solution(String word) {
        int answer = 1;
        pq = new PriorityQueue<>();
        for (int i = 1; i <= 5; i++) {
            char[] temp = new char[i];
            makePermutation(i, temp, 0, 0);
        }
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            String str = pq.poll();

            if (str.equals(word)) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void makePermutation(int r, char[] temp, int current, int start) {
        if (r == current) {
            String str = "";
            for (int i = 0; i < temp.length; i++) {
                str = str + temp[i];
            }
            System.out.println(str);
            pq.add(str);
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                makePermutation(r, temp, current + 1, i);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(solution("EIO"));
    }
}
