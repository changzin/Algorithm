import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int count = 0;
        int index = 0;
        int len = number.length();
        
        Stack<Character> st2 = new Stack<>();
        
        while(index != len){
            // 다 버렸을 경우 나머지를 스택에 넣는다.
            if (count == k){
                for(int i = index; i < len; i++){
                    // System.out.println("마지막으로 추가하는 것 : " + number.charAt(index));
                    st2.push(number.charAt(i));
                }
                break;
            }
            // 스택이 비었을 경우 하나는 그냥 가져온다.
            else if (st2.isEmpty()){
                // System.out.println("스택이 비어서 추가하는 것 : " + number.charAt(index));
                st2.push(number.charAt(index++));
            }
            // 스택의 것이 더 큰 경우 스택에 밀어넣는다.
            else if (st2.peek() >= number.charAt(index)){
                // System.out.println("스택이 더 커서 추가하는 것 : " + number.charAt(index));
                st2.push(number.charAt(index++));
            }
            // 스택의 것이 더 작은 경우 스택 것을 버린다.
            else{
                // System.out.println("스택이 더 작아서 버리는 것 : " + st2.peek());
                st2.pop();
                count++;
            }
        }
        
        for(int i = 0; i < k - count; i++){
            st2.pop();
        }
        String answer = "";      
        while(!st2.isEmpty()){
            answer = st2.pop() + answer;            
        }
        
        return answer;
    }
}