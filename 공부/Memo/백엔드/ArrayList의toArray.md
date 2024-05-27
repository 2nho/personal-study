```
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class CodeAssistance {

    public static final String EXT = "txt";

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input." + EXT);
        BufferedReader reader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        String[] array = lines.toArray(new String[lines.size()]); // 이부분
        Arrays.sort(array);
        for (String s : array) System.out.println(s);
    }
}

```
위 코드에서 toArray(new String[lines.size()]) 로 하게 되면 

- ArrayList.java 코드를 보게되면  
```
public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
```
전달된 배열 a의 길이가 ArrayList의 요소 수(size)보다 작으면, Arrays.copyOf 메소드를 사용하여 새로운 배열을 생성하고 반환

전달된 배열 a의 길이가 충분하면, System.arraycopy를 사용하여 elementData의 요소를 전달된 배열 a에 복사

만약 전달된 배열 a의 길이가 size보다 크다면, 복사된 요소 다음 위치에 null 값을 설정 => a[size] = null;

결국

new String[0]을 사용하면 JVM이 내부적으로 더 최적화된 방식으로 배열을 생성. 빈 배열을 전달하면, 메소드는 자동으로 정확한 크기의 배열을 생성하여 성능을 최적화하게됨 size보다 작으니까

또한 !!
동기화된 또는 동시 접근이 발생할 수 있는 컬렉션에서 크기가 사전 설정된 배열(new String[c.size()])을 사용할 경우, 
배열의 크기와 컬렉션의 실제 크기 사이에 불일치가 발생할 수 있음. 이는 경합 조건(race condition)을 유발할 가능성이 존재!  
new String[0]을 사용하면 이러한 일이 안일어남

따라사 아래와 같이 코드 변경 작성할 것 

```
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class CodeAssistance {

    public static final String EXT = "txt";

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input." + EXT);
        BufferedReader reader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        String[] array = lines.toArray(new String[0]);
        Arrays.sort(array);
        for (String s : array) System.out.println(s);
    }
}

```
