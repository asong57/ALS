public class Baekjoon4690 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 100; i++) {
            for (int b = 2; b < i; b++) {
                for (int c = b + 1; c < i; c++) {
                    for (int d = c + 1; d < i; d++) {
                        if (i * i * i == b * b * b + c * c * c + d * d * d) {
                            sb.append("Cube = ").append(i).append(", Triple = (").append(b).append(",").append(c).append(",").append(d).append(")").append("\n");
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
