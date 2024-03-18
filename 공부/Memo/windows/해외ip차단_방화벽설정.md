회사 서버 계정에 자꾸 모르는 해외 ip계정들이 url을 아무렇게나 던져대길래 이거 보안에 위험한걸.. 싶어서 해외 ip를 전부차단하고 싶어서 알아보던중 

https://www.ipdeny.com/ipblocks 사이트에서 나라별 ip를 제공해준다는걸 알게됐다. 그래서 whitelist 방식으로 한국 ip만 허용으로 바꾸고자 했는데

그럼 이제 이걸 어떻게 윈도우 방화벽에 추가하냐가 문제가 됐다.  

윈도우 파워쉘의 명령어를 통해 방화벽을 설정하려 했는데 url에서 값들을 추출해서 이걸 한번에 ip등록을 하려했는데   
직접 여러 ip를 입력하면 오류가 안났지만 url에서 추출해서 대입하면 오류가 나서 왜 그럴가 하구 헤맸다.

처음엔 String값으로 "ip1","ip2","ip3" 이렇게 넣어줘야하나 하구 해봤는데 안되서 마이크로소프트 공식문서를 확인했는데 string[] 형태를 넣어주라고 해서

```
$url = "https://www.ipdeny.com/ipblocks/data/aggregated/kr-aggregated.zone"
$ipAddresses = Invoke-RestMethod -Uri $url

줄바꿈으로 구분된 IP 주소들을 배열로 반환
$ipAddressArray = $ipAddresses -split "`n"

New-NetFirewallRule -DisplayName allow-kr-ip -Direction Inbound -Protocol TCP -LocalPort $allowedPort -RemoteAddress $ipAddressArray -Action Allow
```

위와 같이 코드를 파워쉘에 입력했는데 오류가 발생했다.. 분명 잘 넣어줬는데..?

그래서 url값들을 직접 ctrl+c ctrl+v 해서 test.txt파일에 저장하고 
```
$test = get-Content -path .\test.txt
echo $test

New-NetFirewallRule -DisplayName allow-kr-ip -Direction Inbound -Protocol TCP -LocalPort $allowedPort -RemoteAddress $test -Action Allow
```
위와같이 실행했더니 오류없이 방화벽에 리스트들이 잘 설정되었다. 

그래서 이번엔 url에서 받은 값을 html에서 복붙말고 직접 받아오게 해봤는데
```
$url = "https://www.ipdeny.com/ipblocks/data/aggregated/kr-aggregated.zone"
$ipAddresses = Invoke-RestMethod -Uri $url
# 줄바꿈으로 구분된 IP 주소들을 배열로 변환
$ipAddressArray = $ipAddresses -split "`n"
set-Content -Path .\test.txt -value $ipAddressArray

$test2 = get-Content -path .\test.txt

New-NetFirewallRule -DisplayName allow-kr-ip -Direction Inbound -Protocol TCP -LocalPort $allowedPort -RemoteAddress $test2 -Action Allow
```

이번엔 실행하니 오류가 났다.. 왜지..? 진짜왜지? 하던중 txt파일의 내용의 차이를 보니 맨마지막에 빈 공백 줄이 들어가고 있었다.  
그래서 혹시하고 사이트에 들어가 response값을 확인해보니 아래 스크린샷처럼 987번째 배열에서 빈값이 들어가있었다. 
![image](https://github.com/2nho/personal-study/assets/97571604/297b4eab-c120-46f8-a4d4-48125b4be604)

고로 오류원인은 빈 공백 줄이 들어가니 ip주소형태가 아닌 값이 들어가서 오류가 났던 것이다.. 

- 퇴근하구 집와서 3일 헤맸다.. 파워쉘 명령어도 낯설고 저런 오류는 참 쉬우면서도 발견하기 어렵다..

- 배치 파일 형태로 스케쥴러 만들어서 업데이트 되게 해야할까 싶기도 하고 이건 추후 고민해봐야겠다. 얼마나 자주바뀌는지를 모르니  
  

  
한국ip만 특정포트에 허용하는 파워쉘 명령어
PS C:\Windows\system32> $url = "https://www.ipdeny.com/ipblocks/data/aggregated/kr-aggregated.zone"  
>> $ipAddresses = Invoke-RestMethod -Uri $url  
>> $ipAddressArray = $ipAddresses -split "`n"  # 한줄씩 값이 출력되기때문에 줄바꿈을 기준으로 split
>> $ipAddressArray = $ipAddressArray[0..($ipAddressArray.Length - 2)]   # 처음부터~ 마지막전까지(마지막은 공백이므로 포함안함) 
>> $allowedPort = 9507  
>> New-NetFirewallRule -DisplayName Allow_white_list_KR+$allowedPort -Direction Inbound -Protocol TCP -LocalPort $allowedPort -RemoteAddress $ipAddressArray -Action Allow  
 
