# #spring 마이바티스 활용 중 의문점 정리 

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
 SqlSession 호출 시 
 
<T> T selectOne(String statement, Object parameter)
<E> List<E> selectList(String statement, Object parameter)
<T> Cursor<T> selectCursor(String statement, Object parameter)
<K,V> Map<K,V> selectMap(String statement, Object parameter, String mapKey)
int insert(String statement, Object parameter)
int update(String statement, Object parameter)
int delete(String statement, Object parameter)

 위 메소드를 통해 호출하는데 select ,insert, deletem update의 경우 매개변수가 비슷하다. 
   
 이와는 별개인 경우는 아래와 같은데 
<E> List<E> selectList (String statement, Object parameter, RowBounds rowBounds)
<T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds)
<K,V> Map<K,V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowbounds)
void select (String statement, Object parameter, ResultHandler<T> handler)
void select (String statement, Object parameter, RowBounds rowBounds, ResultHandler<T> handler)
   
- void select (String statement, Object parameter, ResultHandler<T> handler) 이처럼  handler가 존재하게되면 (xml파일에서 resulttype을 적어주는 경우)
   select 가 아닌 다른 엘리먼트를 적어주면 오류가 난다.
   [사실 구분을 위해서도 select문에 select, insert문에 insert적어주는게 정확하긴 하다. 다만 멀티쿼리에서 어떻게 실행이 되는지에 대한 고민으로 시작된 탐구였다] 
   
   ![xml](https://user-images.githubusercontent.com/97571604/176458335-19709356-bd7b-46a4-a923-1c93bf5904b8.png)
   추가적으로 
   위 그림을 확인하면 delete의 id는 참조하지만 delete 자체는 참조하지 않는 걸 알 수 있다. delete를 참조하는 경우는 dao에서 delete메소드를 실행하면서 delete문을
   실행할 때 참조하는 것 같다.

   
   ## +++멀티쿼리는 mariadb, mysql JDBC에만 있는 기능인거 같다. 오라클은 존재x
   https://stackoverflow.com/questions/46072041/mybatis-mapper-xml-execute-multiple-sql-statements-in-one-mapper-method
