import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap();
        int ans = 1;
        
        for(int i = 0; i < clothes.length; i++){
            if (!map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], 1);
            else
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
        } 
        
        for (String str : map.keySet()){
            ans *= map.get(str)+1;
        }
        ans -= 1;
        
        int answer = ans;
        return answer;
    }
}