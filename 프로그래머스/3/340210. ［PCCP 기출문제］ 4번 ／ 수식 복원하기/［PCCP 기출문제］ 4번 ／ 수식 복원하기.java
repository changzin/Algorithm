import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        // 진법 가능 여부 판별
        boolean[] digit = new boolean[8];
        
        List<String> arr1 = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        List<String> results = new ArrayList<>();
        
        StringTokenizer st;
        String num1, operator, num2, result;
        
        for(int i = 0; i < expressions.length; i++){
            st = new StringTokenizer(expressions[i], " ");
            // 값 가져오기
            num1 = st.nextToken();
            operator = st.nextToken();
            num2 = st.nextToken();
            st.nextToken();
            result = st.nextToken();
            
            // 채워야 하는 수식이면 일단 배열에 넣어 보류
            if (result.equals("X")){
                arr1.add(num1);
                arr2.add(num2);
                operators.add(operator);
                
                for(int j = 0; j < 8; j++){
                    if (!digit[j]){
                        int a = strToInt(num1, j+2);
                        int b = strToInt(num2, j+2);
                        if (a == -1 || b == -1){
                            digit[j] = true;
                            continue;
                        }
                    }
                }
            }
            // 채워져 있는 수식이라면 확인
            else{
                for(int j = 0; j < 8; j++){
                    if (!digit[j]){
                        int a = strToInt(num1, j+2);
                        int b = strToInt(num2, j+2);
                        int c = strToInt(result, j+2);
                        if (a == -1 || b == -1 || c == -1){
                            digit[j] = true;
                            continue;
                        }
                        if (operator.equals("+") && a + b != c){
                            digit[j] = true;
                        }
                        else if (operator.equals("-") && a - b != c){
                            digit[j] = true;
                        }
                    }
                }    
            }
        }
        
        
        
        
        String[] answer = new String[arr1.size()];
        
        for(int i = 0; i < arr1.size(); i++){
            num1 = arr1.get(i);
            num2 = arr2.get(i);
            operator = operators.get(i);
            
            int ans = -1;
            for(int j = 0; j < 8; j++){
                if (!digit[j]){
                    int a = strToInt(num1, j+2);
                    int b = strToInt(num2, j+2);
                    int c = (operator.equals("+")) ? a + b : a - b;
                    c = Integer.parseInt(intToString(c, j+2));
                    if (ans == -1){
                        ans = c;
                    }
                    else if (ans != c){
                        ans = -1;
                        break;
                    }
                }
            }
            if (ans != -1){
                answer[i] = num1 + " " + operator + " " + num2 + " = " + ans;    
            }
            else{
                answer[i] = num1 + " " + operator + " " + num2 + " = ?";    
            }
            
        }
        
        return answer;
    }
    
    int strToInt(String str, int num){
        int pos = 1;
        int x = 0;
        for(int i = str.length()-1; i >= 0; i--){
            int a = (int)(str.charAt(i) - '0');
            if (a >= num){
                return -1;
            }
            x += a * pos;
            pos *= num;
            
        }
        return x;
    }
    
    String intToString(int number, int num){
        String x = "";
        if (number == 0){
            return "0";
        }
        while(number != 0){
            int r = number % num;
            number /= num;
            x = r + x;
        }
        return x;
    }
}