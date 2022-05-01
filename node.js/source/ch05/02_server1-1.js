const http = require('http');

const server = http.createServer((req, res) => {    
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.write('<h1>헬로 node.js!</h1>');
    res.end('<p>본격적으로 서버를 만들어 봅시다!</p>');
});
server.listen(2000);

server.on('listening', () => {
    console.log('서버 대기 중...  port : 2000');
});

server.on('error', (err) => {
    console.error(err);
});

