![image](https://github.com/user-attachments/assets/add73893-0056-47fa-870a-5dc6c0a85595)

위와 같이 코드 작성 

log4j2.xml 설정

![image](https://github.com/user-attachments/assets/d1f698e1-4dfd-40d1-ac2a-3bc9bd599be4)

위와같이  packages ="해당 커스텀 어펜더가 속한 패키지명" 추가 

@Plugin(name = "SingleFile", category = "Core", elementType = "appender", printObject = true) 으로 작성했던 name을 xml에서 이름으로 사용 

<SingleFile name="single" fileNamePattern="${basePATH}/log_%d{yyyyMMdd_HHmmss}.log">  
		 	<PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} [%t] %-5p %c{1}:%L - %m%n"/>  
</SingleFile>

