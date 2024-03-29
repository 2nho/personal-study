기존 외부 라이브러리를 추가한 방법을 탐구하던 중 pom.xml에 
```
<!-- 외부 라이브러리 -->
		<dependency>
			<groupId>com</groupId>
			<artifactId>jfxrt</artifactId>
			<version>1.0.0</version>
			<scope>system</scope>
			<systemPath>${project.basedir}/lib/jfxrt-1.0.0.jar</systemPath>
		</dependency>  
```   
의 형태로 jar파일을 추가한 것을 보았다. 

워크스페이스의 root 디렉토리에 bin 폴더를 만들어서 추가한 형태였는데 
src의 web-inf/lib에 중복해서 파일을 배치한 것을 보고 기이하게 여겨 파본결과 


pom.xml에 정의한 저 형태는 쓸모가 없고 실질적으로  src/main/webapp/WEB-INF/lib에 위치한 라이브러리를 이용하는 것을 여러번 실행한 결과 알아냈다.
프로젝트의 Deployment Assembly를 보면 Maven Dependencies의 빌드 후 위치를 나타내는 Deploy path를 보면 WEB-INF/lib 에 저장되는 것을 알 수 있는데 

src/main/webapp은 Deploy Path가 "/"이기 때문에 결국 src/main/webapp/WEB-INF/lib 와  Maven Dependencies 의 빌드 후 위치가 같다는 것을 알 수 있다. 
그렇기에 src/main/webapp/WEB-INF/lib 에 외부라이브러리를 위치시키면 메이븐의 라이브러리와 동일하게 빌드 되어 인식된다.( 메이븐 빌드 시 오류가 생길 수 있다는 경우도 있다니 주의! )


----------------------------
처음 pom.xml 에 추가한 형태는 IDE상에서 Maven Dependencies에서는 보이지만 scope 의 system 이기 때문에 maven 빌드 시 해당 jar 파일이 포함되지 않는다. ( 이 부분을 몰라서 왜 그러지 한참 헤맴) ++ [메이븐의 scope는 compile, runtime, test, provided, system 이 있습니다. 이 중에서 custom jar를 관리하기 위해서 system scope를 지정해서 사용했었는데, war파일 패키징에서 누락되게 됩니다. WEB-INF/lib 폴더에 복사되지 않는다는 뜻입니다. 이 때문에 다음과 같이 코드를 작성했다면, in-project 저장소를 구성해서 변경하는 것이 좋습니다.] - 공식문서상 deprecated!

따라서 src/main/webapp/WEB-INF/lib 에 직접 넣어주는 형태가 아니고 pom.xml에서 직접 빌드 할 수 있는 방법이 궁금해 찾아보았는데 
로컬을 Repository 로 이용하는 방법과 플러그인을 추가하는 방법이 있는데  로컬을 이용하는 방법은 아무리 해도 되지 않았고 후자의 방법은 
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>

    <configuration>
        <webResources>
            <resource>
                <!-- 로컬 lib파일 경로 -->
                <directory>${project.basedir}/local-repo</directory>
                <includes>
                    <include>추가할라이브러리.jar</include>
                    ...
                    ...
                </includes>
                <targetPath>WEB-INF/lib</targetPath>
            </resource>
        </webResources>
    </configuration>
</plugin>
```
을 통해 빌드 시 외부 jar파일을 같이 빌드 할 수 있다.


요약 : scope 형태로 참조하는 것은 deprecated 되었기 때문에 사용을 지양  
외부라이브러리를 추가하는 방법으로는

1. pom.xml상에서 scope를 이용해 참조한다음 플러그인을 통해 jar파일 배포시 저장 ( deprecated 주의 )

2. src/main/webapp/WEB-INF/lib 에 직접넣기 ( 메이븐 빌드시 오류날 수 있음 주의!)

3. build path에서 Add JARs를 통해 추가 후 Deployment Assembly에서 Add (솔직히 제일 간단)


+++ 추가 


```
<repository>
  <id>in-project</id>
  <name>custom jars</name>
  <url>file://${project.basedir}/lib</url>
</repository>

<dependency>
 <groupId>com</groupId>
 <artifactId>jfxrt</artifactId>
 <version>1.0.0</version>
 <!-- <scope>system</scope>
 <systemPath>${project.basedir}/lib/jfxrt-1.0.0.jar</systemPath> -->
</dependency>
```
레파지토리됨 - 대신 폴더의 형태가 lib/com/jfxrt/1.0.0/jfxrt-1.0.0.jar 형태로 존재해야


+ 참고하기 좋은 스택오버플로우 글   

https://stackoverflow.com/questions/10665096/how-to-add-external-jar-to-maven-webapp-project
