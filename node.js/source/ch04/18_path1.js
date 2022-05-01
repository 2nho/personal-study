var path = require('path');

console.log(path.delimiter); // ;

var filename = path.basename('/Users/Refsnes/demo_path.js');
console.log(filename); // demo_path.js

var filename = path.basename('/Users/Refsnes/demo_path.js', '.js');
console.log(filename); // demo_path

var dirname = path.dirname('/Users/Refsnes/demo_path.js', '.js');
console.log(dirname);  // /Users/Refsnes

var ext = path.extname('/Users/Refsnes/demo_path.js');
console.log(ext);  // .js

var obj = { dir: 'C:\\Users\\Refsnes', base: 'demo_path.js' }
//Format the path object into a path string:
var p = path.format(obj);
console.log(p); // C:\Users\Refsnes\demo_path.js

console.log(path.isAbsolute('/test/demo_path.js')); //true
console.log(path.isAbsolute('test/demo_path.js')); //false
console.log(path.isAbsolute('C:\\test\\demo_path.js')); //true

var x = path.join('Users', 'Refsnes', 'demo_path.js');
console.log(x);  // Users\Refsnes\demo_path.js

var x = path.normalize('Users/Refsnes/../Jackson');
console.log(x);  // Users\Jackson


