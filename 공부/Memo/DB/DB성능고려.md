프로젝트 중 쿼리문 작성 중 마이바티스의 동적쿼리를 이용해 조건을 태우다   
문득 서브쿼리를 쓰는 것보다 조인이 낫지 않을까 싶어 성능차이를 알아본 결과   
서브쿼리보다 조인문을 쓰는 것이 성능에서 월등함을 알았다.( 경우에 따라서 서브쿼리가 낫다는 경우도 있다고 한다. 컬럼 갯수가 많을 경우 풀서치하게 되는 경우(조인) 서브쿼리로 컬럼 갯수를 줄이는 것이 이득)
```
<choose>
	   <when test='textureCode == "dept"'>
	  	select t1.texture_id, t1.name, t1.class_id, t2.name AS inherit 
	  	from texture t1
		join texture t2
		ON t1.class_id = t2.texture_id
		WHERE t1.texture_code = 'dept'
		<if test='compId != 0'>
		and t1.class_id = #{compId}
		</if>
		order by t1.texture_id;		
	  </when>
	  <otherwise> 
	  	select texture_id, name, class_id,second_code, (select "") as inherit,
		IFNULL((SELECT class_id FROM texture as t2 WHERE t1.class_id = t2.texture_id),'') as comp 
		from texture AS t1 
		where texture_code = #{textureCode}
		<if test='compId != 0 and textureCode == "team"'>
		AND (SELECT class_id FROM texture as t2 WHERE t1.class_id = t2.texture_id) = #{compId};
		</if>
		
		<if test='compId != 0 and textureCode == "comp"'>
		AND texture_id = #{compId};
		</if>
	  	<!-- select texture_id, name, class_id,second_code, (select "") as inherit from
		texture where texture_code = #{textureCode}
		order by class_id; -->
	  </otherwise>
	</choose>   
  ```
  
  그래서 위 코드에서 
``` 
-- team일 경우	
  SELECT t1.texture_id,t1.name,t1.class_id,t1.second_code, t2.texture_id,t3.texture_id,t3.name
		from texture as t1
		join texture as t2
		on t1.class_id = t2.texture_id  
		JOIN texture AS t3
		ON t2.class_id = t3.texture_id
		WHERE t3.texture_code = 'comp'

	-- dept일 경우 	
SELECT t1.texture_id,t1.name,t1.class_id,t1.second_code, t2.name
		from texture as t1
		join texture as t2
		on t1.class_id = t2.texture_id 
		WHERE t2.texture_code = 'comp' 

	--	WHERE t2.texture_code = 'team'		
  
```
경우로 조인을 해서 개선시켜 보았다. 

하나의 sql문으로 모든 것을 해결하기 보단 마이바티스의 동적쿼리를 이용해    
db성능을 우선 고려해 낫다는 생각으로 개선해보았다.
