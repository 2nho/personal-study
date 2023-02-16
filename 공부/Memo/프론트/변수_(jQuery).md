log4j로 로그 확인 중 parameterObject에 _=1639293812 식으로 계속 넘겨주지 않은 파리미터 값이 들어가 있는 것이 이상해 확인해봤는데 
처음엔 스프링이 로그인된 유저의 요청인지 확인하는 값으로 넘겨주는 것인가 싶어 알아보았지만
관련 문서나 글이 없어 그럼 혹시 ajax 호출 시 넘겨주는 값인가 싶어 ajax parameter underscore라는 키워드로 검색해보았는데 
https://stackoverflow.com/questions/3687729/who-add-single-underscore-query-parameter 에서 실마리를 찾을 수 있었다.

결론 :
JQuery와 같은 ajax 도구는 브라우저 요청이 cache때문에 최신 응답을 받지 못할 경우를 대비 해
cache = false 등의 옵션값을 주게되면 _=1639293812 와 같은 매번 변하는 값(타임스탬프)을 같이 보내 브라우저가 새로운 요청이라 판단하게 만들어 
캐시된 값을 제공하지 않게 한다.




++ 추가 제이쿼리 공식 문서상 발견 
cache (default: true, false for dataType 'script' and 'jsonp')
Type: Boolean
If set to , it will force requested pages not to be cached by the browser. Note: Setting to false will only work correctly with HEAD and GET requests. It works by appending "_={timestamp}" to the GET parameters. The parameter is not needed for other types of requests, except in IE8 when a POST is made to a URL that has already been requested by a GET.falsecache
요청된 페이지가 브라우저에서 캐시되지 않도록 합니다. 참고: false로 설정하면 HEAD 및 GET 요청에서만 올바르게 작동합니다. GET 매개변수에 "_={timestamp}"를 추가하여 작동합니다. GET.falsecache에서 이미 요청한 URL에 대해 POST가 수행되는 경우 IE8을 제외하고 다른 유형의 요청에는 매개변수가 필요하지 않습니다.

![image](https://user-images.githubusercontent.com/97571604/195633711-527c905b-21b4-40fc-8cb7-3b6736ad360e.png)

RTFM... 어디서 발생했는지 조차 명확히 몰랐으니 어떤 공식문서를 봐야할지 몰랐다..
