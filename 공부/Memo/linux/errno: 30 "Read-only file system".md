왜 /var/log 등에는 로그파일을 생성할 수 있지만 /etc , /usr에는 안되지..? 의문을 가지고 계속 chown , chmod 만 변경해도 안되길래 찾다가 발견!

/usr/lib/systemd/system/mariadb.service  

# Prevent writes to /usr, /boot, and /etc  
ProtectSystem=full  


해당 디렉토리를 읽기 전용으로 마운트  
디렉토리에 대한 파일 쓰기가 제한  


/home, /root 등도 아래와 같이 ProtectHome설정으로 인해 막혀있음

# Prevent accessing /home, /root and /run/user  
ProtectHome=true  

의도가 있기 때문에 굳이 건드리지 말자 !
