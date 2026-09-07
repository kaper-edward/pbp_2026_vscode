# 0202 문자열 비교

두 줄의 문자열을 읽고 세 가지 방법으로 내용을 비교한다. 앞 문제의 메서드 분리를 문자열 처리에 적용한다. 자세한 요구사항과 모든 공개 입출력 예는 [문제 설명](problem.html)에 있다.

## 구현하기

`src/main/java/StringCompare.java`는 Java 26 **compact source file**이다. 바깥 클래스 선언과 생성자 없이 `void main()`과 도우미 메서드를 작성한다. 제공된 파일명과 메서드 이름을 유지하고 TODO를 구현한다. 학생 구현 부분은 비워 두었으며 preview 옵션은 필요 없다.

IO.readln()은 한 줄을 읽고 IO.println은 한 줄을 출력한다. String의 equals, equalsIgnoreCase, toLowerCase와 참조 비교 연산자 ==의 차이를 구별하자. 입력 안내 문구는 출력하지 않는다.

| 메서드 | 역할 |
|---|---|
| `void main()` | IO.readln()으로 두 줄을 읽고 아래 세 메서드를 순서대로 호출한다. |
| `void compareStrings(String s1, String s2)` | 대소문자를 구분하여 내용이 같은지 비교한 결과를 출력한다. |
| `void compareIgnoreCase(String s1, String s2)` | 대소문자를 무시하여 내용이 같은지 비교한 결과를 출력한다. |
| `void convertAndCompare(String s1, String s2)` | 두 번째 문자열만 소문자로 변환한 뒤 첫 번째 문자열과 대소문자를 구분하여 비교하고 결과를 출력한다. |

**입력:** 문자열 두 개가 각각 한 줄로 주어진다. 문자열 안의 공백도 내용이므로 그대로 보존한다.

**출력:** [equals]: 결과. / [equalsIgnoreCase]: 결과. / [toLowerCase]: 결과.를 각각 한 줄로 출력한다. 결과는 소문자 true 또는 false이며 끝의 마침표를 유지한다.

## 해결 확인 및 제출

이 프로젝트 폴더에서 Java 26으로 실행한다. 아래는 macOS·Linux 명령이다. Windows PowerShell에서는 `./gradlew` 대신 `.\gradlew.bat`를 사용하고, 입력 리다이렉션 없이 `run`을 실행한 뒤 예제 입력을 붙여 넣는다. 설치와 실행 대상 선택은 [워크스페이스 안내](../../../README.md)를 참고한다.

```bash
./gradlew classes
./gradlew test
./gradlew run < examples/sample.in
```

시작 코드는 컴파일되지만 미구현 상태이므로 테스트는 실패한다. 공개 테스트는 JDK 런처로 프로그램을 별도 프로세스에서 실행해 입출력을 확인한다. 공개 예시 두 개, 같은 내용, 서로 다른 내용, 두 번째 문자열만 변환하는 조건, 공백 보존을 확인한다. 구현 후 모든 테스트를 통과시키고 `examples/sample.out`과 출력이 일치하는지 확인한다. 공개 테스트 통과가 비공개 채점 전체 통과를 보장하지는 않는다.

제출 파일은 **`src/main/java/StringCompare.java`** 하나이며 제출 이름은 **`StringCompare.java`**다. 패키지 선언을 추가하지 않는다. 예상, 첫 시도, 오류 원인과 확인 과정을 [NOTES.md](NOTES.md)에 기록한다.

## 실습 기록과 다음 단계

다음 실습: [0203 날짜·시간](../lab-0203-date-time/README.md).

[Moodle 문제와 제출](https://practice.leafmill.com/mod/vpl/view.php?id=126)
