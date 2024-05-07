import java.util.*;

class Solution {
    StringTokenizer st;
    StringBuilder br = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    
    public String solution(int n, int k, String[] cmd) {
        int[] next = new int[n];
        int[] prev = new int[n];
        int[] save = new int[n];
        
        int pos = k;
        String first;
        int second;
        
        for(int i = 0; i < n; i++){
            next[i] = i+1;
            prev[i] = i-1;
            save[i] = 1;
        }
        
        second = 0;
        for(int i = 0; i < cmd.length; i++){
            st = new StringTokenizer(cmd[i], " ");
            first = st.nextToken();
            // 첫 명령어로 구분
            if (first.equals("U")){
                second = Integer.parseInt(st.nextToken());
                for(int j = 0; j < second; j++){
                    pos = prev[pos];
                }
            }
            else if (first.equals("D")){
                second = Integer.parseInt(st.nextToken());
                for(int j = 0; j < second; j++){
                    pos = next[pos];
                }
            }
            else if (first.equals("C")){
                stack.push(pos);
                save[pos] = 0;
                int prevNode = prev[pos];
                int nextNode = next[pos];
                if (prevNode != -1){
                    next[prevNode] = nextNode;
                }
                if (nextNode != n){
                    prev[nextNode] = prevNode;
                    pos = nextNode;
                }
                else{
                    pos = prevNode;
                }
            }
            else{
                int rollback = stack.pop();
                save[rollback] = 1;
                int prevNode = prev[rollback];
                int nextNode = next[rollback];
                if (prevNode != -1){
                    next[prevNode] = rollback;
                }
                if (nextNode != n){
                    prev[nextNode] = rollback;
                }                
            }
            // System.out.println(first + " " + second);
            // System.out.println(pos);
            // print(save);
            // print(next);
            // print(prev);
        }
        
        String answer = "";
        for(int i = 0; i < save.length; i++){
            if (save[i] == 0){
                br.append("X");
            }
            else{
                br.append("O");
            }
        }
        
        
        return br.toString();
    }    
    
    void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}