import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int len = rocks.length;
        
        Arrays.sort(rocks);
        
        int maxValue = distance;
        int minValue = 0;
        
        while(maxValue >= minValue){            
            int averageValue = (maxValue + minValue) / 2;
            // System.out.println(averageValue);
            int now = 0;
            int num = 0;
            for(int i = 0; i < len+1; i++){
                if (i == len){
                    if (distance - now < averageValue) num++;
                }
                else if (rocks[i] - now < averageValue) num++;
                else now = rocks[i];
                
            }
            
            if (num > n){
                maxValue = averageValue-1;
            }
            else{
                minValue = averageValue+1;
                answer = Math.max(answer, averageValue);
            }
            
        }
        
        
        return answer;
    }
}