import java.util.*;

class Solution {
    Queue<Pair> q = new LinkedList<>();
    int start, end, plus, ans;
    boolean visit[] = new boolean[1000001];

    public int solution(int x, int y, int n) {
        start = x; end = y; plus = n; ans = -1;
        
        bfs();
        
        int answer = ans;
        return answer;
    }
    
    void bfs(){
        int num, weight;
        num = weight = 0;
        
        q.add(new Pair(start, 0));
        visit[start] = true;
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            num = pair.first;
            weight = pair.second;
            if (num == end){
                ans = weight;
            }
            for (int i = 1; i <= 3; i++){
                int nextNum = 0;
                
                if (i == 1) nextNum = num + plus;
                if (i == 2) nextNum = num * 2;
                if (i == 3) nextNum = num * 3;
                
                if (nextNum <= 1000000){
                    if (!visit[nextNum]){
                        q.add(new Pair(nextNum, weight+1));
                        visit[nextNum] = true;
                    }
                }    
            }
        }
        
    }
    
    class Pair{
        int first;
        int second;
        
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}