function solution(X, Y) {
    let arr = [];
    let arr2 = [];
    for(let i = 0; i < 10; i++){
        arr.push(0);
        arr2.push(0);
    }
    for(let i = 0; i < X.length; i++){
        arr[parseInt(X[i])]++;
    }
    console.log(arr);
    for(let i = 0; i < Y.length; i++){
        if (arr[parseInt(Y[i])] > 0){
            arr[parseInt(Y[i])]--;
            arr2[parseInt(Y[i])]++;
        }
    }
    
    
    var answer = '';
    for(let i = 9; i >= 0; i--){
        while (arr2[i] > 0){
            answer += i;
            arr2[i]--;
        }
    }
    
    if (answer == ""){
        answer = "-1";
    }
    if (answer[0] == '0'){
        answer = "0";
    }
    return answer;
}