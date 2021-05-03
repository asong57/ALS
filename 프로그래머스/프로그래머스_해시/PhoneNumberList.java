import java.util.HashMap;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> hashMap = new HashMap<String, String>();

        for(int i=0; i< phone_book.length;i++){
            hashMap.put(phone_book[i], "prefix");
        }

        for(String phone: phone_book){
            for(int idx = 0; idx < phone.length();idx++){
                if(hashMap.containsKey(phone.substring(0,idx))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
