const mysql = require('mysql2');

let conn_info = {
    host : 'localhost',  // 호스트 정보
    port : 3306,  // 포트 번호
    user : 'root',  // 접속id
    password : '1234',  // 접속 패스워드
    database : 'mydb'  // 디비이름
};

let conn = mysql.createConnection(conn_info);

conn.connect(function(err){
    if(err){
        console.log('접속오류');
        console.log(err);
    }else{
        console.log('접속성공');
        
        var sql1 = "SELECT * FROM custommers";
        conn.query(sql1, (err, result, fields)=>{
            console.log('컬럼 정보');
            for(let obj of fields){
                console.log(obj.name,'  ',obj.table);
            }
            console.log('데이터 정보1');
            for(let obj of result){
                console.log("id : "+obj.id+"   name : "+obj.name
                +"   address : "+obj.address);
            }
        });

        var sql2 = "SELECT name, address FROM custommers WHERE id = ?";
        let data1 = 22;
        conn.query(sql2, data1, (err, result, fields)=>{
            console.log('데이터 정보2');
            for(let obj of result){
                console.log("id : "+obj.id+"   name : "+obj.name
                +"   address : "+obj.address);
            }
        });

        conn.end();
    }
});

