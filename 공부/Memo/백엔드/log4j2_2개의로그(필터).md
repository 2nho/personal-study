1.컨트롤러에서 debug레벨로 자세한 정보를 파일로 저장하면서   
2.콘솔에서 간단하게 지금 사용중인지 확인하기 위한 info 레벨 복합적 사용 필요 

가.하위에서 additivity="false" 하게 될 경우 상위 클래스 혹은 패키지에서 로그자체가 안되므로 true설정   
그 위의 단계에선 additivity="false" 설정하여 더 이상의 로그 전파를 막음(더 이상의 전파 불필요)       

나. 전파된 로그 debug레벨은 실제로는 필요없기 때문에 filter로 console에 나오지 않게 걸러준다.(info 레벨을 찍기 위해 전파시킨 것)



![image](https://github.com/user-attachments/assets/e7085ff5-c71f-4680-80bd-4f2d7371e41e)


## 추가 
하나의 클래스에만 적용할 경우   

두개의 어펜더 적용(각 필터로 조절)  

![image](https://github.com/user-attachments/assets/ce2c0da9-c11e-4167-b82c-5596dba6affd)


