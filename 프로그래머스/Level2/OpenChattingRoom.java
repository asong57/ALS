import java.util.HashMap;

public class OpenChattingRoom {
    //- StringBuilder를  split 하는 것
    //- 해시맵 이용
    
    public static void main(String[] args){
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }
    public static String[] solution(String[] record) {
        String[] answer ={};
        String[][] str = new String[record.length][3];
        HashMap<String,String> hm = new HashMap<>();
        for(int i=0; i<record.length;i++){
             str[i] = record[i].split(" ");
             if(str[i][0].charAt(0) == 'E' || str[i][0].charAt(0) == 'C'){
                 hm.put(str[i][1],str[i][2]);
             }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length;i++){
            if(str[i][0].charAt(0) == 'E'){
                sb.append(hm.get(str[i][1])+"님이 들어왔습니다.,") ;
                continue;
            }else if(str[i][0].charAt(0) == 'L'){
                sb.append(hm.get(str[i][1])+"님이 나갔습니다.,");
                continue;
            }
        }
        String result = sb.toString();
        answer = result.split(",");
        return answer;
    }
}
