var express = require('express');
var app = express();

var myLogger1 = function (req, res, next) {
    console.log('LOGGED1');
    next();
};

app.use(myLogger1);

var router1 = require('./router/router3')(app)

var server = app.listen(2000, function(){
    console.log('포트 2000번으로 서버 실행');
});

