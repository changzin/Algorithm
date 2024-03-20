import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] arr = {"R", "T", "C", "F", "J", "M", "A", "N"};
        // R, T  >> C, F >> J, M >> A, N
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], 0);
        }
        for(int i = 0; i < choices.length; i++){
            String a = Character.toString(survey[i].charAt(0));
            String b = Character.toString(survey[i].charAt(1));
            switch(choices[i]){
                case 1:
                    map.put(a, map.get(a)+3);
                    break;
                case 2:
                    map.put(a, map.get(a)+2);
                    break;
                case 3:
                    map.put(a, map.get(a)+1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(b, map.get(b)+1);
                    break;
                case 6:
                    map.put(b, map.get(b)+2);
                    break;
                case 7:
                    map.put(b, map.get(b)+3);
                    break;
            }
        }
        
        String answer = "";
        for(int i = 0; i < 4; i++){
            int a = map.get(arr[i*2]);
            int b = map.get(arr[(i*2)+1]);
            
            if (a >= b){
                answer += arr[i*2];
            }
            else{
                answer += arr[(i*2)+1];
            }
        }
        
        return answer;
    }
}