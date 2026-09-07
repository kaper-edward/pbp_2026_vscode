# 0203 날짜·시간

시간대와 두 날짜·시간을 읽고 차이, 선후 관계, 뉴욕 시간대 표현을 출력한다. 문자열을 시간 객체로 바꾸어 의미에 맞게 계산한다. 자세한 요구사항과 모든 공개 입출력 예는 [문제 설명](problem.html)에 있다.

## 구현하기

`src/main/java/DateTimePractice.java`는 Java 26 **compact source file**이다. 바깥 클래스 선언과 생성자 없이 `void main()`과 도우미 메서드를 작성한다. 제공된 파일명과 메서드 이름을 유지하고 TODO를 구현한다. 학생 구현 부분은 비워 두었으며 preview 옵션은 필요 없다.

필요한 java.time 클래스를 import하여 사용한다. 날짜의 전체 일수와 Period의 남은 일수는 다를 수 있다. 시간대 변환은 현지 시각 숫자가 아닌 실제 시점을 보존해야 한다. 역순·동일 시점 입력이나 DST 전환 구간의 차이 출력은 이번 확인 범위에 포함하지 않는다.

| 메서드 | 역할 |
|---|---|
| `void main()` | IO.readln()으로 세 줄을 읽고 아래 메서드로 결과를 구해 IO.println으로 출력한다. |
| `ZonedDateTime getZonedDateTime(String zone, String dateTimeStr)` | 날짜·시간 문자열을 입력 시간대의 ZonedDateTime으로 반환한다. |
| `void calculateDifference(ZonedDateTime zdt1, ZonedDateTime zdt2)` | 전체 날짜 차이와 나머지 시·분·초를 예시 형식으로 출력한다. |
| `void compareTimes(ZonedDateTime zdt1, ZonedDateTime zdt2)` | 더 미래인 날짜·시간을 Later time: 형식으로 출력한다. |
| `ZonedDateTime convertToNewYork(ZonedDateTime zdt)` | 같은 시점을 America/New_York 시간대로 변환하여 반환한다. |
| `String formatDateTime(ZonedDateTime zdt)` | yyyy-MM-dd HH:mm:ss z 형식으로 반환한다. 시간대 표기는 여름 EDT, 겨울 EST가 되도록 영문 로케일을 사용한다. |

**입력:** 시간대 이름, 첫 번째 날짜·시간, 두 번째 날짜·시간의 세 줄이다. 날짜·시간은 ISO 형식이며 초는 생략할 수 있다. 확인 입력은 두 번째 시점이 더 미래이며, 두 입력 사이에 입력 시간대의 UTC 오프셋 변화가 없다.

**출력:** 아래 예시의 다섯 줄 형식을 유지한다. 날짜 차이는 두 현지 날짜 사이의 전체 일수, 시간 차이는 경과 시간에서 완전한 24시간 단위를 제외한 시·분·초이다. Later time에는 더 미래인 시점의 LocalDateTime 표현을 사용한다.

## 해결 확인 및 제출

이 프로젝트 폴더에서 Java 26으로 실행한다. 아래는 macOS·Linux 명령이다. Windows PowerShell에서는 `./gradlew` 대신 `.\gradlew.bat`를 사용하고, 입력 리다이렉션 없이 `run`을 실행한 뒤 예제 입력을 붙여 넣는다. 설치와 실행 대상 선택은 [워크스페이스 안내](../../../README.md)를 참고한다.

```bash
./gradlew classes
./gradlew test
./gradlew run < examples/sample.in
```

시작 코드는 컴파일되지만 미구현 상태이므로 테스트는 실패한다. 공개 테스트는 JDK 런처로 프로그램을 별도 프로세스에서 실행해 입출력을 확인한다. 공개 예시 전체 출력, 겨울 EST, 초 단위 입력, UTC와 뉴욕 입력 시간대, 완전한 일수의 나머지 시간이 0인 경우를 확인한다. 구현 후 모든 테스트를 통과시키고 `examples/sample.out`과 출력이 일치하는지 확인한다. 공개 테스트 통과가 비공개 채점 전체 통과를 보장하지는 않는다.

제출 파일은 **`src/main/java/DateTimePractice.java`** 하나이며 제출 이름은 **`DateTimePractice.java`**다. 패키지 선언을 추가하지 않는다. 예상, 첫 시도, 오류 원인과 확인 과정을 [NOTES.md](NOTES.md)에 기록한다.

## 실습 기록과 다음 단계

세 실습에서 사용한 입력·계산·출력의 분리 방법과 테스트로 발견한 오류를 NOTES.md에 정리한다.

[Moodle 문제와 제출](https://practice.leafmill.com/mod/vpl/view.php?id=129)
