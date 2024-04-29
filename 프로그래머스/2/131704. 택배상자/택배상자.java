import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        List<int[]> arr = new ArrayList<>();
        
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < order.length; i++){
            int[] temp = {i, order[i]};
            arr.add(temp);
        }
        arr.sort((a,b)->a[1]-b[1]);
        
        int index = 0;
        for(int i = 0; i < arr.size(); i++){
            st.add(arr.get(i));
            if (!st.isEmpty()){
                while(st.peek()[0] == index){
                    st.pop();
                    index++;
                    answer++;
                    if (st.isEmpty()){
                        break;
                    }
                }
            }
        }
        return answer;
    }
}