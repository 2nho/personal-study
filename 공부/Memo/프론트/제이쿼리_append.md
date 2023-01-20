![image](https://user-images.githubusercontent.com/97571604/213688285-ad398f33-5881-4eef-9f87-5566714c70c8.png)


첫번째 방법은 htmlString 방법 ( 참고 :+는 줄이 바뀌면서 문자열이 연결되지 않는 것을 연결하는 방법 \를 통해서도 할 수 있음)


두번째 방법은 제이쿼리 방법

![image](https://user-images.githubusercontent.com/97571604/213688601-fc2e66eb-1598-45c2-99fa-c694b123f819.png)


-해석  
문자열이 매개 변수로 전달되면 jQuery는 문자열을 검사하여 HTML처럼 보이는지 확인합니다 (즉, 로 시작). 그렇지 않은 경우 문자열은 위에서 설명한 대로 선택기 식으로 해석됩니다. 그러나 문자열이 HTML 스 니펫 인 것처럼 보이면 jQuery는 HTML에 설명 된대로 새 DOM 요소를 만들려고합니다. 그런 다음 jQuery 객체가 생성되어 이러한 요소를 참조하는 객체가 반환됩니다. 이 객체에 대해 일반적인 jQuery 메소드 중 하나를 수행 할 수 있습니다.$()<tag ... >
  
 $("div")일 경우 dom요소 중 div를 선택 
  
  $("<div></div>") 일 경우 div요소 생성!
