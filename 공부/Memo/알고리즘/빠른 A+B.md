문제
첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.

출력 
각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.

예제 입력
5
1 1
12 34
5 500
40 60
1000 1000

예제 출력
2
46
505
100
2000




일반적인 스캐너 print로는 시간초과 걸리므로 
힌트 : BufferedWriter, StringBuilder로 출력을 모아 놓았다가 그 String을 System.out.println하는 방법을 이용 해야한다고함 

버퍼리더 버퍼라이터는 처음이라 생소했다..
```
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			int a = Integer.parseInt(string.split(" ")[0]);
			int b = Integer.parseInt(string.split(" ")[1]);
			bw.write(a+b+"\n");
		}
		bw.flush();
    }
 ```
 임포트 까지 일일이 해줘야 해서 IDE키고 해야하는게 편할거 같다.
