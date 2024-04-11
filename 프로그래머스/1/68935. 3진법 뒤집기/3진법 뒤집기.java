class Solution {
    public int solution(int n) {
        int answer = 0;
        
        return convertDecimalToReverseThreeToDecimal(n);
    }
    
    int convertDecimalToReverseThreeToDecimal(int x){
        int temp;
        String str = "";
        while (x != 0){
            temp = x % 3;
            x /= 3;
            str = temp + str;
        }
        int ans = 0;
        temp = 1;
        for(int i = 0; i < str.length(); i++){
            ans += (int)(str.charAt(i)-'0') * temp;
            temp *= 3;
        }
        return ans;
    }
}