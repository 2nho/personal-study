Mybatis 3.2.4부터는 TypeHandler로 전달인자 추론이 가능해져서 parameterType이 무시됨

<참고>
That parameter is optional. It can be omitted, and, as you discovered, most of the times it can even be wrong and cause no problems.

Up to 3.2.3 the parameterType attribute is just ignored but in 3.2.4 it will be used (but still optional) so in case it is wrong MyBatis will fail. We will include this in the release notes.

Regarding the doc. It is indeed incomplete. I will add an statement pointing that it is optional.

But, during startup we do not know about the actual parameter so we can only use the xml attribute (or the declared parameter if using a mapper interface). You can still omit the attribute and it will be calculated later (with a little overhead).

출처: https://github.com/mybatis/mybatis-3/issues/102#issuecomment-28976308 

마이바티스 홈페이지에서 한국어로 들어가면 옵션이라는 설명이 없지만 영어 원문일 경우 선택옵션이라는 설명이 되어있음
