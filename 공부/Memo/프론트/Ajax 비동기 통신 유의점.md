```
비동기 통신은 일련의 과정이 아니기에 
success함수가 온전히 실행되기 전에 success함수 호출 이후 발생하는
값을 가지고 다른 작업을 할 시 undefined가 나올 수 있다.

++(보충) ajax의 success의 값을 이용해 함수 return값을 결정하려 할 때 undefined가 리턴되는데 
Ajax요청 후 응답을 받기 전에 return이 실행됐기 때문이다.

function A(Param){
	let data = data;
	let boolean = '';
	$.ajax({
		type: "GET",
		async: false, // <- 해당 옵션을 통해 비동기 처리 방식을 동기화로 처리해 success함수가 실행 된 이후 의 값을 return 값으로 얻을 수 있다. async : true 가 기본 
    	url: url,
    	data: {data},
    	contentType: "text/plain",
        error: function(error){
			         console.log("error");
        },
        success: function(result){
        	        console.log(result);
        	        result = JSON.parse(result);
		            	if(result.data == null){ 
				          boolean = false; 
			           }else{
			          	boolean = true; 
		          	}
		      }
    });
	return boolean;
}


타이밍의 차이 유념 ! 오류 발생시 오류메세지를 뱉는 일반적인
경우와는 다르기에 간과하기 쉬움

document ready 
window on load  에서는 ready가 load보다 더 일찍 
발생
```

```
++++++++++ 22.8.24 추가
동적태그에 이벤트를 먹이기 위해 기존 생성된 dom 오브젝트에 이벤트를 거는 것처럼
한 함수 안에서 두개의 ajax가 실행되면 이전 ajax가 전부 실행되고 이후 ajax가 실행된다는 보장이 없기에 
타이밍의 오류가 생길 수 있다. 
이를 해결 하기위해 timeout 을 설정 할 수도 있지만 이전 ajax success함수에 이후 ajax를 실행하는 것도 좋은 방법 같다. 
```
