class Solution {
    int ans;
    int len;
    String[] arr;
    public int solution(int[] picks, String[] minerals) {
        len = minerals.length;
        int answer = 0;
        arr = minerals;
        ans = Integer.MAX_VALUE;
        
        recursion(picks[0], picks[1], picks[2], 0, 0);
        
        return ans;
    }
    
    void recursion(int a, int b, int c, int index, int h){
        // System.out.printf("%d %d %d // %d // %d\n", a, b, c, index, h);
        if (a == 0 && b == 0 && c == 0){
            if (h < ans){
                ans = h;
            }
            return;
        }
        if (index + 5 >= len){
            int num = (a != 0) ? 1 : ((b!= 0)?2:3);
            for(int i = index; i < len; i++){
                h += process(num, arr[i]);
            }
            if (h < ans){
                ans = h;
            }
            return;
        }
        
        
        if (a != 0){        
            int sub = 0;
            for(int i = index; i < index + 5; i++){
                sub += process(1, arr[i]);
            }
            recursion(a-1, b, c, index + 5, h + sub);
        }
        if (b != 0){
            int sub = 0;
            for(int i = index; i < index + 5; i++){
                sub += process(2, arr[i]);
            }
            recursion(a, b-1, c, index + 5, h + sub);
        }
        if (c != 0){
            int sub = 0;
            for(int i = index; i < index + 5; i++){
                sub += process(3, arr[i]);
            }
            recursion(a, b, c-1, index + 5, h + sub);
        }
    }
    
    int process(int a, String min){
        if (min.equals("stone")){
            return 1;
        }
        else if (min.equals("iron")){
            if (a ==3){
                return 5;
            }
            else{
                return 1;
            }
        }
        else if (min.equals("diamond")){
            if (a == 1){
                return 1;
            }
            else if (a == 2){
                return 5;
            }
            else if (a == 3){
                return 25;
            }
        }
        return -1;
    }
}