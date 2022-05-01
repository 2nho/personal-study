const crypto = require('crypto');

let ciphers = crypto.getCiphers();

// 지원하는 모든 암호화 방식 보여주기
for(let x of ciphers){
    console.log(x);
}


