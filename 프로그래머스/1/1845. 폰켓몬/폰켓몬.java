import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap();     
        int answer = 0;
        
        for(int n : nums){

            if (!map.containsKey(n)){
                map.put(n, true);
                answer++;
            }
        }
        if (nums.length/2 < answer){
            answer = nums.length/2;
        }
        return answer;
    }
}