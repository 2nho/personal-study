프로젝트 중 쿼리문 작성 중 마이바티스의 동적쿼리를 이용해 조건을 태우다   
문득 서브쿼리를 쓰는 것보다 조인이 낫지 않을까 싶어 성능차이를 알아본 결과   
서브쿼리보다 조인문을 쓰는 것이 성능에서 월등함을 알았다.
<choose>
	   <when test='textureCode == "dept"'>
	  	select a.texture_id, a.name, a.class_id, b.name AS inherit from texture a
		inner join texture b
		ON a.class_id=b.texture_id
		WHERE a.texture_code = 'dept'
		<if test='compId != 0'>
		and a.class_id = #{compId}
		</if>
		order by a.texture_id;		
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
