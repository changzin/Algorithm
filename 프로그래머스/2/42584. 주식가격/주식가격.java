import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Pair> st = new Stack<>();
        int index = 1;
        int answer[] = new int[prices.length];
        st.push(new Pair(0, prices[0]));

        
        while(true){
            if (index == prices.length){
                break;
            }
            // prices[index]의 값이 stack의 top보다 높아 그냥 넣으면 될 때
            if (st.isEmpty()){
                st.push(new Pair(index, prices[index]));
            }
            else if (st.peek().value <= prices[index]){
                st.push(new Pair(index, prices[index]));
            }
            // stack에서 값을 빼내야 할 때
            else{
                while(true){
                    if (st.isEmpty()){
                        st.push(new Pair(index, prices[index]));
                        break;
                    }
                    if (st.peek().value > prices[index]){
                        Pair p = st.pop();
                        answer[p.id] = index - p.id;
                    }
                    else{
                        st.push(new Pair(index, prices[index]));
                        break;
                    }
                }
            }
            index++;
        }
        while(!st.isEmpty()){
            Pair p = st.pop();
            answer[p.id] = prices.length-1 - p.id;
        }
        return answer;
    }
    
    public class Pair{
        public int id;
        public int value;
        Pair(int id, int value){
            this.id = id;
            this.value = value;
        }
    }
}