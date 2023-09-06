카프카 설치 및 실행 

- 현재 오류 : 한글로 메시지 작성 시 외계어가 뜸



아무런 정보도 없을 수 없어 확인차 리눅스계열 우분투 설치 후 테스트하니 정상적으로 한글이 출력됨 다만 한글이 2byte라서 인지 글자를 지울때 어떤때는 한번에 한칸 간격이 줄어드는데 어떨때는 반칸이 줄어드는 경우가 있음 반칸의 경우 외계어 등장
![image](https://github.com/2nho/personal-study/assets/97571604/2782b6e0-920b-4074-a4ec-48500663460f)


![image](https://github.com/2nho/personal-study/assets/97571604/8062692e-a35e-46a8-87c4-f35ccbe3d2da)

로그 파일을 확인해보니 윈도우랑 동일하게 아스키코드로 표현가능한 알파벳 숫자 같은 경우는 정상적으로 보임 

한글은 그대로 한글로 나타나지 않고 변환되어 저장되어있음


우분투 참고 사이트 https://depotceffio.tistory.com/entry/%EC%9A%B0%EB%B6%84%ED%88%AC%EC%97%90-%EC%95%84%ED%8C%8C%EC%B9%98-%EC%B9%B4%ED%94%84%EC%B9%B4-%EC%84%A4%EC%B9%98%ED%95%98%EA%B8%B0
