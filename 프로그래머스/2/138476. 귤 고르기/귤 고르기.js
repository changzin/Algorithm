function solution(k, tangerine) {
    var answer = 0;
    
    let map = new Map();
    for(i in tangerine){
        if (map.has(tangerine[i])){
            map.set(tangerine[i], map.get(tangerine[i])+1);
        }
        else{
            map.set(tangerine[i], 1);
        }
    }
    
    let arr = [];
    for(let[key, value] of map){
        arr.push(value);
    }
    
    arr = arr.sort((a, b) => b - a);    
    
    let sum = 0;
    for(let i = 0; i < arr.length; i++){
        if (sum < k){
            sum += arr[i];
            answer++;
        }
        else{
            break;
        }
    }
    
    return answer;
}