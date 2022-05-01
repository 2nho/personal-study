const http = require('http');
const url = require('url');

let server = http.createServer(function(req, res){
    
    let req_url = new URL(req.url, `http://${req.headers.host}`);
    let params = req_url.searchParams;
    
    res.writeHead(200, {'content-type':'text/html'});

    res.write("<!DOCTYPE html>");
    res.write("<html>");
    res.write("<head>");
    res.write("<meta charset='utf-8'>");
    res.write("<title>req, res 예제 </title>");
    res.write("</head>");
    res.write("<body>");
    
    if(req_url.pathname === '/'){
        res.write("<h1>root 입니다</h1>");
        res.write("<a href='test1?data=111'>test1</a></br>");
        res.write("<a href='test1?data=222'>test2</a></br>");
    }else if(req_url.pathname === '/test1'){
        if(params.get('data')==111){
            res.write("<h1>test1 페이지 입니다.</h1>");
        }else if(params.get('data')==222){
            res.write("<h1>test2 페이지 입니다.</h1>");
        }
    }

    res.write("</body>");
    res.write("</html>");
    res.end();
});

server.listen(2000);

server.on('listening', () => {
    console.log('서버 대기 중...  port : 2000');
});

server.on('error', (err) => {
    console.error(err);
});

