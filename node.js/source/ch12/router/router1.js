module.exports = function(app){
    app.get("/", function(req,res){
        res.render("index.ejs");
    });

    app.get("/ajax1", function(req,res){
        res.render("ajax1.ejs");
    });

    app.get("/ajax1_result1", function(req,res){
        res.send("이것은 xmlhttprequest 를 활용한 비동기 통신입니다.");
    });

    app.get("/ajax2", function(req,res){
        res.render("ajax2.ejs");
    });

    app.get("/ajax2_get", function(req,res){
        var data = {
            method : "get",
            des : "이것은 get 호출로 얻은 데이터 입니다."
        }
        res.json(data);
    });

    app.post("/ajax2_post", function(req,res){
        var data = {
            method : "post",
            des : "이것은 post 호출로 얻은 데이터 입니다."
        }
        res.json(data);
    });

    app.put("/ajax2_put", function(req,res){
        var data = {
            method : "put",
            des : "이것은 put 호출로 얻은 데이터 입니다."
        }
        res.json(data);
    });

    app.delete("/ajax2_delete", function(req,res){
        var data = {
            method : "delete",
            des : "이것은 delete 호출로 얻은 데이터 입니다."
        }
        res.json(data);
    });

    app.get("/ajax3", function(req,res){
        res.render("ajax3.ejs");
    });

    app.get("/ajax3_result1", async function(req,res){
        setTimeout(()=>{
            var data = {
                method : "get",
                des : "이것은 get 호출로 얻은 데이터 입니다."
            }
            res.json(data);
        }, 5000);
    });

    app.get("/ajax4", function(req,res){
        res.render("ajax4.ejs");
    });

    app.post("/ajax4_result1", async function(req,res){
        var data = {
            id : req.body.id,
            content : req.body.content
        };
        res.json(data);
    });
}

