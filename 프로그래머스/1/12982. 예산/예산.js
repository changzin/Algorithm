function solution(d, budget) {
    d.sort((a, b)=>a-b);
    var answer = 0;
    for(let i in d){
        if (budget < d[i]){
            break;
        }
        answer++;
        budget -= d[i];
    }
    return answer;
}