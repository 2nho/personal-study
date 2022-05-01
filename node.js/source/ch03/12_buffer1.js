// var buf1 = Buffer.alloc(15);
// console.log("1:",buf1);

var buf2 = Buffer.alloc(15, 'a');
console.log("2:",buf2);

var buf3 = Buffer.allocUnsafe(15);
console.log("3:",buf3);

buf3.fill(0);
console.log("4:",buf3);

var len = Buffer.byteLength(buf3);
console.log("len:",len);

