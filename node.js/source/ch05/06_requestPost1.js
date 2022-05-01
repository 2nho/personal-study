var http = require("http");
var options = {
  hostname: 'httpbin.org',
  path: '/post',
  method: 'POST',
  headers: {
    'Content-Type': 'text/html',
  }
};
 
var req = http.request(options, function(res) {
  console.log('Status: ' + res.statusCode);
  console.log('Headers: ' + JSON.stringify(res.headers));
  res.setEncoding('utf8');
  res.on('data', function (body) {
    console.log('Body: ' + body);
  });
});
req.on('error', function(e) {
  console.log('problem with request: ' + e.message);
});
 
req.write(
    '{"text": "test string"}'
);
req.end();
