function solution(left, right) {
    var answer = 0;
    let arr = [];
    for(let i = 0; i <= 1000; i++){
        arr.push(0);
    }
    for(let i = 1; i <= 1000; i++){
        let j = 1;
        while(true){
            if (i * j > 1000){
                break;
            }
            else{
                arr[i*j]++;
                j++;
            }
        }
    }
    for(let i = left; i <= right; i++){
        answer += (arr[i] % 2 == 0) ? i : -i;
    }
    return answer;
}