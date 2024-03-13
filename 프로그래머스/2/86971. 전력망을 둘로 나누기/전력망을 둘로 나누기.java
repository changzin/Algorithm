import java.util.*;

class Solution {
    List<List<Integer>> graph;
    boolean[] visit;
    int count = 0;
    
    public int solution(int n, int[][] wires) {
        visit = new boolean[n+1];
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 그래프 생성
        for(int i = 0; i < wires.length; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int i = 0; i < wires.length; i++){
            count = 0;
            // 이미 방문했다고 치면 갈 수가 없게됨.
            visit[wires[i][0]] = true;
            
            dfs(wires[i][1]);      
            resetVisit();
            answer = Math.min(answer, Math.abs(n - (count*2)));
        }
        
        return answer;
    }
                  
    public void dfs(int node){
        visit[node] = true;
        count++;
        for(int i = 0; i < graph.get(node).size(); i++){
            int next = graph.get(node).get(i);
            if (!visit[next]){
                dfs(next);
            }
        }
    }
                  
    public void resetVisit(){
        for(int i = 0; i < visit.length; i++){
            visit[i] = false;
        }
    }
}