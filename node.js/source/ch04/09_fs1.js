var fs = require("fs");

// fs.writeFile(__dirname+'/data/data1.txt', 'hello node.js', function(error){
//     console.log("비 동기식 저장 1");
// });

// fs.writeFile(__dirname+'/data/data2.txt', 'hello node.js', function(error){
//     console.log("비 동기식 저장 2")
// });

fs.appendFile(__dirname+'/data/data1.txt','안녕하세요',function(error){
    console.log('비 동기식 추가 1');
});

fs.appendFile(__dirname+'/data/data2.txt','반갑습니다',function(error){
    console.log('비 동기식 추가 2');
});

fs.readFile(__dirname+'/data/data1.txt',function(error, data){
    console.log("data1 : ", data.toString());
});

fs.readFile(__dirname+'/data/data2.txt',function(error, data){
    console.log("data2 : ", data.toString());
});

