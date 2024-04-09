import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int gap = 'a' - 'A';
        char last = '@';
        int count = 0;
        
        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if (c >= 'a' && c <= 'z'){
                ;
            }
            else if (c >= '0' && c <= '9'){
                ;
            }
            else if (c >= 'A' && c <= 'Z'){
                c += gap;
            }
            else if (c == '.' || c == '_' || c == '-'){
                if (c == '.' && last == '.'){
                    continue;
                }   
            }
            else{
                continue;
            }
            
            last = c;
            if (count == 0 && c == '.'){
                continue;
            }
            sb.append(c);
            count++;        
            if (count == 15){
                break;
            }
        }
        answer = sb.toString();
        if (answer.length() == 0){
            answer = "a";
        }
        while (answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0, answer.length()-1);
            if (answer.length() == 0){
                answer = "a";
            }
        }
        
        while(answer.length() < 3){
            answer += answer.charAt(answer.length()-1);
        }
        return answer;
    }
}