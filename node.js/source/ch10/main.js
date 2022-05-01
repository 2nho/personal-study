var express = require('express');
var ejs = require("ejs");
var cookieParser = require("cookie-parser");
var session = require("express-session");

var app = express();

app.set("views",__dirname + "/views");
app.set("view engine", "ejs");
app.engine("ejs", ejs.renderFile);
// 미들웨어 설정
app.use(cookieParser())
app.use(session({
    secret : "abcdefg", // 이 데이터를 이용해서 암호화를 하게 된다.
    resave : false,  // 세션의 정보를 다시 저장하는지 여부
    saveUninitialized : true  // 초기화 값을 저장할지 안할지 여부
}));

app.use(express.static("public"));

var router1 = require('./router/router')(app);

// 에러코드는 뒤에 삽입해주는 것이 좋음
app.use( ( req , res, _ ) => {
    res.status(404).render('common/404.ejs');
});

app.use( (err, req, res,  _ ) => {
    console.log(err.toString());
    res.status(500).render('common/500.ejs',{message : err.message});
});

var server = app.listen(2000, function(){
    console.log('포트 2000번으로 서버 실행');
});


