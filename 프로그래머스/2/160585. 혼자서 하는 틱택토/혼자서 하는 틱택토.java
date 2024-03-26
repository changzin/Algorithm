class Solution {
    public int solution(String[] board) {
        int first = 0;
        int second = 0;
        boolean firstWin = false;
        boolean secondWin = false;
        boolean firstDoubleWin = false;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (board[i].charAt(j) == 'O') first++;
                else if (board[i].charAt(j) == 'X') second++;
            }
        }
        
        // 가로축
        for(int i = 0; i < 3; i++){
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2)){
                if (board[i].charAt(0) == 'O'){
                    if (firstWin) firstDoubleWin = true;
                    firstWin = true;
                }
                else if (board[i].charAt(0) == 'X') secondWin = true;
            }
        }
        
        // 세로축
        for(int i = 0; i < 3; i++){
            if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i)){
                if (board[0].charAt(i) == 'O'){
                    if (firstWin) firstDoubleWin = true;
                    firstWin = true;
                }
                else if (board[0].charAt(i) == 'X') secondWin = true;
            }
        }
        
        // 대각선
        if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)){
            if (board[0].charAt(0) == 'O'){
                if (firstWin) firstDoubleWin = true;
                firstWin = true;
            }
            else if (board[0].charAt(0) == 'X') secondWin = true;
        }
                
        // 대각선
        if (board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0)){
            if (board[0].charAt(2) == 'O'){
                if (firstWin) firstDoubleWin = true;
                firstWin = true;
            }
            else if (board[0].charAt(2) == 'X') secondWin = true;
        }
        
        int answer = 1;
        if (firstDoubleWin){
            if (first != second+1) answer = 0;
        }
        else if (firstWin && secondWin){
            answer = 0;
        }
        else if (firstWin){
            if (first != second+1) answer = 0;
        }
        else if (secondWin){
            if (first != second) answer = 0;
        }
        else if (first < second){
            answer = 0;
        }
        else if (first - second > 1){
            answer = 0;
        }
        
        return answer;
    }
}