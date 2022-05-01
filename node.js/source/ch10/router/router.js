var bodyParser = require("body-parser");
var urlencodedParser = bodyParser.urlencoded({extended:false});
var mysql = require("mysql2");

var conn_info = {
    host : "localhost",
    port : 3306,
    user : "root",
    password : "1234",
    database : "GuestBookDB"
}

module.exports = function(app){
    app.get("/", function(req,res){
        res.render("index.ejs");
    });

    app.post("/login", urlencodedParser, function(req,res){
        var user_name = req.body.user_name;
        //res.send(user_name);

        req.session.user_name = user_name;
        // 서버 main으로 재요청
        res.redirect("main");
    });

    app.get("/main",function(req, res){
        var user_name = req.session.user_name;

        var conn = mysql.createConnection(conn_info);
        var sql = "select guestbook_name, guestbook_content "+
                    "from guestbook order by idx desc";
        
        conn.query(sql, function(err, rows){
            var render_data = {
                name : user_name,
                rows : rows
            } 

            res.render("main.ejs",render_data);
        });
    });

    app.post("/save_guestbook", urlencodedParser, function(req,res){
        var user_name = req.session.user_name;
        var content = req.body.content;
        
        var conn = mysql.createConnection(conn_info);
        var sql = "insert into guestbook(guestbook_name, "+
                    "guestbook_content) values(? , ?)";
        var input_data = [user_name, content];

        conn.query(sql, input_data, function(err){
            conn.end()
            res.redirect("main");
        });
    });

    app.get("/template1", (req, res) =>{
        res.render("template1.ejs");
    });

    app.get("/template2", (req, res) =>{

        var render_data = {
            hd : '이것은 헤더에 전달한 데이터입니다',
            content : '이것은 바디에 전달한 데이터입니다'
        }

        res.render("template2.ejs", render_data);
    });
}
