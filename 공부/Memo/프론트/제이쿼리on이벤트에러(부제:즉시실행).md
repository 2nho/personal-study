기존 다른 인원이 짠 코드에서 method 함수가 분명 

$("#a").on("click", method()); 의 형태로 클릭 이후 발생하게 되어있는데 

페이지가 열리자마자 실행되어 어디가 잘못이길래 이럴까 싶어서 고민하다 제이쿼리 api 문서를 확인해보았더니 

$("#a").on("click", method); 의 형태로 사용되어야 했다.

아마 콜백함수로 사용할 함수 이름을 적는 자리에 함수이름이 아닌 함수를 실행하는 코드로 적혀있어 

정의하자마자 실행이 된거 같다.



++ 비슷한 오류 동일하게 겪어서 추가

selectBoxTexture 함수를 실행 후 callback으로 한번 더 selectBoxTexture 실행시키려고 했는데   
selectBoxTexture(element,classId,selectBoxTexture(element,classId,null)) 의 코드가 제대로 실행이 되지 않아   
왜그럴까 의문을 가졌는데 위와 같은 오류라는 판단이 들어 생각을 다듬은 결과   


selectBoxTexture(element, classId, selectBoxTexture(element,classId,null))를 즉시실행이 되지 
  
selectBoxTexture(element, classId, function(){selectBoxTexture(element,classId,null)}) 의 형태로 바꿔 즉시실행이 아닌 함수를 정의할 수 있도변
변경하였다.

![image](https://user-images.githubusercontent.com/97571604/219384160-8c81e52c-750a-46e0-b7c0-b287d6387c3d.png)  
=> 함수를 호출하면 그자리에 return 값을 반환하는데 위의 경우 반환값이 없기에 callback으로 실행시키려던 selectBoxTexture가 즉시실행되면서 return값이 없어 undefined를 반환했다. 그래서 return 값으로 "콜백"을 적으니 undefined가 아닌 "콜백"을 반환하는 것을 확인할 수 있었다.
