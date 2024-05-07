function solution(dartResult) {
    var answer = 0;
    let num = 0;
    let arr = [];
    
    for(let i = 0; i < dartResult.length; i++){
        if (!isNaN(dartResult[i])){
            if (num != 0){
                num = (num*10) + parseInt(dartResult[i]);
            }
            else{
                num = parseInt(dartResult[i]);    
            }
        }
        else if (dartResult[i] == 'S'){
            arr.push(num);
            num = 0;
        }
        else if (dartResult[i] == 'D'){
            num = Math.pow(num, 2);
            arr.push(num);
            num = 0;
        }
        else if (dartResult[i] == 'T'){
            num = Math.pow(num, 3);
            arr.push(num);
            num = 0;
        }
        else if (dartResult[i] == '*'){
            arr[arr.length-1] *= 2;
            if (arr.length > 1){
                arr[arr.length-2] *= 2;
            }
        }
        else if (dartResult[i] == '#'){
            arr[arr.length-1] *= -1;
        }
    }

    for(let i = 0; i < arr.length; i++){
        answer += arr[i];
    }
    
    return answer;
}