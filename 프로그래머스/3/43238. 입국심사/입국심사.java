import java.util.*;

class Solution {
    public long solution(int n, int[] times) {    
     
        Arrays.sort(times);

        long maxTime = (long)times[0] * n;
        long minTime = 1;
        long answer = maxTime;
        
        while(maxTime >= minTime){
            long averageTime = (maxTime + minTime) / 2;
            int num = 0;
            
            for(int i = 0; i < times.length; i++){
                num += averageTime / times[i];
                if (num >= n) break;
            }
            
            if (num < n){
                minTime = averageTime + 1;
            }
            else{
                answer = Math.min(answer, averageTime);
                maxTime = averageTime-1;
            }
            
            
        }
        return answer;
    }    
}