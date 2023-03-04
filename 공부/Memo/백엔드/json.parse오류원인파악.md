DB에서 json 스트링 값을 
![image](https://user-images.githubusercontent.com/97571604/218755500-23cd722d-fb36-4eaa-875b-e0252cfe1bc1.png)   
이렇게 받아와 json-simple라이브러리를 이용해 파싱해서 이용했는데  
front에서 중간에 null이 뜨는 값이 있어서 확인해보니   

넘겨주는 값은 14개인데    
값    
.  
.  
null  
null  
값  
값  
.  
.  
이런식으로 null포함 16개가 나와서 원인을 파악하기 위해 디버깅을 돌려보았다.

위 사진을 보면 파싱의 기준을 "/"으로 잡는데 

db에서 넘어오는 값중에 인사/총무 이런식으로 /값이 포함된 값이 있어서 
{인사  
총무}
이런식으로 잘못 split되어서  
![pasrse=null](https://user-images.githubusercontent.com/97571604/222914512-4426b7bb-e186-4111-9619-9f8d88269328.PNG)  

값의 시작은 "{", 마지막은 "}"으로 끝나야 하는데 각각 시작과 끝에 마지막 해당하는 값이 없어서 오류가 났던 것이다.  

![image](https://user-images.githubusercontent.com/97571604/222914587-28818894-52e6-408e-886e-154ddf99c90d.png)  
(json-simple은 이렇게 각각 값을 찾아 switch-case문을 돌린다.)
