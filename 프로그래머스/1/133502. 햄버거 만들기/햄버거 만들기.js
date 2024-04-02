function solution(ingredient) {
    var answer = 0;
    let arr = [];
    let dx = [1, 3, 2, 1];
    for(let i = 0; i < ingredient.length; i++){
        arr.push(ingredient[i]);
        // console.log(arr);
        if (arr.length >= 4){
            let check = true;
            let len = arr.length;
            for(let j = 0; j < 4; j++){
                if (arr[len-j-1] != dx[j]) {
                    check = false;
                    // console.log("실패");
                    break;
                }
            }
            if (check){
                answer++;
                // console.log("성공");
                for(let j = 0; j < 4 ;j++){
                    arr.pop();
                }
            } 
        }
    }
    
    return answer;
}