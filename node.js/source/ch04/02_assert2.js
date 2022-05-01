const assert = require("assert");

let obj1 = {
    a1 : 10,
    a2 : 20
}
let obj2 = {
    a1 : 10,
    a2 : 20
}
let obj3 = {
    a1 : 10,
    a2 : 30
}
let obj4 = {
    a1 : 10,
    a2 : '20'
}

// assert.deepEqual

assert.deepEqual(obj1, obj2);
console.log("obj1과 obj2는 같습니다.");

// assert.deepEqual(obj1, obj3); // error
// console.log("obj1과 obj3는 같습니다.");

assert.deepEqual(obj1, obj4);
console.log("obj1과 obj4는 같습니다.");


// assert.deepStrictEqual

assert.deepStrictEqual(obj1, obj2);
console.log("obj1과 obj2는 같습니다.");

// assert.deepStrictEqual(obj1, obj3); // error
// console.log("obj1과 obj3는 같습니다.");

// assert.deepStrictEqual(obj1, obj4); // error
// console.log("obj1과 obj4는 같습니다.");


// assert.notDeepEqual

// assert.notDeepEqual(obj1, obj2); // error
// console.log("obj1과 obj2는 다릅니다.");

assert.notDeepEqual(obj1, obj3);
console.log("obj1과 obj3는 다릅니다.");

// assert.notDeepEqual(obj1, obj4); // error
// console.log("obj1과 obj4는 다릅니다.");


// assert.notDeepStrictEqual

// assert.notDeepStrictEqual(obj1, obj2); // error
// console.log("obj1과 obj2는 다릅니다.");

assert.notDeepStrictEqual(obj1, obj3);
console.log("obj1과 obj3는 다릅니다.");

assert.notDeepStrictEqual(obj1, obj4);
console.log("obj1과 obj4는 다릅니다.");