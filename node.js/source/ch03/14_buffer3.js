var buf1 = Buffer.from('a');
var buf2 = Buffer.from('b');
var buf3 = Buffer.from('c');
var arr = [buf1, buf2, buf3];

var buf = Buffer.concat(arr);
console.log(buf); // Buffer(3) [97, 98, 99]

var buf1 = Buffer.from('abcdefghijkl');
var buf2 = Buffer.from('HELLO');

buf2.copy(buf1, 2);
console.log(buf1.toString()); // abHELLOhijkl

buf2.copy(buf1, 2, 0, 2);
console.log(buf1.toString()); // abHEefghijkl

var buf = Buffer.from('abc');

for (x of buf.entries()) {
  console.log(x);
}
// [ 0, 97 ]
// [ 1, 98 ]
// [ 2, 99 ]

var buf1 = Buffer.from('abc');
var buf2 = Buffer.from('abc');

console.log(buf1.equals(buf2)); // true

