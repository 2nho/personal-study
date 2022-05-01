var url = require('url');
var q = new URL('http://localhost:8080/abc/default.htm?year=2017&month=february#bob');

q.hostname = 'example';
q.hash = 'baz';
q.pathname = '/abc/efg/default.html'
q.search = '?year=2017&month=february&abc=xyz'
q.port = 8081;
q.protocol = 'https';
console.log(q.href); // https://example:8081/abc/efg/default.html?year=2017&month=february&abc=xyz#baz


