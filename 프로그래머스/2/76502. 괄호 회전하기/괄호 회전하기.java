import java.util.*;

class Solution {
    Stack<Integer> st = new Stack<>();
    
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            boolean check = true;
            st.clear();
            for(int j = 0; j < s.length(); j++){
                int index = j;
                index += i;
                if (index >= s.length()){
                    index -= s.length();
                }
                int x = 0;
                if (s.charAt(index) == '{'){
                    x = 1;
                }
                else if (s.charAt(index) == '}'){
                    x = -1;
                }
                else if (s.charAt(index) == '['){
                    x = 2;
                }
                else if (s.charAt(index) == ']'){
                    x = -2;
                }
                else if (s.charAt(index) == '('){
                    x = 3;
                }
                else if (s.charAt(index) == ')'){
                    x = -3;
                }
                
                if (x < 0){
                    if (st.isEmpty()){
                        check = false;
                        break;
                    }
                    else if (st.pop() != -x){
                        check = false;
                        break;                        
                    }
                }
                else{
                    st.push(x);
                }   
            }
            if (!st.isEmpty()){
                check = false;
            }
            if (check){
                answer++;
            }
        }
        return answer;
    }
}