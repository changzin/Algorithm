class Solution {
    String[] arr;
    int len;
    boolean check;
    int count;
    String temp;
    public int[] solution(long[] numbers) {
        len = numbers.length;
        arr = new String[len];
        // 이진 트리로 만들기
        for(int i = 0; i < len; i++){
            arr[i] = makeBinaryTree(numbers[i]);
        }
        
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){
            if (inOrder(0, arr[i].length()-1, i))
                answer[i] = 1;
            else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    boolean inOrder(int s, int e, int index){
        if (s == e){
            // 리리리리프노드임
            return true;
        }
        
        int mid = (s+e) / 2;
        if (arr[index].charAt(mid) == '0'){
            for(int i = s; i <= mid-1; i++){
                if (arr[index].charAt(i) == '1'){
                    return false;
                }
            }
            for(int i = mid+1; i <= e; i++){
                if (arr[index].charAt(i) == '1'){
                    return false;
                }
            }    
        }
        
        return inOrder(s, mid-1, index) && inOrder(mid+1, e, index);
    }
    
    String makeBinaryTree(long num){
        String str = Long.toBinaryString(num);
        int length = 2;
        while(str.length() > length-1){
            length *= 2;
        }
        while(str.length() != length-1){
            str = "0" + str;
        }
        return str;
    }    
}