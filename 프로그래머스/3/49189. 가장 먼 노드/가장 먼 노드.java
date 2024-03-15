import java.util.*;

class Solution {
    int nodeNum, maxDist;
    List<List<Integer>> graph = new ArrayList<>();
    Queue<Node> q = new LinkedList();
    List<Node> arr = new ArrayList<>();
    boolean[] visit;
    int ans;
    public int solution(int n, int[][] edge) {
        visit = new boolean[n];
        nodeNum = n;
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
            visit[i] = false;
        }
        for(int i = 0; i < edge.length; i++){
            graph.get(edge[i][0]-1).add(edge[i][1]-1);
            graph.get(edge[i][1]-1).add(edge[i][0]-1);
        }
        bfs();
        arr.forEach((a)-> {
            if (a.weight == maxDist){
                ans++;
            }
        });
        return ans;
    }
    void bfs(){
        visit[0] = true;
        q.add(new Node(0, 0));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.node;
            int w = node.weight;
            for(int i = 0; i < graph.get(x).size(); i++){
                int next = graph.get(x).get(i);
                if (!visit[next]){
                    visit[next] = true;
                    maxDist = Math.max(maxDist, w+1);
                    arr.add(new Node(next, w+1));
                    q.add(new Node(next, w+1));
                }
            }
        }
    }
    class Node{
        int node;
        int weight;
        
        Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
}