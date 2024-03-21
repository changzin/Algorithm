import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int m = board[0].length;

        List<Queue<Integer>> arr = new ArrayList<>();
        Stack<Integer> st = new Stack();
        
        for(int i = 0; i < m; i++){
            arr.add(new LinkedList());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (board[i][j] != 0){
                    arr.get(j).add(board[i][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < moves.length; i++){
            if (arr.get(moves[i]-1).isEmpty()){
                continue;
            }
            else{
                int doll = arr.get(moves[i]-1).poll();
                if (!st.isEmpty()){
                    if (st.peek() == doll){
                        st.pop();
                        answer++;
                    }
                    else{
                        st.add(doll);
                    }
                }
                else{
                    st.add(doll);
                }
            }
        }
        return answer*2;
    }
}