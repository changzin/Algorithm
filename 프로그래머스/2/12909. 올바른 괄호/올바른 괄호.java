import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (c == '('){
                st.push(c);
            }
            else {
                if (st.isEmpty()){
                    answer = false;
                    break;
                }
                char a = st.pop();
                if (a == ')'){
                    answer = false;
                    break;
                }
            }
        }
        if (!st.isEmpty()){
            answer = false;
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}