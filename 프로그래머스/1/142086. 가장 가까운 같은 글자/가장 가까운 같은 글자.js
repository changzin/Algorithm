function solution(s) {
    let arr = [];

    for(let i = 0; i < 26; i++){
        arr.push(-1);
    }    
    
    var answer = [];
    for(let i = 0; i < s.length; i++){
        let num = s.charCodeAt(i) - 'a'.charCodeAt(0);
        if (arr[num] == -1){
            answer.push(-1);
            arr[num] = i;
        }
        else {
            answer.push(i - arr[num])
            arr[num] = i;
        }
    }
    
    return answer;
}