const http = require('http');

http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.write('<h1>Serverr1</h1>');
    res.end('<p>2000번 포트를 사용하고 있는 서버입니다.</p>');
}).listen(2000, () => { // 서버 연결
    console.log('1번 서버... port : 2000');
});

http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.write('<h1>Server2</h1>');
    res.end('<p>2001번 포트를 사용하고 있는 서버입니다.</p>');
}).listen(2001, () => { // 서버 연결
    console.log('1번 서버... port : 2001');
});

