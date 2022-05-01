var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbo = db.db("mydb");
    // name 오름차순
    var mysort = { name: 1 };
    dbo.collection("customers").find().sort(mysort).toArray(function(err, result) {
        for(var obj of result){
            console.log("query result : ",obj._id,",",obj.name,",",obj.address);
        }
    });
    // name 내림차순
    var mysort = { name: -1 };
    dbo.collection("customers").find().sort(mysort).toArray(function(err, result) {
        for(var obj of result){
            console.log("query result : ",obj._id,",",obj.name,",",obj.address);
        }
    });
    // limit 구현
    dbo.collection("customers").find().limit(5).toArray(function(err, result) {
        for(var obj of result){
            console.log("query result : ",obj._id,",",obj.name,",",obj.address);
        }
    });
    db.close();
});
