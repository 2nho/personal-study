var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbo = db.db("mydb");
    // 주어진 조건 쿼리
    var myquery = { address: "Valley 345" };
    // 업데이트 할 내용
    var newvalues = { $set: {name: "Mickey", address: "Canyon 123" } };
    // 맨 위의 최상단에 위치한 하나의 도큐먼트만 업데이트
    dbo.collection("customers").updateOne(myquery, newvalues, function(err, res) {
        if (err) throw err;
        console.log("1 document updated");
    });
    // 주어진 조건 쿼리 (정규표현식)
    var myquery = { address: /^S/ };
    // 업데이트 할 내용
    var newvalues = {$set: {name: "Minnie"} };
    // 조건 쿼리에 해당되는 모든 내용을 업데이트할 내용으로 업데이트
    dbo.collection("customers").updateMany(myquery, newvalues, function(err, res) {
        if (err) throw err;
        console.log(res.result.nModified + " document(s) updated");
    });
    db.close();
});

