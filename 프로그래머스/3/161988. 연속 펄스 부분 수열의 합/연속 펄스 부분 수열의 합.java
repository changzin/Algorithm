class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];
        
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        
        for(int i = 0; i < sequence.length; i++){
            if (i % 2 == 0){
                arr1[i] = sequence[i];
                arr2[i] = -sequence[i];
            }
            else{
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];                
            }
        }
        
        // dp를 두개를 한꺼번에 돌려버림
        dp1[0] = arr1[0];
        dp2[0] = arr2[0];
        
        answer = Math.max(dp1[0], dp2[0]);
        
        for(int i = 1; i < sequence.length; i++){
            dp1[i] = Math.max(arr1[i], arr1[i] + dp1[i-1]);
            dp2[i] = Math.max(arr2[i], arr2[i] + dp2[i-1]);
            
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
//         print(arr1);
//         print(dp1);
        
//         print(arr2);
//         print(dp2);
        
        return answer;
    }    
    
    void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    void print(long[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}