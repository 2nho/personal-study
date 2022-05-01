var fs = require("fs");

// 파일 복사
const readStream = fs.createReadStream(__dirname+'/data/data5.txt');
const writeStream = fs.createWriteStream(__dirname+'/data/data6.txt');
readStream.pipe(writeStream);

