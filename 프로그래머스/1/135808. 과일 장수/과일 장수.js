function solution(k, m, score) {
    let arr = [];

    score.sort();
    score.reverse();
    
    console.log(score);
    var answer = 0;
    
    let count = 0;
    let minValue = k+1;
    for(let i = 0; i < score.length; i++){
        minValue = Math.min(minValue, score[i]);
        count++
        if (count == m){
            answer += minValue * m;
            count = 0;
            minValue = k+1;
        }
    }
    
    
    
    
    return answer;
}