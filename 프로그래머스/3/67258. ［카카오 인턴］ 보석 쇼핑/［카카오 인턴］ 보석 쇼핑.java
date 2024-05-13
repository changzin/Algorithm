import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        
        // 탐색하는 인덱스의 가장 가까운, 앞에 있는 원소들 넘버 체크
        Map<String, Integer> map = new HashMap<>();
        int dp[] = new int[gems.length];
        int length, start, end, kinds;
        
        map.put(gems[0], 0);
        dp[0] = 0;
        length = 0;
        kinds = 1;
        start = end = 0;
        
        for(int i = 1; i < gems.length; i++){
            // 갱신하거나 새로 넣음.
            map.put(gems[i], i);
            if (!map.containsKey(gems[i])){
                dp[i] = dp[i-1];
            }
            // 만약 새로운 게 아니고  업데이트 할 수 있다는 신호. 
            else if (gems[dp[i-1]].equals(gems[i])){
                // start와 i 인덱스의 보석 종류가 같다면 업데이트 가능
                Iterator<Integer> iter = map.values().iterator();
                int minValue = Integer.MAX_VALUE;
                while(iter.hasNext()){
                    minValue = Math.min(iter.next(), minValue);
                }
                dp[i] = minValue;
            }
            else{
                dp[i] = dp[i-1];
            }
            
            // System.out.println(i);
            // System.out.println("  " + start + " : " + end);
            // System.out.println("  " + set.size() + " ? " + kinds);
            // System.out.println("  " + (i - dp[i] + 1) + " ? " + length);
            if (kinds < map.size()){
                length = i - dp[i] + 1;
                kinds = map.size();
                start = dp[i];
                end = i;
            }
            else if (kinds == map.size() && length > i - dp[i] + 1){
                length = i - dp[i] + 1;
                start = dp[i];
                end = i;
            }
        }

        int[] answer = {start+1, end+1};
        return answer;
    }    
}