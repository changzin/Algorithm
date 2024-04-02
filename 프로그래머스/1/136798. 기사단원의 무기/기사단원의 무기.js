function solution(number, limit, power) {
    let arr = [];
    
    for(let i = 0; i <= number; i++){
        arr.push(0);
    }
    
    for(let i = 1; i <= number; i++){
        let num = 1;
        while(true){
            if (num * i > number){
                break;
            }
            arr[num*i]++;
            num++;
        }
    }
    
    var answer = 0;
    for(let i in arr){
        if (arr[i] > limit){
            answer += power;
        }
        else{
            answer += arr[i];
        }
    }
    return answer;
}