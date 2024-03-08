import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap();
        boolean[] len = new boolean[30];
        boolean ans = true;
        
        // 존재하는 전화번호의 길이들 체크
        for(String str : phone_book){
            len[str.length()] = true;
        }
        
        for(String str : phone_book){
            for(int i = 1; i < 30; i++){
                if (len[i]){
                    // 확인하는 길이가 현재 전화번호보다 길어지면 탈출
                    if (str.length() < i){
                        break;
                    }
                    // 부분문자열 생성 
                    String s = str.substring(0, i);    
                    if (map.containsKey(s)){
                        if (i == str.length() || !map.get(s))
                            ans = false;
                    }
                    
                    if (i == str.length()){
                        map.put(s, false);
                    }
                    else{
                        map.put(s, true);                           
                    }
                }
            }
        }
        
        boolean answer = ans;
        return answer;
    }
}