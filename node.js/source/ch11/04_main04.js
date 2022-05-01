var express = require('express');
var app = express();
app.use(express.json())

app.delete("/", function(req, res){
    res.send("ROOT");
});

app.delete("/test1", function(req, res){
    res.send("TEST");
});

app.delete("/test1/:id", function(req, res){
    var data = {
        id : req.params.id,
        data1 : req.body.data1,
        data2 : req.body.data2
    };
    res.json(data);
});

var server = app.listen(2000, function(){
    console.log('포트 2000번으로 서버 실행');
});

