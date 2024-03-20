class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeros = 0;
        int point = 0;
        int x, y;
        for(int i = 0; i < lottos.length; i++){
            if (lottos[i] == 0){
                zeros++;
            }
            else{
                for(int j = 0; j < win_nums.length; j++){
                    if (lottos[i] == win_nums[j]){
                        point++;
                        break;
                    }
                }
            }
        }
        
        x = 7-(point + zeros);
        y = 7-(point);
        
        x = (x > 6) ? 6 : x;
        y = (y > 6) ? 6 : y;
        
        
        
        int[] answer = {x, y};
        return answer;
    }
}