if test = _parameter  또는 if test = value  사용 

마이바티스에서 동적쿼리는 getter 메소드를 통해 값을 가져오기 때문에 오류가 난다. 그렇기 때문에 특수한 매개변수인 _parameter 또는 value를 사용해야 getter가없는 

primitve type을 파라미터로 넘겨줄 수 있다.


- 공식문서에는 적혀있지 않으나 마이바티스 구글 그룹에 2011년 질문에 대한 답변에 사용법 언급


+ 마이바티스 깃허브 이슈에 대한 답변 언급

Java does not allow us to obtain the parameter name at runtime, unfortunately.
Please search 'java parameter name' for more detailed explanation.

So, as I explained, you may have to 1) modify the xml mapper as follows:
```
<when test="_parameter &lt; 0">
  id = 0-#{id}
</when>



Or 2) add @Param("id") to the method parameter.
User findById(@Param("id")int id);
```

+
As your statement has one simple type parameter without @Param annotation, you need to use the implicit name _parameter to reference it in the OGNL expression or ${}.
