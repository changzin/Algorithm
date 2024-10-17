import java.util.*;

class Solution {
    public String solution(String s) {
        List<String> arr = new ArrayList<>();
        List<String> newArr = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            arr.add(st.nextToken());
        }
        
        for(int i = 0; i < arr.size(); i++){
            
            String word = arr.get(i); // try
            String newWord = ""; // TrY
            
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if (j % 2 == 0){
                    // 소문자인 경우 대문자로 바뀜
                    if (c >= 'a' && c <= 'z'){
                        c = (char)((int)c + ('A' - 'a'));
                    }  
                }
                else{
                    if (c >= 'A' && c <= 'Z'){
                        c = (char)((int)c - ('A' - 'a'));
                    }  
                }
                newWord += c;
            }
            newArr.add(newWord);
        }
        
        int index = 0;
        int arrIndex = 0;
        
        String answer = "";
            
        while(index < s.length()){
            if (s.charAt(index) == ' '){
                answer += ' ';
                index++;
            }
            else{
                index += newArr.get(arrIndex).length();
                answer += newArr.get(arrIndex);
                arrIndex++;
            }
        }
        return answer;
    }
}