function solution(n) {
    var answer = 0;
    let arr = new Array(n+1).fill(false);
    for(let i = 2; i <= n; i++){
        if (!arr[i]){
            answer++;
            for(let j = 2; j <= n; j++){
                let x = i * j;
                if (x > n){
                    break;
                }
                arr[x] = true;
            }
        }
    }
    
    
    return answer;
}