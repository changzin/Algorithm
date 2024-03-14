import java.util.*;

class Solution {
    String[] arr;
    String start, end;
    boolean[] visit;
    Queue<Node> q = new LinkedList();
    
    public int solution(String begin, String target, String[] words) {
        arr = words;
        start = begin;
        end = target;
        visit = new boolean[words.length];
        int answer = bfs();
        
        return answer;
    }
    
    int bfs(){
        q.add(new Node(start, 0));
        int len = start.length();
        while(!q.isEmpty()){
            Node node = q.poll();
            int weight = node.weight;
            String str = node.str;
            if (str.equals(end)){
                return weight;
            }
            for(int i = 0; i < arr.length; i++){
                if (!visit[i]){
                    int gap = 0;
                    for(int j = 0; j < len; j++){
                        if (arr[i].charAt(j) != str.charAt(j)){
                            gap++;
                        }
                    }
                    if (gap == 1){
                        visit[i] = true;
                        q.add(new Node(arr[i], weight+1));
                    }
                }
            }
        }
        return 0;
    }
    
    class Node{
        public String str;
        public int weight;
        
        Node(String str, int weight){
            this.str = str;
            this.weight = weight;
        }
    }
}