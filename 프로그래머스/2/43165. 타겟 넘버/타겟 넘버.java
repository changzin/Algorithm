import java.util.*;

class Solution {
    Queue<Integer> q = new LinkedList();
    int ans;
    int n;
    int tar;
    int[] nums;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;    
        tar = target;
        nums = new int[numbers.length]; 
        for(int i = 0; i < numbers.length; i++){
            nums[i] = numbers[i];
        }
        dfs(0, 0);
        
        int answer = ans;
        return answer;
    }
    
    void dfs(int weight, int value){
        if (weight == n){
            if (value == tar){
                ans++;
            }
            return;
        }
        for(int i = 0; i < 2; i++){
            if (i == 0){
                dfs(weight+1, value + nums[weight]);
            }
            else{
                dfs(weight+1, value - nums[weight]);
            }
        }
    }    
}