import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (st.empty()){
                st.push(c);
            }
            else if (st.peek() == c){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        
        int answer = (st.empty()) ? 1 : 0;
        return answer;
    }
}