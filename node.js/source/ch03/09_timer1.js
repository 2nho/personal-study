var num = 0;

var si = setInterval(function(){
    console.log("interval : ",num++);
}, 1000);

// clearInterval(interval);

var st = setTimeout(function(){
    clearInterval(si);
},6000);

clearTimeout(st);
