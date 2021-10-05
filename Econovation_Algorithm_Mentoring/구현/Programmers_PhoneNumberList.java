import java.util.HashSet;

public class Programmers_PhoneNumberList {
    public boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            hs.add(phone_book[i]);
        }
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                String str = phone_book[i].substring(0,j);
                if(hs.contains(str)){
                    return false;
                }
            }
        }

        return true;
    }
}
