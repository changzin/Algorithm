import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recursion(p);
        
        return answer;
    }
    
    String recursion(String str){
        if (str.equals("")){
            return "";
        }
        
        String[] arr = divideStr(str);
        String u = arr[0];
        String v = arr[1];
        
        boolean check = checkStr(u);
        // 재귀
        if (check){
            return u + recursion(v);
        }
        else{
            return "(" + recursion(v) + ")" + makeStr(u);
        }
    }
    
    // 균형잡힌 괄호 문자열 u, v로 분리하는 함수
    String[] divideStr(String str){
        int open = 0;
        int close = 0;
        String[] arr = {"", ""};
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }
            // 첫 시작이 아니면서 균형잡힌 문자열 추출
            if (i != 0 && open == close){
                arr[0] = str.substring(0, i+1);
                arr[1] = str.substring(i+1, str.length());
                break;
            }
        }
        
        return arr;
    }
    
    // 올바른 괄호 문자열인지 확인하는 함수
    boolean checkStr(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            // 여는 괄호
            if (str.charAt(i) == '('){
                count++;
            }
            // 닫는 괄호
            else{
                if (count == 0){
                    return false;
                }
                else{
                    count--;
                }
            }
        }
        if (count != 0){
            return false;
        }
        return true;
    }
    
    String makeStr(String str){
        String result = "";
        for(int i = 1; i < str.length()-1; i++){
            if (str.charAt(i) == '('){
                result += ")";
            }
            else{
                result += "(";
            }
        }
        return result;
    }
}