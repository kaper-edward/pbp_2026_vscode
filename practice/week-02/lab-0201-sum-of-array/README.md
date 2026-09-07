# 0201 배열의 합

정수 배열을 입력받고 합을 출력한다. 배열과 반복문을 활용하고 입력·계산·출력을 메서드로 나눈다. 자세한 요구사항과 모든 공개 입출력 예는 [문제 설명](problem.html)에 있다.

## 구현하기

`src/main/java/ArraySumCalculator.java`는 Java 26 **compact source file**이다. 바깥 클래스 선언과 생성자 없이 `void main()`과 도우미 메서드를 작성한다. 제공된 파일명과 메서드 이름을 유지하고 TODO를 구현한다. 학생 구현 부분은 비워 두었으며 preview 옵션은 필요 없다.

Scanner scanner와 int[] numbers 필드를 제공한다. 숫자 토큰 입력에는 Scanner를 사용하고, 출력에는 IO.println을 사용해 보자.

| 메서드 | 역할 |
|---|---|
| `void main()` | 입력 → 결과 출력 순서로 메서드를 호출한다. |
| `void inputNumbers()` | 제공된 Scanner로 크기와 원소를 읽어 numbers 배열을 초기화한다. |
| `int calculateSum()` | 모든 배열 원소의 합을 반환한다. |
| `void displaySum()` | 계산 결과를 지정된 형식으로 IO.println에 전달하여 출력한다. |

**입력:** 첫 정수는 1 이상의 배열 크기이며 이어서 해당 개수의 정수 원소가 주어진다. 공백과 줄바꿈은 토큰 구분자로 사용한다. 합은 int 범위 안에 있다고 가정한다.

**출력:** Sum: 뒤에 공백 하나와 합계를 출력한다. 입력 안내 문구를 추가하지 않는다.

## 해결 확인 및 제출

이 프로젝트 폴더에서 Java 26으로 실행한다. 아래는 macOS·Linux 명령이다. Windows PowerShell에서는 `./gradlew` 대신 `.\gradlew.bat`를 사용하고, 입력 리다이렉션 없이 `run`을 실행한 뒤 예제 입력을 붙여 넣는다. 설치와 실행 대상 선택은 [워크스페이스 안내](../../../README.md)를 참고한다.

```bash
./gradlew classes
./gradlew test
./gradlew run < examples/sample.in
```

시작 코드는 컴파일되지만 미구현 상태이므로 테스트는 실패한다. 공개 테스트는 JDK 런처로 프로그램을 별도 프로세스에서 실행해 입출력을 확인한다. 공개 예시 두 개, 최소 배열 크기, 음수와 0, 합이 0인 경우, 여러 줄에 나뉜 토큰 입력을 확인한다. 구현 후 모든 테스트를 통과시키고 `examples/sample.out`과 출력이 일치하는지 확인한다. 공개 테스트 통과가 비공개 채점 전체 통과를 보장하지는 않는다.

제출 파일은 **`src/main/java/ArraySumCalculator.java`** 하나이며 제출 이름은 **`ArraySumCalculator.java`**다. 패키지 선언을 추가하지 않는다. 예상, 첫 시도, 오류 원인과 확인 과정을 [NOTES.md](NOTES.md)에 기록한다.

## 실습 기록과 다음 단계

다음 실습: [0202 문자열 비교](../lab-0202-string/README.md).

[Moodle 문제와 제출](https://practice.leafmill.com/mod/vpl/view.php?id=128)
