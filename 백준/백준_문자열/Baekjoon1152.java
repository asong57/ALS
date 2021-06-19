import java.util.Scanner;

public class Baekjoon1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        if (words.length > 0) {
            if ("".equals(words[0]))
                System.out.println(words.length - 1);
            else
                System.out.println(words.length);
        } else {
            System.out.println("0");
        }
    }
}

