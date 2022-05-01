const express = require('express')
const app = express()

app.get('/', function(req, res) {
    res.sendFile(__dirname + '/07_sseclient01.html');
});

// sse 관련 헤더로 설정
app.get('/countdown', function(req, res) {
    res.writeHead(200, {
        'Content-Type': 'text/event-stream',
        'Cache-Control': 'no-cache',
        'Connection': 'keep-alive'
    });
    countdown(res, 10)
})

// 전송되는 count가 10부터 1씩 줄어드는 로직
function countdown(res, count) {
    res.write("data: " + JSON.stringify({id : 'kgh', cnt : count}) + "\n\n");
    if (count)
        setTimeout(() => countdown(res, count-1), 1000);
    else
        res.end();
}

app.listen(3000, () => console.log('SSE app listening on port 3000!'));

