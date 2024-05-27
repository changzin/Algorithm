import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A' + i)), i+1);
        }
        
        int index = 0;
        int key = 26;
        while(true){
            String s = String.valueOf(msg.charAt(index));
            
            // 마지막에 하나 남았을 때
            if (index == msg.length()-1){
                arr.add(map.get(s));
                break;
            }
            
            // 둘 이상 남았을 경우 - 문자열 길이에 유의, 최대한 늘린다
            String next = s;
            while(map.containsKey(next)){
                s = next;
                index++;
                if (index >= msg.length()){
                    break;
                }
                next += String.valueOf(msg.charAt(index));
            }
            arr.add(map.get(s));
            map.put(next, ++key);
            // System.out.println(s);
            // System.out.println(next + ":");
            if (index >= msg.length()){
                break;
            }
        }
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}