class Solution {
    public int solution(String arr[]) {
    
        int minValue = 0;
        int maxValue = 0;
        int tempMin = 0;
        int tempMax = 0;
        int sum = 0;
    
        for(int i = arr.length-1; i >= 0; i--){
            if (arr[i].equals("+")){
                continue;    
            }
            else if (arr[i].equals("-")){
                tempMin = minValue;
                tempMax = maxValue;
                minValue = Math.min((tempMax + sum) * -1, tempMin + (sum * -1));
                maxValue = Math.max((tempMin + sum) * -1, tempMax + sum - (2 * Integer.parseInt(arr[i+1])));
                sum = 0;
            }
            else{
                sum += Integer.parseInt(arr[i]);
            }            
        }
        
        int answer = 0;
        answer = maxValue + sum;
        return answer;
    }
}
