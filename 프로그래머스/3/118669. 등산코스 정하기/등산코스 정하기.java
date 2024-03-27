import java.util.*;

class Solution {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    // 1 : gates, 2 : summmits, 0 : paths
    int[] nodes = new int[50001];
    int[] dist = new int[50001];
    int minWeight, minNode, len;
    List<List<Edge>> graph = new ArrayList<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        len = n;
        for(int i = 0; i <= len; i++){
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < gates.length; i++){
            nodes[gates[i]] = 1;
        }
        for(int i = 0; i < summits.length; i++){
            nodes[summits[i]] = 2;
        }
        for(int i = 0; i < paths.length; i++){
            graph.get(paths[i][0]).add(new Edge(paths[i][1], paths[i][2]));
            graph.get(paths[i][1]).add(new Edge(paths[i][0], paths[i][2]));
        }
        
        minNode = minWeight = Integer.MAX_VALUE;
        
        for(int i = 0; i < gates.length; i++){
            initDist();
            bfs(gates[i]);
        }
        
        
        int[] answer = {minNode, minWeight};
        return answer;
    }
    
    void bfs(int start){
        
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int node = e.x;
            int weight = e.weight;
            
            // 경로 중 가장 큰 엣지가 현재 최소값보다 큰 경우 나간다.
            if (weight > minWeight){
                break;
            }
            
            for(int i = 0; i < graph.get(node).size(); i++){
                Edge edge = graph.get(node).get(i);
                int next = edge.x;
                int nextWeight = edge.weight;
                
                if (nodes[next] != 1){
                    if (dist[next] > nextWeight && dist[next] > dist[node]){
                        int nextDistance = Math.max(weight, nextWeight);
                        dist[next] = nextDistance;                        
                        if (nodes[next] == 2){
                            if (minWeight > nextDistance || (minWeight == nextDistance && next < minNode)){
                                minWeight = nextDistance;
                                minNode = next;
                            }
                        }
                        else{
                            pq.add(new Edge(next, nextDistance));
                        }
                    }                    
                }
            }
            
        }
        while(!pq.isEmpty()){
            pq.poll();
        }
    }
    void initDist(){
        for(int i = 0; i < len; i++){
            dist[i] = Integer.MAX_VALUE;
        }
    }
    class Edge implements Comparable<Edge>{
        int x;
        int weight;
        Edge(int x, int weight){
            this.x = x;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e){
            if (this.weight == e.weight){
                return this.x-e.x;
            }
            return this.weight-e.weight;
        }
    }
}