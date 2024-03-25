import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> sMap = new HashMap<>();
        HashMap<Integer, String> iMap = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            sMap.put(players[i], i);
            iMap.put(i, players[i]);
        }
        
        for(int i = 0; i < callings.length; i++){
            int a = sMap.get(callings[i]);
            String b = iMap.get(a-1);
            sMap.put(callings[i], a-1);
            sMap.put(b, a);
            iMap.put(a-1, callings[i]);
            iMap.put(a, b);
        }
        
                
        String[] answer = new String[players.length];
        
        for(int i = 0; i < players.length; i++){
            answer[i] = iMap.get(i);
        }
        
        return answer;
    }
}