let encoder = new TextEncoder("utf-8");

let e8Array = encoder.encode("Hello");
console.log(e8Array);

let d8Array = new Uint8Array([72, 101, 108, 108, 111]);
console.log( new TextDecoder().decode(d8Array) ); // Hello

