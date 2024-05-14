function solution(rows, columns, queries) {
    
    var arr = [];
    for(let i = 0; i < rows; i++){
        arr.push([]);
        for(let j = 0; j < columns; j++){
            arr[i][j] = i * columns + j + 1;
        }
    }
    var answer = [];
    for(let i = 0; i < queries.length; i++){
        let ax, ay, bx, by;
        ax = queries[i][0]-1;
        ay = queries[i][1]-1;
        bx = queries[i][2]-1;
        by = queries[i][3]-1;
        let next = arr[ax+1][ay];
        let prev;
        let minValue = 1000001;
        for(let j = ay; j < by; j++){
            prev = arr[ax][j];
            arr[ax][j] = next;
            next = prev;
            minValue = Math.min(minValue, next);
        }
        for(let j = ax; j < bx; j++){
            prev = arr[j][by];
            arr[j][by] = next;
            next = prev;
            minValue = Math.min(minValue, next);
        }
        for(let j = by; j > ay; j--){
            prev = arr[bx][j];
            arr[bx][j] = next;
            next = prev;
            minValue = Math.min(minValue, next);
        }
        for(let j = bx; j > ax; j--){
            prev = arr[j][ay];
            arr[j][ay] = next;
            next = prev;
            minValue = Math.min(minValue, next);
        }
                
        answer.push(minValue);
    }
    
    
    
    
    
    return answer;
}