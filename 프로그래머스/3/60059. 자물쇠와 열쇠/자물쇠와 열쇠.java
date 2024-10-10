import java.util.*;

class Solution {
    int[][][] keys;
    int[][] locks;
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        // 변수 초기화
        keys = new int[4][key.length][key.length];
        locks = lock;
        
        // key를 4번 돌려서 배열에 모두 저장해놨다.
        keys[0] = key;        
        for(int i = 1; i < 4; i++){
            keys[i] = rotate(keys[i-1]);
        }
        
        
        for(int i = 0; i < key.length + lock.length-1; i++){
            for(int j = 0; j < key.length + lock.length-1; j++){
                if (check(i, j)){
                    return true;
                }
            }
        }
        
        return answer;    
    }
    
    boolean check(int x, int y){
        int[][] key;
        boolean result = true;
        for(int k = 0; k < 4; k++){
            key = keys[k];    
            
            result = true;
            for(int i = 0; i < locks.length; i++){
                for(int j = 0; j < locks.length; j++){
                    // 판별하기 위한 자물쇠의 가상 좌표
                    int relx = i + key.length - 1;
                    int rely = j + key.length - 1;
                    
                    // 맞는 부분이라면 key가 Lock과 일치해야한다.
                    if (relx >= x && relx < key.length + x && rely >= y && rely < key.length + y){
                        if (locks[i][j] + key[relx - x][rely - y] != 1){
                            result = false;
                        }
                    }
                    // lock "만" 있는 부분인데 파여 있는 부분이라면 안된다.
                    else if (locks[i][j] == 0){
                        result = false;
                    }
                }
            }
            if (result){
                return result;
            }
        }
        return result;
    }
    
    int[][] rotate(int[][] arr){
        int[][] rotatedArr = new int[arr.length][arr.length];        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                rotatedArr[i][j] = arr[arr.length-1-j][i];
            }
        }
        return rotatedArr;
    }
    
    void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}