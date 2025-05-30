## 1일차
HashMAp 그대로 상속  
toString만 오버라이드해서 json형태로 만들어줌(그럼 이것으로 json형태를만들어주는건가?)

하지만 디버깅결과 toString은 타지않음.. 왜?   
디폴트로 여겨지는건가 추측  

## 2일차 - 디버깅분석
![image](https://user-images.githubusercontent.com/97571604/214219506-b518ba70-5ded-4854-81d3-aabc8b9142c3.png)

테스트결과 json형태로 잘나오길래 toString은 호출이 여전히 안되는데 왜일까??

![image](https://user-images.githubusercontent.com/97571604/214220031-91361e4f-8ad4-4826-bb9f-851f4affab09.png)
생성자로 Map을 매개변수로 넣어주면 super를 타고 HashMap 단순 HashMap생성을 함

![image](https://user-images.githubusercontent.com/97571604/214220236-00bc5dd5-efeb-4871-8258-3731f36a946f.png)  
putMapEntries 메소드가 실행되고 putMapEntries메소드에서 putVal 메소드를 또 실행 
![image](https://user-images.githubusercontent.com/97571604/214220579-347831ea-9854-47c6-9392-c870b9dc4fc6.png)  
putVal에서 노드생성   
![image](https://user-images.githubusercontent.com/97571604/214220742-ff7fe81b-7da1-4ad0-8ab7-25008c816fc2.png)    
resize()로 크기조정

### 2일차 결론 
![image](https://user-images.githubusercontent.com/97571604/214222045-249cf2bf-f4f8-4443-b168-b8c52ff3f103.png)

> 결과 : 이렇게 하면 단순 map 이랑 다를게 없는 같은 map 인데 왜 json형태로 값이 나오지?   
> sysout을 찍어도 json 형태 , 디버깅을 찍어도 json형태  
> 그렇다면 toString에 어떤 비밀이 있지 않을까? 
  
    
## 3일차
toString : toString 메서드는 객체를 println, printf, 문자열 연결 연산(+), assert구문, 디버거가 객체를 출력할때 자동 호출!  
그래서 sysout으로 찍을때랑 디버깅을 했을 때 단순히 HashMap에 담긴 값이  
JSON-SIMPLE에서 오버라이드한 toString 메소드를 타고 json형태로 출력이 되었던 것이었다!  

++  
![image](https://user-images.githubusercontent.com/97571604/214223352-24bfc036-98af-4f73-b922-079fc9fe48bb.png)

json-simple은 JSONValue 에서

![image](https://user-images.githubusercontent.com/97571604/214223499-c8c618e8-da21-448c-9ef9-392f572c3e50.png)  
이렇게 분기를 태워서 해당 타입에 맞는 json형태로 바꿔서 출력해준다!




### 추가 
![image](https://user-images.githubusercontent.com/97571604/214224105-9f65d78e-ebe2-4ca6-b494-81f7ba1a33cd.png)

variables에서 해당 객체에 우클릭하고 New Detail Formatter를 클릭하면 해당 객체에 맞는 toString을 재정의 할 수 있다.  
(toStirng이 항상 원하는 결과를 보여주는게 아닌 주소값을 보여줄수도 있기때문에)

## 디버거가 toString을 사용한다는 참고

While debugging and inspecting variables/objects in your debug perspective, you might encounter textual representations of objects that are not really meaningful.   Usually the .toString() method on an object is used for the debug UI. It’s not the greatest idea to implement the .toString() method just for debugging purposes.   Instead you can set up a detail formatter that takes care of the textual representation of your object.  
디버그 관점에서 변수/개체를 디버깅하고 검사하는 동안 실제로 의미가 없는 개체의 텍스트 표현이 나타날 수 있습니다.   
일반적으로 디버그 UI에는 개체의 .toString() 메서드가 사용됩니다. 디버깅 목적으로만 .toString() 메서드를 구현하는 것은 좋은 생각이 아닙니다.   
대신 객체의 텍스트 표현을 처리하는 상세 포맷터를 설정할 수 있습니다.

## 디버거가 toString을 사용한다는 참고2(공식문서)
https://archive.eclipse.org/eclipse/downloads/documentation/2.0/html/plugins/org.eclipse.platform.doc.isv/reference/api/org/eclipse/debug/ui/package-summary.html

![image](https://user-images.githubusercontent.com/97571604/214227141-d22340d4-ce3d-44c9-8508-635e0a43e8dc.png)  

the Java debugger displays the result of invoking 'toString()' on the selected variable in this area.
