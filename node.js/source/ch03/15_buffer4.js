var buf = Buffer.from('Hello, and welcome to Rome!');

console.log(buf.includes('welcome'));  // true
console.log(buf.indexOf('welcome'));  // 11
console.log(Buffer.isBuffer(buf));  // true
console.log(Buffer.isEncoding('utf8'));  // true
console.log(buf.lastIndexOf('e'));  // 25

var buf = Buffer.from('abc');

console.log(buf.toString()); // abc
for (x of buf.keys()) {
  console.log(x);
}
// 0,1,2
for (x of buf.values()) {
    console.log(x);
}
// 97,98,99
var x = Buffer.from('abcdef');
var y = x.slice(2,5);

console.log(y.toString());  // cde

var buf = Buffer.from('abcdef');
buf.write('qq',2);
console.log(buf.toString()); // abqqef

