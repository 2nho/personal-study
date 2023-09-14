DB툴을 이용해서 접속 시에는 문제가 없는데   
CentOs가 깔린 컴퓨터에서 로컬로 접속 시 denined 오류가 떠서   
이유를 찾아보니 계정생성시 익명의 사용자가 localhost로 생겨버리면   
로그인 하려는 사용자를 위한 자격 증명이 아닌 익명 자격 증명이 사용되서 그렇다고 한다.  

![image](https://github.com/2nho/personal-study/assets/97571604/cf45f4eb-a56e-424a-83ad-2f2725876d31)


참고 https://mariadb.com/kb/en/troubleshooting-connection-issues/#localhost-and
