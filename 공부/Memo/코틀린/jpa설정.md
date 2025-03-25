![image](https://github.com/user-attachments/assets/58f1495c-1f83-4f05-990d-011fcb35c20a)

명시적 초기화 필요:

클래스 본문에서 선언된 프로퍼티는 반드시 초기값을 가져야 합니다. 코틀린은 모든 프로퍼티가 초기화되어야 한다는 규칙을 강제합니다.

nullable 타입(Long?, String?)은 기본값으로 null을 설정하거나, non-null 타입(String)은 기본값을 제공해야 합니다.

초기화가 없으면 컴파일 오류 발생

![image](https://github.com/user-attachments/assets/4cbedcdd-742d-4959-8808-1ec88730130d)

초기화 없이도 동작 가능:

주 생성자에서 선언된 프로퍼티는 초기값이 없어도 kotlin-jpa 플러그인이 처리해줍니다.

kotlin-jpa 플러그인은 JPA 엔티티 클래스에 매개변수가 없는 기본 생성자를 자동으로 추가합니다. 이 기본 생성자는 모든 프로퍼티를 null로 초기화하거나, non-null 타입에 대해 적절한 기본값을 설정합니다.

내부적으로 처리되는 방식:
kotlin-jpa 플러그인은 컴파일 시점에 다음과 같은 작업을 수행합니다:

매개변수가 없는 기본 생성자를 바이트코드 수준에서 추가합니다.

기본 생성자가 호출될 때 모든 프로퍼티를 null로 초기화합니다.


![image](https://github.com/user-attachments/assets/02583b54-634c-43ca-b227-8c934aa11767)

