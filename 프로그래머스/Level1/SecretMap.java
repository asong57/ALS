public class SecretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            binary1[i] = Integer.toBinaryString(arr1[i]);
            if (binary1[i].length() < n) {
                int size = (n-binary1[i].length());
                for (int j = 0; j < size; j++) {
                    binary1[i] = "0" + binary1[i];
                }
            }
            System.out.println("binary1"+i+" : "+binary1[i]);
        }
        for (int i = 0; i < n; i++) {
            binary2[i] = Integer.toBinaryString(arr2[i]);
            if (binary2[i].length() < n) {
                int size = (n-binary2[i].length());
                for (int j = 0; j < size; j++) {
                    binary2[i] = "0" + binary2[i];
                }
            }
            System.out.println("binary2"+i+" : "+binary2[i]);
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binary1[i].charAt(j) == '0' && binary2[i].charAt(j) == '0') {
                    sb.append(' ');
                } else {
                    sb.append('#');
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = new String[5];
        answer = solution(5, arr1, arr2);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }

    public String[] solution2(int n, int[] arr1, int[] arr2) {
        //다른사람의 풀이
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
