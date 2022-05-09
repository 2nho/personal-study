enum exception 

코드를 보다 기존 알던 예외코드들과는 다른 마치 커스텀으로 만든거 같은
예외처리를 보았다. 
```
@Getter
public enum Exception {

	NotExistMemberException("1000","not exist member"),
	NotExistDeviceException("1000","not exist device"),
	TransactionFailException("1001", "transaction failed"),
	NotAllowedTreeLevelException("1002", "not allowed tree level"),
	DeletedMemberException("1003", "deleted member"),
	NotAllowedParamException("1004", "not allowed parameter");
	
	private String message;
	private String code;
	
	
	Exception(String code, String message) {
		this.message = message;
		this.code = code;
	}
}
```
```
public class NotExistDeviceException extends CommonException{

	public NotExistDeviceException() {
		this.code = Exception.NotExistDeviceException.getCode();
		this.message = Exception.NotExistDeviceException.getMessage();
	}
}
```
코드를 읽으면서 예외처리를 본인이 원하는 방식으로 처리할 수 있다는 
것을 처음 알았다


Enum은 열거형이라고 불리며, 서로 연관된 상수들의 집합을 의미합니다.

기존에 상수를 정의하는 방법이였던 final static string 과 같이 문자열이나 숫자들을 나타내는 기본자료형의 값을 enum을 이용해서 같은 효과를 낼 수 있습니다.

Enum의 장점

1. 코드가 단순해지며, 가독성이 좋습니다.

2. 인스턴스 생성과 상속을 방지하여 상수값의 타입안정성이 보장됩니다.

3. enum class를 사용해 새로운 상수들의 타입을 정의함으로 정의한 타입이외의 타입을 가진 데이터값을 컴파일시 체크한다.

4. 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 알 수 있습니다.
