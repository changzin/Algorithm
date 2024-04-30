class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l-1; i < r; i++){
            long x = i;
            while(true){
                if (x < 5 && x != 2){
                    answer++;
                    break;
                }
                if (x % 5 == 2) {
                    break;
                }
                x /= 5;
            }
        }
        
        
        return answer;
    }
}