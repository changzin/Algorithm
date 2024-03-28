import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                String temp = keymap[i].charAt(j) + "";
                if (map.containsKey(temp)){
                    map.put(temp, Math.min(map.get(temp), j+1));
                }
                else{
                    map.put(temp, j+1);
                }
            }
        }

        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++){
            int num = 0;
            for(int j = 0; j < targets[i].length(); j++){
                String temp = targets[i].charAt(j) + "";
                if (!map.containsKey(temp)) {
                    num = -1;
                    break;
                }
                num += map.get(temp);
            }    
            answer[i] = num;
        }
        
        return answer;
    }
}