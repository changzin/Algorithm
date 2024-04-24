import java.util.*;
import java.util.Map.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[][] divisors = new int[e+1][2];
        
        for(int i = 1; i <= e; i++){
            for(int j = 1; j <= (e/i); j++){
                divisors[i*j][0]++;
            }
        }
        
        int max = 0;
        for(int i = e; i >= 1; i--){
            if (divisors[i][0] >= divisors[max][0]){
                divisors[i][1] =  i;    
                max = i;
            }
            else{
                divisors[i][1] = max;
            }
        }
        // for(int i = 1; i <= e; i++){
        //     System.out.println(i + " : " + divisors[i][0] + " " + divisors[i][1]);
        // }
        
        int[] answer = new int[starts.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = divisors[starts[i]][1];
        }
        return answer;   
    }    
}