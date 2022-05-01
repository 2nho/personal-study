// Node.js socket server script
const net = require('net');

// Create a server object
const server = net.createServer((socket) => {
    socket.on('data', (data) => {
        console.log(data.toString());
    });
    socket.write('SERVER: 이것은 서버에서 보내는 메시지입니다.<br>');
    socket.end('SERVER: Closing connection now.<br>');
}).on('error', (err) => {
    console.error(err);
});

// 서버 port 4000
server.listen(4000, () => {
  console.log('서버 오픈 포트 : ', server.address().port);
});


