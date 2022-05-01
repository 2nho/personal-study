var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbo = db.db("mydb");
    // 한개만 출력
    dbo.collection("customers").findOne({}, function(err, result) {
        console.log(result.name);
    });
    console.log('');
    // 여러개 출력
    dbo.collection("customers").find({}).toArray(function(err, result) {
        for(var obj of result){
            console.log(obj._id,",",obj.name,",",obj.address);
        }
    });
    console.log('-----------------');
    // 특정 부분만 출력 1
    dbo.collection("customers").find({}, { projection: { _id: 0, name: 1, address: 1 } }).toArray(function(err, result) {
        for(var obj of result){
            console.log(obj.name,",",obj.address);
        }
    });
    console.log('-----------------');
    // 쿼리 검색 결과 출력
    let query = { address: "Park Lane 38" };
    dbo.collection("customers").find(query).toArray(function(err, result) {
        for(var obj of result){
            console.log("query result : ",obj._id,",",obj.name,",",obj.address);
        }
    });
    // 정규표현식 쿼리
    var query = { address: /^S/ };
    dbo.collection("customers").find(query).toArray(function(err, result) {
        for(var obj of result){
            console.log("query result : ",obj._id,",",obj.name,",",obj.address);
        }
    });
    db.close();
});
