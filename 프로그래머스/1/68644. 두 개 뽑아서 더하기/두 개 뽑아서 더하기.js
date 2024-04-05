function solution(numbers) {
    var answer = [];
    let arr = new Array(201).fill(false);
    
    for(let i = 0; i < numbers.length-1; i++){
        for(let j = i+1; j < numbers.length; j++){
            if (!arr[numbers[i]+numbers[j]]){
                answer.push(numbers[i]+numbers[j]);
                arr[numbers[i]+numbers[j]] = true;
            }
        }
    }
    answer.sort((a,b)=>(a-b));
    return answer;
}