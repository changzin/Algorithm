import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        List<int[]> arr = new ArrayList<>();
        int x = 0;
        int y = 0;
        for(int i = 0; i < dirs.length(); i++){
            int nx, ny, dir;
            if (dirs.charAt(i) == 'U'){
                dir = 1;
            }
            else if (dirs.charAt(i) == 'D'){
                dir = 0;
            }
            else if (dirs.charAt(i) == 'R'){
                dir = 2;
            }
            else{
                dir = 3;
            }
            
            // 새로운 좌표를 구했다.
            nx = x + dx[dir];
            ny = y  +dy[dir];
            
            // 새 좌표가 범위 안에 있는지 먼저 확인(움직일 수 있는지)
            if (nx >= -5 && ny >= -5 && nx <= 5 && ny <= 5){
                boolean check = true;
                for (int j = 0; j < arr.size(); j++){
                    int[] temp = arr.get(j);
                    
                    if (temp[0] == x && temp[1] == y && temp[2] == nx && temp[3] == ny){
                        check = false;
                        break;
                    }
                    else if(temp[0] == nx && temp[1] == ny && temp[2] == x && temp[3] == y){
                        check = false;
                        break;
                    }
                }
                if (check){
                    int[] temp = {x, y, nx, ny};
                    arr.add(temp);
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }
        
        
        return answer;
    }
}