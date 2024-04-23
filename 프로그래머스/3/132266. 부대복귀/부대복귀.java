import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    Queue<int[]> q = new LinkedList<>();
    boolean[] visit;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        visit = new boolean[n+1];
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        
        
        int[] answer = bfs(sources, destination);
        return answer;
    }
    
    int[] bfs(int[] sources, int start){
        int node; int weight;
        int[] answer = new int[sources.length];
        int[] distance = new int[graph.size()];
        
        int[] arr = {start, 0};
        q.add(arr);
        
        visit[start] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            node = temp[0];
            weight = temp[1];
            
            distance[node] = weight;
            
            for(int i = 0; i < graph.get(node).size(); i++){
                int next = graph.get(node).get(i);
                if (!visit[next]){
                    visit[next] = true;
                    int[] temp1 = {next, weight+1};
                    q.add(temp1);
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = distance[sources[i]];
            if (sources[i] != start && answer[i] == 0){
                answer[i] = -1;
            }
        }        
        return answer;
    }
}