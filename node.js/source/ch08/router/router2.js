module.exports = function(app){
    app.get("/", function(req,res){
        res.render("index.ejs");
    });

    app.get("/test1", function(req, res){
        res.render("test1.ejs");
    });

    app.get("/test2", function(req, res){
        var date = new Date();

        var render_data = {
            str : "문자열입니다",
            number : 100,
            date : date
        }

        res.render("test2.ejs", render_data);
    });
}

