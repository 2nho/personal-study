var express = require('express');
var app = express();

app.get("/", function(req, res){
    res.send("ROOT");
});

app.get("/test1", function(req, res){
    res.send("TEST");
});

app.get("/test1/:id", function(req, res){
    res.send("test id : "+req.params.id);
});

app.get("/test1/:id/:content", function(req, res){
    var color1 = (req.query.color1 == null)? "none" : req.query.color1;
    var color2 = (req.query.color2 == null)? "none" : req.query.color2;
    // res.send(" test id : "+req.params.id+
    // "\n test content : "+req.params.content+
    // "\n test color1 : "+color1+
    // "\n test color2 : "+color2
    // );
    var data = {
        id : req.params.id,
        content : req.params.content,
        color1 : color1,
        color2 : color2
    }
    res.json(data);
});

var server = app.listen(2000, function(){
    console.log('포트 2000번으로 서버 실행');
});

