import java.util.*;

class Solution {
    List<Puzzle> puzzles = new ArrayList<>();
    Queue<Point> q = new LinkedList();
    boolean[] visit;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int[][] map;
    int[][] game_map;
    int length;
    int answer;
    public int solution(int[][] game_board, int[][] table) {
        map = table;
        game_map = game_board;
        length = table.length;
        
        // 퍼즐들을 뽑아내서 puzzles에 저장
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if (table[i][j] == 1){
                    puzzles.add(bfs(i, j, 1));
                }
            }
        }
        visit = new boolean[puzzles.size()];
        
        // gameboard를 4방향 돌려가며 빈칸을 puzzle로 뽑아낸다.
        // puzzles 중 puzzle과 일치하는 것이 있다면, map을 수정하고 visit로 표시한다.
        for(int i = 0; i < 4; i++){
            initMap();
            for(int j = 0; j < length; j++){
                for(int k = 0 ; k < length; k++){
                    if (game_map[j][k] == 0){
                        bfs(j, k, 0);
                    }
                }
            }
            game_map = rotate(game_map);
        }
        return answer;
    }
    
    void initMap(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if (game_map[i][j] == 2){
                    game_map[i][j] = 0;
                }
            }
        }
    }
    
    int[][] rotate(int[][] arr){
        int[][] map = new int[length][length];
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                map[i][j] = arr[j][length-i-1];
            }
        }
        
        return map;
    }
    
    // puzzles 중 puzzle과 일치하는 게 있는지 체크하고, 있다면 answer, game_map을 update
    void checkPuzzles(Puzzle puzzle, int sx, int sy){
        for(int i = 0; i < puzzles.size(); i++){
            if (!visit[i] && puzzle.isEqual(puzzles.get(i))){
                visit[i] = true;
                answer += puzzle.length;
                
                for(int j = 0; j < puzzle.arr.size(); j++){
                    game_map[sx + puzzle.arr.get(j).x][sy+puzzle.arr.get(j).y] = 1;
                }
                break;
            }
        }
    }
    
    
    // puzzle로 반환한다.
    Puzzle bfs(int sx, int sy, int mode){
        int x, y, nx, ny;
        List<Point> arr = new ArrayList<>();
        
        q.add(new Point(sx, sy));
        arr.add(new Point(0, 0));
        
        if (mode == 1){
            map[sx][sy] = 0;
        }
        else{
            game_map[sx][sy] = 2;
        }
        
        while(!q.isEmpty()){
            Point p = q.poll();
            x = p.x;
            y = p.y;
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && nx < length && ny >= 0 && ny < length){
                    if (mode == 1 && map[nx][ny] == 1){
                        arr.add(new Point(nx-sx, ny-sy));
                        q.add(new Point(nx, ny));
                        map[nx][ny] = 0;
                    }
                    else if (mode == 0 && game_map[nx][ny] == 0){
                        arr.add(new Point(nx-sx, ny-sy));
                        q.add(new Point(nx, ny));
                        game_map[nx][ny] = 2;
                    }
                }
            }
        }
        Puzzle puzzle = new Puzzle(arr);
        
        if (mode == 0){
            checkPuzzles(puzzle, sx,sy);
        }
        
        return puzzle;
    }
    
    class Puzzle{
        List<Point> arr;
        int length;
        Puzzle(List<Point> arr){
            this.arr = arr;
            this.length = arr.size();
        }
        
        boolean isEqual(Puzzle puzzle){
            boolean check = true;
            if (this.length != puzzle.length){
                return false;
            }
            for(int i = 0; i< this.arr.size(); i++){
                if (this.arr.get(i).x != puzzle.arr.get(i).x){
                    check = false;
                    break;
                }
                if (this.arr.get(i).y != puzzle.arr.get(i).y){
                    check = false;
                    break;
                }
            }
            return check;
        }
        
    }
    
    class Point{
        public int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void print(){
            System.out.println(this.x + " " + this.y);
        }
    }
    
    void print(int[][] arr){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}