class Solution {
    int ans;
    
    public int solution(int storey) {
        ans = Integer.MAX_VALUE;
        int answer = 0;
        dfs(storey, 0);
        answer = ans;
        return answer;
    }
    
    void dfs(int floor, int count){
        int count1, count2, value1, value2;
        
        // System.out.println(floor + " " + count);
        
        if (floor == 100000000){
            ans = Math.min(ans, count + 1);
            return;
        }
        if (floor == 0){
            ans = Math.min(ans, count);
            return;
        }
        
        // 한 자리씩 처리 - 커지든지 작아지든지
        for(int i = 10; i <= 100000000; i*=10){
            if (floor == i){
                ans = Math.min(ans, count+1);
                return;
            }
            if (floor % i != 0){
                count1 = (floor % i) / (i/10);
                count2 = 10 - count1;
                value1 = floor - ((i/10) * count1);
                value2 = floor + ((i/10) * count2);
                // System.out.println(count1 + " " + value1);
                dfs(value1, count + count1);
                
                if (count2 < count1+1){
                    dfs(value2, count + count2);                
                }
                break;
            }
        }
    }
}