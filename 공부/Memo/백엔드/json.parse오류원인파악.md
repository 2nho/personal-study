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
