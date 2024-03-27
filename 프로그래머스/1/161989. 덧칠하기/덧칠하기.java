class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int now = Integer.MIN_VALUE;
        for(int i = 0; i < section.length; i++){
            if (now + m - 1 < section[i]){
                answer++;
                now = section[i];
                // System.out.println(section[i]);
            }
        }
        
        
        return answer;
    }
}