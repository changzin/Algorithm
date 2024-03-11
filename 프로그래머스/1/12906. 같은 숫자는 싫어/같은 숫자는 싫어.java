import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> arrList = new ArrayList<>();
        int last = -1;
        
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == last){
                continue;
            }
            else{
                last = arr[i];
                arrList.add(arr[i]);
            }
        }
        
        
        int[] answer = new int[arrList.size()];
        
        for(int i = 0; i < arrList.size(); i++){
            answer[i] = arrList.get(i);
        }

        return answer;
    }
}