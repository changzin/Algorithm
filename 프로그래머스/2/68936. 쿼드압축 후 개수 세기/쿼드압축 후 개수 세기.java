class Solution {
    int[][] map;
    int[] numbers = new int[2];
    public int[] solution(int[][] arr) {
        map = arr;
        int length = arr.length;
        
        dnq(length, 0, 0);
        if (numbers[0] == 0 && numbers[1] == 0){
            numbers[arr[0][0]]++;
        }
        int[] answer = {numbers[0], numbers[1]};
        return answer;
    }
    
    int dnq(int length, int x, int y){
        if (length == 1){
            return map[x][y];
        }
        int nextLength = length/2;
        int first = dnq(nextLength, x, y);
        int second = dnq(nextLength, x+nextLength, y+nextLength);
        int third = dnq(nextLength, x, y+nextLength);
        int fourth = dnq(nextLength, x+nextLength, y);
        
        if (first == second && second == third && third==fourth){
            return first;
        }
        
        if (first != -1){
            numbers[first]++;
        }
        if (second != -1){
            numbers[second]++;
        }
        if (third != -1){
            numbers[third]++;
        }
        if (fourth != -1){
            numbers[fourth]++;
        }
        return -1;
    }
}