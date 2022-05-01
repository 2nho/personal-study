// Node.js WebSocket server script
const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 4000 });

wss.on('connection', function connection(ws) {
  ws.on('message', function incoming(message) {
    console.log('received: %s', message);
  });

  ws.send('Hi this is WebSocket server!');
});
