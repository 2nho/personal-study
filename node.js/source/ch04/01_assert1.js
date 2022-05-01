const assert = require("assert");

let v1 = 10;
let v2 = 10;
let v3 = 20;
let v4 = '10';

// assert

assert(v1 == v2);
console.log('v1과 v2는 같습니다.');

// assert(v1 == v3); // error
// console.log('v1과 v3는 같습니다.'); 

assert(v1 == v4);
console.log('v1과 v4는 같습니다.');

// assert(v1 - v2); // error
// console.log("v1 - v2는 0이 아닙니다."); 

assert(v1 - v3);
console.log("v1 - v4는 0이 아닙니다.");


// assert.equal

assert.equal(v1, v2);
console.log('v1과 v2는 같습니다.');

// assert.equal(v1, v3); // error
// console.log('v1과 v3는 같습니다.'); 

assert.equal(v1, v4);
console.log('v1과 v4는 같습니다.');


// assert.strictEqual

assert.strictEqual(v1, v2);
console.log('v1과 v2는 같습니다.');

// assert.strictEqual(v1, v4); // error
// console.log('v1과 v4는 같습니다.');


// assert.notEqual

// assert.notEqual(v1, v2); // error
// console.log('v1과 v2는 다릅니다.');

assert.notEqual(v1, v3);
console.log('v1과 v3는 다릅니다.'); 

// assert.notEqual(v1, v4); // error
// console.log('v1과 v4는 다릅니다.');


// assert.notStrictEqual

// assert.notStrictEqual(v1, v2); // error
// console.log('v1과 v2는 다릅니다.');

assert.notStrictEqual(v1, v3);
console.log('v1과 v3는 다릅니다.'); 

assert.notStrictEqual(v1, v4); 
console.log('v1과 v4는 다릅니다.');

