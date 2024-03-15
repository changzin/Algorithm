import java.util.*;

class Solution {
    List<Node> graph = new ArrayList<>();
    boolean[] visit;
    Queue<Integer> q = new LinkedList();
    
    public int solution(int n, int[][] results) {
        visit = new boolean[n+1];
        graph.add(new Node(0));
        for(int i = 1; i <= n; i++){
            graph.add(new Node(i));
            visit[i] = false;
        }    
        
        for(int i = 0; i < results.length; i++){
            int w = results[i][0];
            int l = results[i][1];
            graph.get(w).loser.add(l);
            graph.get(l).winner.add(w);
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if (bfs(i, 1) + bfs(i, 0) +1 == n){
                answer++;
            }
        }        
        return answer;
    }
    
    public int bfs(int start, int mode){
        visitInit();
        int count = 0;
        q.add(start);
        visit[start] = true;
        while(!q.isEmpty()){
            Node node = graph.get(q.poll());
            List<Integer> list = (mode == 1)?node.winner:node.loser;
            
            
            for(int i = 0; i < list.size(); i++){
                int next = list.get(i);
                if (!visit[next]){
                    visit[next] = true;
                    count++;
                    q.add(next);
                }
            }
        }
        return count;
    }
    
    public int downBfs(int start){
        return 0;
    }
    
    public void visitInit(){
        for(int i = 1; i < visit.length; i++){
            visit[i] = false;
        }
    }
    
    class Node{
        public int id;
        public int order;
        public List<Integer> winner;
        public List<Integer> loser;
        Node(int id){
            this.id = id;
            this.order = 0;
            winner = new ArrayList<>();
            loser = new ArrayList<>();
        }
    }
}