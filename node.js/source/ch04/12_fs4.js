var fs = require("fs");
// 스트림을 활용한 읽기 highWaterMark는 버퍼의 크기를 지정해 주는 속성
const readStream = fs.createReadStream(__dirname+'/data/data5.txt',{highWaterMark : 16});
const data = [];

// 파일 읽기가 시작될 경우 발생하는 이벤트
readStream.on('data', (chunk) =>{
    data.push(chunk);
    console.log('data : ', chunk, chunk.length);
});

// 파일을 다 읽을경우 발생하는 이벤트
readStream.on('end', () =>{
    console.log('end : ', Buffer.concat(data).toString());
});

// 읽는 도중 에러 날 경우 발생하는 이벤트
readStream.on('error', (err) => {
    console.log('error : '+err);
});

