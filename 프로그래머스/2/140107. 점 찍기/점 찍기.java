class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int num = d / k;
        
        // x좌표
        for(int i = 0; i <= d; i+=k){            
            long distance = d;
            long x = i;            
            int limit = (int)Math.floor(Math.sqrt(Math.pow(distance, 2)-Math.pow(x, 2)));            
            answer += limit / k + 1;            
        }
        
        return answer;
    }
    
    boolean checkDistance(int x, int y, int d){
        long a = x;
        long b = y;
        long c = d;
        if (a*a + b*b <= c*c){
            return true;
        }
        return false;
    }
}