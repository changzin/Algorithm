import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        List<Point> arr = new ArrayList<>();
        arr.add(new Point(3, 1));
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr.add(new Point(i, j));
            }
        }
        arr.add(new Point(3, 0));
        arr.add(new Point(3,2));
        int lx = 10; int rx = 11;
        
        for(int i = 0; i < numbers.length; i++){
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                lx = numbers[i];
                answer += 'L';
            }
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                rx = numbers[i];
                answer += 'R';
            }
            else{
                Point dist = arr.get(numbers[i]);
                int ldist = Math.abs(arr.get(lx).x - dist.x) + Math.abs(arr.get(lx).y - dist.y);
                int rdist = Math.abs(arr.get(rx).x - dist.x) + Math.abs(arr.get(rx).y - dist.y);          
                if (ldist == rdist){
                    if (hand.equals("left")){
                        lx = numbers[i];
                        answer += 'L';                    
                    }
                    else{
                        rx = numbers[i];
                        answer += 'R';                        
                    }
                }
                else if (ldist > rdist){
                    rx = numbers[i];
                    answer += 'R';
                }
                else{
                    lx = numbers[i];
                    answer += 'L';
                }
            }
        }
        return answer;
    }
}

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}