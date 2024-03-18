class Solution {
    // 순서대로 우선순위가 높다.
    char[] arr = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int nx, ny, nDist;
        int distance = Math.abs(x - r) + Math.abs(y - c);
        int dummy = k - distance; // 허비할 수 있는 움직임
        
        // 2로 나누었을 때 맞아떨어지지 않거나 거리가 k보다 멀다면 불가능이다.
        if (distance % 2 != k % 2 || distance > k){
            answer = "impossible";
        }
        else{
            // 목적지에 도착할 때까지
            while(answer.length() != k){
                // 4방향 체크함(우선순위 높은 순으로)
                for(int i = 0; i < 4; i++){
                    nx = x + dx[i];
                    ny = y + dy[i];
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= m){
                        nDist = Math.abs(nx - r) + Math.abs(ny - c);
                        // 시간 허비하는 움직임이 아닐 때
                        if (nDist < distance){
                            distance = nDist;
                            answer += arr[i];
                            x = nx;
                            y = ny;
                            break;
                        }
                        // 시간 허비하는 움직임일 때
                        else if (dummy > 0){
                            dummy -= 2;
                            distance++;
                            answer += arr[i];
                            x = nx;
                            y = ny;
                            break;
                        }
                    }
                }
            }
        }
                
        
        return answer;
    }
}