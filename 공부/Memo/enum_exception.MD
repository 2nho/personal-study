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
