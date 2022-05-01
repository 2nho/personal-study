var express = require('express');
var ejs = require("ejs");

var app = express();

app.set("views",__dirname + "/views");
app.set("view engine", "ejs");
app.engine("html", ejs.renderFile);

var router1 = require('./router/router1')(app)

var server = app.listen(2000, function(){
    console.log('포트 2000번으로 서버 실행');
});

