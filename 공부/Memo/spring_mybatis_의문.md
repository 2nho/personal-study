스프링에서 마이바티스를 이용해 멀티쿼리를 작성하던 중 의문이 생겼다. 대부분의 예시가 delete문이나 update문의 foreach를 통해 같은 쿼리 형식을 이용했지만

현 프로젝트에서는 update와 delete를 동시에 행했는데 문제없이 실행되었다. 그래서 왜 문제없이 실행이 되는 것인가에 대해 의문이 생겼고 

update delete문 뿐만이 아닌 select문을 섞어도 되나 테스트를 해보았다. 

결과는 사용하는 혹은 사용할 수 있는 엘리먼트 속성이 select문과 update,delete문이 같다면 문제없이 실행되었다. 

예로 

<delete id="test" >
   		DELETE FROM test_table 
   		WHERE member = #{A}  
 </delete> 를
 
 <update id="test" >
   		DELETE FROM test_table 
   		WHERE member = #{A}  
 </update> 로 바꾸어도 문제없이 실행된다. 
 
 공식 마이바티스 문서를 확인한 결과 
