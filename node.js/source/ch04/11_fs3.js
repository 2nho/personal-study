var fs = require("fs");
// 스트림을 활용한 읽고 쓰기
const writeStream = fs.createWriteStream(__dirname+'/data/data5.txt');
writeStream.on('finish', ()=>{
    console.log('파일 쓰기 완료');
});

writeStream.write('스트림을 이용해 데이터를 전달하게 되면\n');
writeStream.write('큰 메모리 용량 필요 없이 파일 전송이 가능해집니다.\n');
writeStream.end();

