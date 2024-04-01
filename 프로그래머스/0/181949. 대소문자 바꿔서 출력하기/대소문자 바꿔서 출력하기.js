const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];

    let answer = "";
    
    for(let i = 0; i < str.length; i++){
        let a = str.charCodeAt(i);
        if (a >= 97){
            a -= 32;
        }
        else{
            a += 32;
        }
        answer += String.fromCharCode(a);
    }
    console.log(answer);
});


