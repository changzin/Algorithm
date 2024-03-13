class Solution {
    static boolean[] visit;
    static int health;
    static int ans;
    static int[][] map;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        health = k;
        ans = 0;
        map = dungeons;
        recursion(0);
        
        int answer = ans;
        return answer;
    }
    
    public void recursion(int weight){
        for(int i = 0; i < map.length; i++){
            if (!visit[i] && health >= map[i][0]){
                visit[i] = true;
                health -= map[i][1];
                
                recursion(weight+1);
                
                visit[i] = false;
                health += map[i][1];
            }
        }
        
        ans = Math.max(weight, ans);
        return;
    }
}