class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        double rr1 = Math.pow(r1, 2);
        double rr2 = Math.pow(r2, 2);

        for(int i = 1; i <= r2; i++){
            double x1 = Math.sqrt(rr1 - Math.pow(i, 2));
            double x2 = Math.sqrt(rr2 - Math.pow(i, 2));
            answer += ((long)x2 - (long)Math.ceil(x1) + 1);   
        }
        
        // 원 사이의 값을 구하려면, 
        return answer*4;
    }
}