var myLogger2 = function (req, res, next) {
    console.log('LOGGED2');
    next();
};

module.exports = function(app){
    app.get("/", function(req, res){
        res.send("ROOT");
    });
    
    app.get("/test1", function(req, res){
        res.send("TEST1");
    });

    app.get("/test2", myLogger2,function(req, res){
        res.send("TEST2");
    });
};

