function solution(x) {
    let sum = 0;
    let num = x;
    while (x != 0){
        sum += x % 10;
        x = Math.floor(x / 10);
    }
    var answer;
    if (num % sum == 0){
        answer = true;
    }
    else{
        answer = false;
    }
    
    
    
    return answer;
}