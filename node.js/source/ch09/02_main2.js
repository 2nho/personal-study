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
        
        let sql1 = "insert into custommers (name, address) values (?, ?)";
        let input_data1 = ['Company Inc', 'Highway 37'];
        conn.query(sql1, input_data1, (err, result)=>{
            console.log("저장완료1");
            console.log("아이디 : "+result.insertId);
        });
        
        let sql2 = "insert into custommers (name, address) values ?";
        let input_data2 = [
            ['John', 'Highway 71'],
            ['Peter', 'Lowstreet 4'],
            ['Amy', 'Apple st 652'],
            ['Hannah', 'Mountain 21'],
            ['Michael', 'Valley 345'],
            ['Sandy', 'Ocean blvd 2'],
            ['Betty', 'Green Grass 1'],
            ['Richard', 'Sky st 331'],
            ['Susan', 'One way 98'],
            ['Vicky', 'Yellow Garden 2'],
            ['Ben', 'Park Lane 38'],
            ['William', 'Central st 954'],
            ['Chuck', 'Main Road 989'],
            ['Viola', 'Sideway 1633']
        ];
        conn.query(sql2, [input_data2], (err, result)=>{
            console.log("저장완료2");
            console.log("개수 : "+result.affectedRows);
        });

        conn.end();
    }
});

