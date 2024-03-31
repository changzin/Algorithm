import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[26];
        
        for(int i = 0; i < skip.length(); i++){
            check[skip.charAt(i) - 'a'] = true;
        }
        
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            int count = 0;
            while(count < index){
                idx++;
                idx %= 26;
                if (check[idx]){
                    continue;
                }
                count++;
            }
            sb.append((char)(idx + 'a'));
        }
        answer = sb.toString();
        return answer;
    }
}