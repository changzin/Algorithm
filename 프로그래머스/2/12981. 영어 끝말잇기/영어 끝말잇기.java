import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> set = new HashSet<>();
        int count = 0;
        int person = 0;
        for(int i = 0; i < words.length; i++){
            if (i % n == 0){
                count++;
                person = 0;
            }
            person++;
            String s = words[i];
            if (i == 0){
                set.add(s);
                continue;
            }
            if (s.length() == 1){
                break;
            }
            
            if (words[i-1].charAt(words[i-1].length()-1) != s.charAt(0)){
                break;
            }
            if (set.contains(s)){
                break;
            }
            set.add(s);
            
            if (i == words.length-1){
                person = 0;
                count = 0;
            }
        }
        
        int[] answer = {person, count};

        

        return answer;
    }
}