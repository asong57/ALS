public class Kakao2018_SecretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            int size1 = str1.length();
            int size2 = str2.length();
            if (size1 < n) {
                for (int k = 0; k < n - size1; k++) {
                    str1 = "0" + str1;
                }
            }
            if (size2 < n) {
                for (int k = 0; k < n - size2; k++) {
                    str2 = "0" + str2;
                }
            }
            String map = "";
            for (int j = 0; j < n; j++) {
                if (str1.charAt(j) == '1') {
                    map += "#";
                    continue;
                } else if (str2.charAt(j) == '1') {
                    map += "#";
                    continue;
                }
                map += " ";
            }
            answer[i] = map;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = solution(5, arr1, arr2);
        for (String a : answer) {
            System.out.println(a);
        }
    }
}
