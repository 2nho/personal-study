var url = require('url');
var adr = 'http://localhost:8080/abc/default.htm?year=2017&month=february#bob';
var q = url.parse(adr, true);

console.log(q.host); // localhost:8080
console.log(q.hostname)  // localhost
console.log(q.hash); // bob
console.log(q.pathname); // /abc/default.htm
console.log(q.search); // ?year=2017&month=february
console.log(q.href); // http://localhost:8080/abc/default.htm?year=2017&month=february#bob
console.log(q.port); // 8080
console.log(q.protocol); // http:
console.log(q.query); // { year: 2017, month: 'february' }


var qdata = q.query; // { year: 2017, month: 'february' }
console.log(qdata.month); // february

