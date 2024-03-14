import java.util.*;

class Solution {
    boolean[] visit;
    int[][] graph;
    
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            visit[i] = false;
        }
        graph = computers;
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if (visit[i]){
                continue;
            }
            else{
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    void dfs(int node){
        visit[node] = true;
        for(int i = 0; i < graph[node].length; i++){
            if (graph[node][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }
}