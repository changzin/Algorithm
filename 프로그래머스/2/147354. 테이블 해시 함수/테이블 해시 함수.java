import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int answer = 0;
        
        
        int num = col - 1;        
        Arrays.sort(data, (a,b)->{
            if (a[num] == b[num])
                return b[0] - a[0];
            return a[num]-b[num];
        });

        
        for(int i = row_begin-1; i <= row_end-1; i++){
            int sum = 0;
            for(int j = 0; j < data[0].length; j++){
                sum += data[i][j] % (i+1);
            }
            answer = answer ^ sum;
        }
        
        return answer;
    }
}