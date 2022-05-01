var http = require('http');
var options = {
    hostname: 'httpbin.org',
    path: '/ip'
};
 
function handleResponse(response) {
  var serverData = '';
  response.on('data', function (chunk) {
    serverData += chunk;
  });
  response.on('end', function () {
    console.log("received server data:");
    console.log(serverData);
  });
}
 
http.request(options, function(response){
  handleResponse(response);
}).end();
