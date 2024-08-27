import java.util.*;

class Solution {
    int[][] map;
    int[][] tmap;
    int yLength;
    int xLength;
    boolean[] yVisit;
    int answer;
    
    public int solution(int[][] beginning, int[][] target) {    
        // 변수 입력
        map = beginning;
        tmap = target;
        yLength = beginning.length;
        xLength = beginning[0].length;
        yVisit = new boolean[xLength];
        answer = Integer.MAX_VALUE;
        
        dfs(0, 0);
        if (answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;
    }
    
    void dfs(int depth, int rowNum){
        // System.out.println(depth + " " + rowNum);
        // print();
        // 일치하는지 체크
        if (answerCheck()){
            answer = Math.min(answer, depth);
            return;
        }
        
        // 현재 구한 답보다 더 많이 돌렸다면 무조건 리턴한다.
        if (depth >= answer){
            return;
        }
        
        if (rowNum == yLength){
            return;
        }
        
        // 백트래킹을 위한 맵을 따로 만들어놓는다.
        int[][] backup = new int[yLength][xLength];
        boolean[] backup2 = new boolean[xLength];
        boolean check = true;
        int nextDepth = depth;
        
        for(int i = 0; i < yLength; i++){
            for(int j = 0; j < xLength; j++){
                backup[i][j] = map[i][j];
            }
        }
        for(int i = 0; i < xLength; i++){
            backup2[i] = yVisit[i];
        }
        
        // 행을 뒤집지 않는 경우의 수
        for(int i = 0; i < xLength; i++){
            if (map[rowNum][i] == tmap[rowNum][i]){
                continue;
            }
            else if (map[rowNum][i] != tmap[rowNum][i] && !yVisit[i]){
                colBound(i);
                yVisit[i] = true;
                nextDepth++;
            }
            else{
                check = false;
                break;
            }
        }
        
        // 만약 Col을 뒤집는 일이 겹치지 않는다면 다음 depth로 넘어갈 수 있다.
        if (check){
            dfs(nextDepth, rowNum+1);
        }
        
        // 두 번째 가짓수를 위해서 맵 상태를 복원한다.
        check = true;
        map = backup;
        yVisit = backup2;
        nextDepth = depth;
        
        // 행을 뒤집는 경우의 수
        rowBound(rowNum);
        nextDepth++;
        for(int i = 0; i < xLength; i++){
            if (map[rowNum][i] == tmap[rowNum][i]){
                continue;
            }
            else if (map[rowNum][i] != tmap[rowNum][i] && !yVisit[i]){
                colBound(i);
                yVisit[i] = true;
                nextDepth++;
            }
            else{
                check = false;
                break;
            }
        }   
        if (check){
            dfs(nextDepth, rowNum+1);    
        }
        check = true;
        map = backup;
        yVisit = backup2;
        return;
    }
    
    void rowBound(int row){
        for(int i = 0; i < xLength; i++){
            map[row][i] = (map[row][i] == 1) ? 0 : 1;
        }
        return;
    }
    
    void colBound(int col){
        for(int i = 0; i < yLength; i++){
            map[i][col] = (map[i][col] == 1) ? 0 : 1;
        }
        return;
    }
    
    boolean answerCheck(){
        for(int i = 0; i < yLength; i++){
            for(int j = 0; j < xLength; j++){
                if (map[i][j] != tmap[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    void print(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + "");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("visit");
        for(int j = 0; j < yVisit.length; j++){
            System.out.print(yVisit[j] + "");
        }
        System.out.println("");
    }
}