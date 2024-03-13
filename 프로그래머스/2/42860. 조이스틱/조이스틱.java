import java.util.*;

class Solution {
    List<Integer> arr = new ArrayList<>();
    int ans;
    public int solution(String name) {
        int answer, distance, right, left;        
        answer = distance = right = left = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < name.length(); i++){
            int a = name.charAt(i) - 'A';
            int b = ('Z' - name.charAt(i))+1;
            
            if (name.charAt(i) != 'A' && i != 0){
                arr.add(i);
            }            
            answer += Math.min(a, b);
        }

        if (arr.size() >= 1){
            distance = name.length()-1;
            distance = Math.min(distance, name.length() - arr.get(0));
            distance = Math.min(distance, arr.get(arr.size()-1));    
        }
        
        
        if (arr.size() >= 2){
            for(int i = 0; i < arr.size()-1; i++){
                right = arr.get(i);
                left = name.length() - arr.get(i+1);
                int dist = Math.min((right * 2) + left, right + (left*2));
                distance = Math.min(distance, dist);
            }    
        }
        
        answer += distance;
        return answer;
    }
}