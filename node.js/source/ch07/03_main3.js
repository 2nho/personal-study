var express = require('express');
var app = express();

var myLogger1 = function (req, res, next) {
    console.log('LOGGED1');
    next();
};

var myLogger2 = function (req, res, next) {
    console.log('LOGGED2');
    next();
};

app.get("/test1", myLogger1, function(req, res){
    res.send("test1");
});

app.get("/test2", myLogger1, myLogger2, function(req, res){
    res.send("test2");
});

var server = app.listen(2000, function(){
    console.log('포트 2000번으로 서버 실행');
});

