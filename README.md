# 플랫폼기반프로그래밍 — Java 26 실습

0201 배열의 합, 0202 문자열 비교, 0203 날짜·시간을 VS Code에서 개발하는 실습 저장소입니다. 문제 설명·제공 코드·공개 예제·테스트가 준비되어 있으며, `src/main/java`의 TODO는 학생이 구현합니다.

각 실습은 독립된 Gradle 프로젝트입니다. 로컬 컴파일·실행·테스트는 Moodle 로그인 없이 사용할 수 있고, 수강 계정으로 연결하면 VS Code에서 Moodle에 제출할 수 있습니다.

## 1. 준비

다음 프로그램을 설치합니다.

- [Git](https://git-scm.com/downloads)
- [Visual Studio Code](https://code.visualstudio.com/download)
- JDK 26
- VS Code 확장 **Extension Pack for Java**(Microsoft)

터미널에서 다음 명령을 실행하고 `java`와 `javac`가 모두 버전 26인지 확인합니다.

```text
git --version
java -version
javac -version
```

Windows에서는 환경 변수 `JAVA_HOME`을 본인 컴퓨터에 설치한 JDK 26 폴더로 지정하고, 사용자 `Path`에 `%JAVA_HOME%\bin`을 추가합니다. `JAVA_HOME`은 `bin`의 상위 JDK 폴더입니다. 환경 변수를 변경했다면 터미널과 VS Code를 완전히 닫았다가 다시 엽니다. 저장소는 Windows 로컬 드라이브에 clone합니다. 네트워크 공유의 UNC 경로는 실행 위치로 지원하지 않습니다.

명령 팔레트의 **Java: Configure Java Runtime**에서도 프로젝트 JDK를 확인합니다. 각 `build.gradle`이 Java 26을 지정하고, Gradle Wrapper가 Gradle 9.6.1을 사용합니다. 최초 실행에는 Gradle·JUnit 다운로드를 위한 인터넷 연결이 필요합니다.

## 2. Clone하고 워크스페이스 열기

Windows PowerShell, macOS 또는 Linux 터미널에서 실행합니다.

```text
git clone https://github.com/kaper-edward/pbp_2026_vscode.git
cd pbp_2026_vscode
code pbp_2026.code-workspace
```

`code` 명령을 사용할 수 없으면 VS Code의 **File → Open Workspace from File...**에서 `pbp_2026.code-workspace`를 엽니다. 저장소와 실행할 코드를 확인한 뒤 Workspace Trust 안내를 처리합니다. Java 프로젝트를 가져오는 작업이 끝날 때까지 기다립니다.

| 실습 | 주제 | 프로젝트 |
| --- | --- | --- |
| 0201 | 배열과 반복문으로 합계 계산 | [배열의 합](practice/week-02/lab-0201-sum-of-array/README.md) |
| 0202 | 문자열 내용 비교와 대소문자 변환 | [문자열 비교](practice/week-02/lab-0202-string/README.md) |
| 0203 | 날짜·시간 차이와 시간대 변환 | [날짜·시간](practice/week-02/lab-0203-date-time/README.md) |

한 문제만 열고 싶으면 해당 `lab-*` 폴더를 **File → Open Folder...**로 엽니다. 모든 프로젝트 경로는 저장소나 현재 실습 폴더를 기준으로 해석합니다. 저장소 위치를 바꿔도 설정 파일에 PC 경로를 적을 필요가 없습니다.

## 3. Windows에서 첫 실행

새 PowerShell 터미널을 열고 0201 프로젝트 폴더로 이동합니다. 아래 `cd`는 저장소 루트에서 시작하는 명령입니다. VS Code 터미널이 이미 해당 실습 폴더에 있다면 바로 Gradle 명령을 실행합니다.

```powershell
cd practice\week-02\lab-0201-sum-of-array
.\gradlew.bat --console=plain testClasses
.\gradlew.bat --quiet run
```

`testClasses`는 시작 코드와 공개 테스트를 컴파일합니다. 시작 코드의 `main()`은 미완성이므로 처음 실행할 때 출력 없이 종료될 수 있습니다. 문제를 읽고 TODO를 구현한 뒤 다시 실행하고, `examples/sample.in`의 내용을 터미널에 입력합니다.

공개 테스트는 다음 명령으로 실행합니다.

```powershell
.\gradlew.bat --console=plain test
```

**시작 코드는 컴파일되지만 공개 테스트는 실패하는 것이 정상입니다.** TODO를 구현하면 출력과 테스트 결과로 정답 여부를 확인할 수 있습니다. 테스트 실패를 없애기 위해 기대값을 바꾸거나 테스트를 끄지 않습니다. 결과 보고서는 각 프로젝트의 `build/reports/tests/test/index.html`에 있습니다.

macOS·Linux에서는 같은 프로젝트 폴더에서 아래 명령을 사용합니다.

```bash
./gradlew --console=plain testClasses
./gradlew --quiet run < examples/sample.in
./gradlew --console=plain test
```

Windows PowerShell의 대화형 실행은 위 Windows 명령을 사용합니다. `<` 입력 리다이렉션을 사용하는 Bash 명령과 구분합니다.

## 4. VS Code에서 실행할 실습 선택

**Run and Debug**의 실행 구성 목록에서 대상 실습을 선택합니다. 멀티 프로젝트 워크스페이스에서는 구성 이름과 함께 표시되는 프로젝트 이름으로 0201·0202·0203을 구분합니다.

- **F5**: 선택한 실습 디버깅
- **Ctrl+F5**: 디버깅 없이 실행
- 명령 팔레트의 **Debug: Select and Start Debugging**: 실행 구성을 선택하여 시작
- **Tasks: Run Task**: 컴파일·공개 테스트 작업 선택

프로그램 입력은 통합 터미널에 제공합니다. 다른 실습을 실행하려면 실행 구성을 바꿉니다. 터미널에서 Gradle을 실행할 때의 대상은 터미널의 현재 프로젝트 폴더입니다.

## 5. Moodle 연결과 제출

동봉한 **Moodle VPL Practice 0.2.2**는 VS Code에서 문제 보기·로컬 실행·공개 테스트·Moodle 제출을 제공합니다. 저장소 루트의 `tools/moodle-vpl-practice-0.2.2.vsix`를 명령 팔레트의 **Extensions: Install from VSIX...**로 설치하고 창을 다시 로드합니다.

Windows PowerShell에서는 저장소 루트에서 다음 명령으로 설치할 수도 있습니다.

```powershell
code --install-extension .\tools\moodle-vpl-practice-0.2.2.vsix
```

1. **Moodle VPL: 로그인**을 실행합니다.
2. 외부 브라우저의 [VS Code 연결 화면](https://practice.leafmill.com/local/vplpractice/connect.php)에서 본인의 수강 계정으로 로그인합니다.
3. **연결 토큰 발급 → 연결 토큰 복사**를 누르고 VS Code 입력창에 붙여 넣습니다. 토큰은 7일 동안 유효하며 본인만 사용합니다.
4. 준비된 실습의 Java 파일을 열어 구현하고 저장합니다. **Moodle VPL: 현재 실습 제출**에서 계정·문제·파일을 확인하고 제출합니다.
5. **Moodle VPL: 제출한 코드 채점**으로 서버에 마지막으로 저장된 코드를 채점합니다. 수정했다면 먼저 다시 제출합니다.

사이트는 `https://practice.leafmill.com`, 강좌 ID는 `4`로 설정되어 있습니다. 저장소의 세 실습은 이미 해당 활동에 연결되어 있습니다. 추가로 공개된 실습은 **Moodle VPL: 실습 다운로드**에서 선택할 수 있습니다.

**Moodle VPL: Moodle에서 열기**로 웹 제출 내역을 확인합니다. 웹 편집기와 VS Code에서 동시에 제출하는 것은 피합니다. 문제 갱신 알림을 받으면 **Moodle VPL: 원격 문제 갱신**을 실행하고 충돌 안내를 확인합니다. 공개 테스트는 일부 동작을 확인하며, 최종 결과는 서버 채점으로 확인합니다.

## 6. 작업 파일과 문제 해결

| 위치·증상 | 용도 또는 확인 방법 |
| --- | --- |
| `problem.html` | 문제 요구사항과 입출력 예 |
| `src/main/java` | 제공 코드와 학생 구현 |
| `src/test/java`, `examples` | 공개 테스트와 예제 |
| `NOTES.md` | 예상·시도·오류·수정 결과의 개인 실습 기록 |
| JDK를 찾을 수 없다는 오류 | `JAVA_HOME`, `java -version`, **Java: Configure Java Runtime** 확인 |
| Gradle 다운로드 실패 | 인터넷 연결을 확인하고 같은 명령 재실행 |
| 클래스나 실행 구성을 찾지 못함 | Java 프로젝트 가져오기가 완료되었는지, 대상 실습이 맞는지 확인 |
| 연결 토큰 만료 | **Moodle VPL: 로그인**에서 새 토큰으로 연결 |
| 제출 계정 또는 버전 충돌 | 본인 계정과 Moodle의 현재 제출 확인 |

빌드 결과와 개인 제출 상태는 Git에서 제외됩니다. 토큰과 로그인 정보는 저장소에 넣지 않습니다. 과제 제출은 Moodle에서 수행하며 본인이 작성한 답안을 공개 저장소에 올리는 것은 수업의 제출·공유 규칙을 따릅니다.

[VS Code Java 프로젝트 관리](https://code.visualstudio.com/docs/java/java-project) · [제3자 구성 요소](THIRD_PARTY_NOTICES.md)
