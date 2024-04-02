function solution(k, score) {
    let arr = [];
    let count = 0;
    var answer = [];
    
    for(let i = 0; i < score.length; i++){    
        arr.push(score[i]);
        if (arr.length <= k){
            let minValue = 2000;
            for(let j = 0; j < arr.length; j++){
               minValue = Math.min(minValue, arr[j]); 
            } 
            answer.push(minValue);
        }
        else{
            let minValue = 2000;
            let minIndex = -1;
            for(let j = 0; j < arr.length; j++){
                if (minValue > arr[j]){
                    minValue = arr[j];
                    minIndex = j;
                } 
            }
            arr.splice(minIndex, 1);            
            minValue = 2000;
            for(let j = 0; j < arr.length; j++){
               minValue = Math.min(minValue, arr[j]); 
            } 
            answer.push(minValue);
            
        }
        // console.log();
        // console.log(arr);
        // console.log(answer);
    }
    
    
    return answer;
}