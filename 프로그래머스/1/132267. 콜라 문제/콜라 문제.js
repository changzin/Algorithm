function solution(a, b, n) {
    var answer = 0;
    while(true){
        if (n < a){
            break;
        }
        let rest = n % a;
        answer = answer + Math.floor(n / a) * b;
        n = rest + Math.floor(n / a) * b;
    }
    
    return answer;
}