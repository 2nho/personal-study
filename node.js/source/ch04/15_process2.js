process.env.TEST = 1;
console.log(process.env.TEST); // 1

delete process.env.TEST;
console.log(process.env.TEST); // undefined

