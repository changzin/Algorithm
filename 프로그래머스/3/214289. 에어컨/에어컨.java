class Solution {
    int[][] dp = new int[1000][51];
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
    
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 51; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int line = 0;    
        int line2 = 0;
        // 감소해야 하는지, 증가해야하는지를 체크하고 증가해야 하는  조건으로 치환함.
        boolean cool = (temperature < t1) ? true : false;
        if (!cool){
            line = -t2 + 40;
            line2 = -t1 + 40;
            temperature = -temperature + 40;
        }
        else{
            line = t1 + 10;
            line2 = t2 + 10;
            temperature += 10;
        }
        
        dp[0][temperature] = 0;
        int last = 0;
        
        
        for(int i = 1; i < onboard.length; i++){
            if (onboard[i] == 1){
                last = i;
            }
            
            for(int j = 0; j < 51; j++){
                // 승객이 탑승했지만 온도가 범위에 들어가지 않은 경우
                if (onboard[i] == 1 && (j < line || j > line2)){
                    continue;
                }
                // 실내외 온도가 동일한 경우
                if (j == temperature){
                    dp[i][j] = dp[i-1][j];
                }
                // 에어컨을 켜서 온도를 유지하는 경우
                if (dp[i-1][j] != Integer.MAX_VALUE){                    
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + b);
                }
                // 에어컨을 켜서 온도를 올린 경우
                if (j != 0 && dp[i-1][j-1] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + a);
                }
                // 에어컨을 꺼서 온도가 내려간 경우
                if (j != 50 && dp[i-1][j+1] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                }
            }
        }
        // 마지막에 승객이 적정온도에 있었던 때까지의 전력 사용량이 전력 사용의 최소치
        int answer = 0;

        answer = dp[last][line];
        
        return answer;
    }
}