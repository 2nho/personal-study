var fs = require("fs");

fs.writeFileSync(__dirname+'/data/data3.txt', 'hello node.js');
console.log("동기식 저장 1");

fs.writeFileSync(__dirname+'/data/data4.txt', 'hello node.js');
console.log("동기식 저장 2")

fs.appendFileSync(__dirname+'/data/data3.txt', '안녕하세요')
console.log('파일 내용 추가 1');

fs.appendFileSync(__dirname+'/data/data4.txt', '반갑습니다')
console.log('파일 내용 추가 2');

var data3 = fs.readFileSync(__dirname+'/data/data3.txt');
console.log('data3 : ', data3.toString());

var data4 = fs.readFileSync(__dirname+'/data/data4.txt');
console.log('data4 : ', data4.toString());

