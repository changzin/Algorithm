class Solution {
    static int[] visit = new int[10];
    static boolean[] arr = new boolean[10000000];
    static boolean[] ansVisit = new boolean[10000000];
    static int[] numArr;
    static int[] ans;
    static int a = 0;
    
    public int solution(String numbers) {
        // 소수를 쫙 구해서 판정하는게 나을까 
        for(int i = 2; i < 10000000; i++){
            if (!arr[i]){
                int num = 2;
                while(i * num <= 9999999){
                    arr[i * num] = true;
                    num++;
                }
            }
        }
        arr[0] = arr[1] = true;
        
        numArr = new int[numbers.length()];
        ans = new int[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++){
            numArr[i] = numbers.charAt(i) - '0';
            visit[numArr[i]]++;
        }
        
        for(int i = 1; i <= numArr.length; i++){
            recursion(0, i);
        }
        int answer = a;
        return answer;
    }
    
    public void recursion(int weight, int p){
        if (weight == p){
            int num = 0;
            for(int i = 0; i < p; i++){
                num = (num * 10) + ans[i];
            }
            if (!arr[num] && !ansVisit[num]){
                ansVisit[num] = true;
                a++;
            }
            
            return;
        }
        
        for(int i = 0; i < numArr.length; i++){
            if (visit[numArr[i]] > 0){
                ans[weight] = numArr[i];
                visit[numArr[i]]--;
                recursion(weight+1, p);
                visit[numArr[i]]++;
            }
        }
    }
}