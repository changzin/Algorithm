class Solution {
    public int[] solution(int[] sequence, int k) {
        int front = 0;
        int back = 0;
        int sum = sequence[0];
        int size = 1;
        int len = sequence.length-1;
        int minSize = Integer.MAX_VALUE;
        int ansA, ansB;
        ansA = ansB = -1;
        
        while(true){
            if (sum == k && size < minSize){
                minSize = size;
                ansA = front;
                ansB = back;
            }
            
            if (back == len && front != len){
                sum -= sequence[front]; 
                front++;
                size--;
            }
            else if (back == len && front == len){
                break;
            }
            
            else if(front >= back){
                back++;
                size++;
                sum += sequence[back];
            }
            else if (sum <= k){
                size++;
                back++;
                sum += sequence[back];
            }
            else{
                sum -= sequence[front];
                size--;
                front++;
            }
        }        
        
        int[] answer = {ansA, ansB};
        return answer;
    }
}