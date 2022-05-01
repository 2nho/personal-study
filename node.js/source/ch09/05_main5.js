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

        let sql = "UPDATE custommers SET address = ? WHERE id = ?";
        let data = ['Seoul 21', 18];
        conn.query(sql, data, function (err, result) {
            console.log(result.affectedRows + " record(s) updated");
        });

        conn.end();
    }
});

