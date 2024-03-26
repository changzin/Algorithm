import java.util.*;

class Solution {
    public long solution(int[] weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < weights.length; i++){
            if (!map2.containsKey(weights[i])) map2.put(weights[i], 1);
            else map2.put(weights[i], map2.get(weights[i])+1);
            
            for(int j = 2; j <= 4; j++){
                if (!map.containsKey(weights[i]*j)) map.put(weights[i]*j, 1);
                else map.put(weights[i]*j, map.get(weights[i]*j)+1);        
            }
        }
        
        Long answer = 0L;
        Set<Integer> sets = map.keySet();
        Set<Integer> sets2 = map2.keySet();
        for(Integer k : sets){
            // System.out.println(k + "   -   " + map.get(k));
            answer += combination((long)map.get(k));
            // System.out.println(answer);
        }
        for(Integer k : sets2){
            // System.out.println(k + "   -   " + map2.get(k));
            answer -= combination((long)map2.get(k)) * 2;
            // System.out.println(answer);
        }
        
        return answer;
    }
    
    long combination(long x) {
        return (x * (x-1)) / 2;
    }
    
}