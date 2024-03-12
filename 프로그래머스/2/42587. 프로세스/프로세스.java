import java.util.*; 

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int count[] = new int[10];
        int top = 9;
        int index = 0;
        int cnt = 0;
        
        for(int i = 0; i < priorities.length; i++){
            count[priorities[i]]++;
        }
        
        while(true){
            while (count[top] == 0){
                top--;
                if (top == -1){
                    break;
                }
            }
            
            int node = priorities[index];
            if (node == top){
                cnt++;
                if (node == priorities[location]){
                    if (index == location){
                        answer = cnt;
                        break;
                    }
                }
                priorities[index] = -1;
                count[top]--;
            }
            
            index++;
            if (index == priorities.length){
                index = 0;
            }
        }
        
        return answer;
    }
}