var url = require('url');
var q = new URL('http://localhost:8080/abc/default.htm?year=2017&month=february&month=may');

var myParam = q.searchParams;

console.log(myParam.getAll('month')); // ['february', 'may']
console.log(myParam.get('month')); // february
console.log(myParam.has('year')); // true

for(var key of myParam.keys()) { 
    console.log(key); 
}
// year
// month
// month
for(var value of myParam.values()) { 
    console.log(value); 
}
// 2017
// february
// may

setTimeout(function(){
    myParam.append('filter','es3');
    myParam.append('filter','es5');
    console.log(myParam.getAll('filter')); // ['es3', 'es5']
}, 1000);

setTimeout(function(){
    myParam.set('filter','es6');
    console.log(myParam.getAll('filter')); // ['es6']
}, 2000);

setTimeout(function(){
    myParam.delete('filter');
    console.log(myParam.getAll('filter')); // []
}, 3000);

console.log(myParam.toString()); // year=2017&month=february&month=may

