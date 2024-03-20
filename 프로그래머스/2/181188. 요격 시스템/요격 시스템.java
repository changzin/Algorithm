import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        
        // 정렬
        Arrays.sort(targets, (a, b)->{
            if (a[0] != b[0]){
                return a[1] - b[1];
            }
            else{
                return a[0] - b[0];
            }
        });
        
        int num = -1;
        for(int i = 0; i < targets.length; i++){
            if (targets[i][0] >= num) {
                answer++;
                num = targets[i][1];
            }
        }
        return answer;
    }
}