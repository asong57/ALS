import java.util.Scanner;

public class CodeUp1069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

       switch(word){
           case "A":
               System.out.println("best!!!");
               break;
           case "B":
               System.out.println("good!!");
               break;
           case "C":
               System.out.println("run!");
               break;
           case "D":
               System.out.println("slowly~");
               break;
           default:
               System.out.println("what?");
       }
    }
}
