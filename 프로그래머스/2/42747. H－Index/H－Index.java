import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> arr = new ArrayList<>();
        int h;
        for(int i = 0; i < citations.length; i++){
            arr.add(citations[i]);
        }
        arr.sort((a, b) -> b-a);

        h = 0;
        for(int i = 0; i < arr.size(); i++){
            if (arr.get(i) >= i+1){
                h = i+1;
            }
        }
        
        int answer = h;
        return answer;
    }
}