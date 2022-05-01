var http = require('http');
var lc = require('lower-case');

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write(lc.lowerCase("Hello World!"));
    res.end();
}).listen(2000);


