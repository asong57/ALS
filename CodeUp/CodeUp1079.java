import java.util.Scanner;

public class CodeUp1079 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
       String[] words=word.split(" ");
       for(int i=0;i< words.length;i++){
           if(words[i].equals("q")){
               System.out.println(words[i]);
               break;
           }
           System.out.println(words[i]);
       }
    }
}
