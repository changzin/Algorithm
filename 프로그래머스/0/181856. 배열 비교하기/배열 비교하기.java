class Solution {
    public int solution(int[] arr1, int[] arr2) {
        // 두 배열의 길이 다른 경우
        if (arr1.length != arr2.length){
            return (arr1.length > arr2.length) ? 1 : -1;
        }
        // 같은 경우
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i = 0; i < arr1.length; i++){
            sum1 += arr1[i];
        }
        
        for(int i = 0; i < arr2.length; i++){
            sum2 += arr2[i];
        }
        
        if (sum1 == sum2){
            return 0;
        }
        return (sum1 > sum2) ? 1 : -1;
    }
}