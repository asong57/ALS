public class JoyStick {
    //- 상하로 움직이는 것은 그냥 알파벳 최소 이동 수를 찾으면 되지만
    //    - 'M'까지 괜찮고 그 이상이면 뒤에서 가는 것이 더 작다.
    //    - count += name.charAt(i) -'A';
    //    - count += 'Z' - name.charAt(i) +1;
    //- 조이스틱을 좌우로 움직일 때의 최소횟수를 찾는 부분이 어려웠다.
    //    - 더 깊게 생각하고 규칙을 코드로 풀어내는 연습이 필요..!
    
    public int solution(String name) {
        int count = 0;

        int len = name.length();
        int min = len - 1;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) <= 'M') {
                count += name.charAt(i) - 'A';
            } else {
                count += 'Z' - name.charAt(i) + 1;
            }

            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            min = Math.min(min, (i * 2) + len - next);
        }
        count += min;
        return count;
    }
}
