import java.util.HashMap;

public class SeveralStepToothBrushSale {
    static HashMap<String, String> parent;
    static HashMap<String, Integer> hm;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        parent = new HashMap<>();
        hm = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            hm.put(enroll[i], 0);
            if (referral[i].equals("-")) {
                continue;
            }
            parent.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String person = seller[i];
            String recommender = parent.get(person);
            int left = (int) ((amount[i] * 100) * (0.1));
            int now = (amount[i] * 100) - left;

            if (left < 1) {
                int money = hm.get(person) + amount[i];
                hm.put(person, money);
                continue;
            }
            int money = hm.get(person) + now;
            hm.put(person, money);
            if (!parent.containsKey(recommender)) {
                person = recommender;
                now = left;
                now = (now - (int) (left * (0.1)));
                if (hm.containsKey(person)) {
                    money = hm.get(person) + now;
                }

                hm.put(person, money);
                continue;
            }
            while (parent.containsKey(recommender)) {
                person = recommender;
                now = left;
                left = (int) ((now) * (0.1));
                if (left < 1) {
                    money = hm.get(person) + now;
                    hm.put(person, money);
                    break;
                }
                now = now - left;
                money = hm.get(person) + now;
                hm.put(person, money);

                recommender = parent.get(person);
                if (!parent.containsKey(recommender)) {
                    person = recommender;
                    now = left;
                    now = (now - (int) (left * (0.1)));
                    money = hm.get(person) + now;
                    hm.put(person, money);
                    break;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = hm.get(enroll[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] answer = solution(enroll, referral, seller, amount);
        for (int i : answer) {
            System.out.print(i + "  ");
        }
    }
}

