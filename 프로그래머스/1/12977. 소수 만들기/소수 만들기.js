function solution(nums) {
    var answer = 0;
    
    let arr = new Array(3001).fill(0);
    let prime = new Array(3001).fill(0);
    
    for(let i = 2; i < prime.length; i++){
        if (prime[i] === 0){
            for(let j =2; j < prime.length; j++){
                let x = i * j;
                if (x >= prime.length){
                    break;
                }
                prime[x] = 1;
            }
        }
    }
    for(let i = 0; i < nums.length-2; i++){
        for(let j = i+1; j < nums.length-1; j++){
            for(let k = j+1; k < nums.length; k++){
                let num = nums[i] + nums[j] + nums[k];
                if (prime[num] === 0){
                    answer++;
                }
            }
        }
    }
    return answer;
}