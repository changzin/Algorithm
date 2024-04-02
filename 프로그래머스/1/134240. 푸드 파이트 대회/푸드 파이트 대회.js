function solution(food) {
    var answer = '0';
    
    for(let i = food.length-1; i >= 1; i--){
        for(let j = 0; j < Math.floor(food[i] / 2); j++){
            answer = i + answer + i;
        }
    }
    
    return answer;
}