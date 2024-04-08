function solution(n, arr1, arr2) {
    var answer = [];
    let map1 = [];
    let map2 = [];

    for(let i = 0; i < arr1.length; i++){
        map1[i] = toBinaryString(arr1[i], arr1.length);
        map2[i] = toBinaryString(arr2[i], arr1.length);
    }
    
    for(let i = 0; i < arr1.length; i++){
        let str = "";
        for(let j = 0; j < arr1.length; j++){
            str += (map2[i][j] == "0" && map1[i][j] == "0") ? " " : "#";
        }
            answer.push(str);
    }
    
    return answer;
}

function toBinaryString(num, length){
    let str = "";
    while(num != 0){
        let rest = num % 2;
        num = Math.floor(num / 2);
        str = rest + str;
    }
    while(str.length != length){
        str = '0' + str;
    }
    return str;
}