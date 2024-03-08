import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap();
        String ans = "";
        for(String str : participant){
            if (!map.containsKey(str)){
                    map.put(str,1);
            }
            else{
                map.put(str, map.get(str)+1);
            }
        }
        
        for(String str : completion){
            map.put(str, map.get(str)-1);
        }
        
        for(String str : map.keySet()){
            if (map.get(str) != 0){
                ans = str;
                break;
            }
        }
        
        String answer = ans;
        return answer;
    }
}