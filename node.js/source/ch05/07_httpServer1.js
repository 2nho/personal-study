var http = require('http');

var srvr = http.createServer(function (req, res) {
  res.write('Hello World!');
  res.end();
});
srvr.listen(2000);
console.log(srvr.listening); // true
srvr.close();  // 서버 종료
console.log(srvr.listening); // false

