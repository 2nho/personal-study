## 1일차
HashMAp 그대로 상속  
toString만 오버라이드해서 json형태로 만들어줌

디버깅결과 toString은 타지않음.. 왜?   
디폴트로 여겨지는건가 추측  

## 2일차
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

###2일차 결론 
![image](https://user-images.githubusercontent.com/97571604/214222045-249cf2bf-f4f8-4443-b168-b8c52ff3f103.png)

> 결과 : 이렇게 하면 단순 map 이랑 다를게 없는 같은 map 인데 왜 json형태로 값이 나오지? 
> sysout을 찍어도 json 형태 , 디버깅을 찍어도 json형태
> 그렇다면 toString에 어떤 비밀이 있지 않을까? 
##

