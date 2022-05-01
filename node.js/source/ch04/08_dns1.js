var dns = require('dns');

var w3 = dns.lookup('www.w3schools.com', function (err, addresses, family) {
  console.log(addresses); // 주소
  console.log(family); // 버전
});



