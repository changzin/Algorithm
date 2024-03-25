class Solution {
    int ml, nl;
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        ml = m;
        nl = n;
        boolean sameX, sameY;
        int x, y;
        sameX = sameY = false;
        
        for(int i = 0; i < balls.length; i++){
            sameX = sameY = false;
            
            if (balls[i][0] == startX){
                sameX = true;
            }
            if (balls[i][1] == startY){
                sameY = true;
            }
            
            // 위아래
            if (sameX){
                x = xEqual(startX, startY, balls[i][0], balls[i][1]);
                System.out.println("수직으로 위아래 쿠션 : " + x);
            }
            else{
                x = xNotEqual(startX, startY, balls[i][0], balls[i][1]);
                System.out.println("위아래로 값 비교 : " + x);
            }
            
            // 양옆
            if (sameY){
                y = yEqual(startX, startY, balls[i][0], balls[i][1]);
                System.out.println("수평으로 양옆 쿠션 : " + y);
                
            }
            else{
                y = yNotEqual(startX, startY, balls[i][0], balls[i][1]);
                System.out.println("양옆 값 비교 : " + y);
            }
            
            answer[i] = Math.min(x, y);            
        }
        return answer;
    }
    
    int xEqual(int startX, int startY, int ballX, int ballY){
        // 아래쪽
        if (startY < ballY){
            return power((startY * 2) + (ballY - startY));
        }
        else{
            return power((nl - startY) * 2 + (startY - ballY));
        }
    }
    
    int xNotEqual(int startX, int startY, int ballX, int ballY){
        // 동일하지 않음(위아래 각도기 쿠션 가능)
        int xGap = startX - ballX;
        // 아래
        int down = power(startY + ballY) + power(xGap);
        //위
        int up = power((nl - startY) + (nl - ballY)) + power(xGap);
        System.out.println("down : " + down);
        System.out.println("up : " + up);
        return Math.min(down, up);
    }
    
    int yEqual(int startX, int statrY, int ballX, int ballY){
        if (startX < ballX){
            return power((startX * 2) + (ballX - startX));
        }
        else{
            return power((ml - startX) * 2 + (startX - ballX));
        }
    }
    
    int yNotEqual(int startX, int startY, int ballX, int ballY){
        int yGap = startY - ballY;
        int left = power(startX + ballX) + power(yGap);
        int right = power((ml - startX) + (ml - ballX)) + power(yGap);
        System.out.println("left : " + left);
        System.out.println("right : " + right);
        return Math.min(left, right);
    }
    
    int power(int x){
        return x * x;
    }
}