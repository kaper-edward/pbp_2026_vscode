# 플랫폼기반프로그래밍 — Java 26 실습

0201 배열의 합, 0202 문자열 비교, 0203 날짜·시간을 VS Code에서 개발하는 실습 저장소입니다. 문제 설명·제공 코드·공개 예제·테스트가 준비되어 있으며, `src/main/java`의 TODO는 학생이 구현합니다.

각 실습은 독립된 Gradle 프로젝트입니다. 로컬 컴파일·실행·테스트는 Moodle 로그인 없이 사용할 수 있고, 수강 계정으로 연결하면 VS Code에서 Moodle에 제출할 수 있습니다.

> **실습환경을 처음 구성한다면 [INSTALL.md](INSTALL.md)를 먼저 읽으세요.** OS별 JDK·PATH 설정, VS Code 확장 설치, 최초 빌드, Moodle 연결과 문제 해결을 순서대로 안내합니다. **에이전트는 실습환경 구성 요청을 받으면 이 문서를 참조하고, 실제 확인 결과와 남은 사용자 작업을 보고하세요.**

에이전트에게는 다음처럼 요청할 수 있습니다.

```text
INSTALL.md를 읽고 이 저장소의 Java 26 실습환경을 구성해 주세요.
기존 설치와 작성한 코드를 보존하고, 컴파일 결과와 제가 직접 해야 할 작업을 알려 주세요.
```

## 1. 준비

다음 프로그램을 설치합니다.

- [Git](https://git-scm.com/downloads)
- [Visual Studio Code](https://code.visualstudio.com/download)
- JDK 26
- VS Code 확장 **Extension Pack for Java**(Microsoft)

**Gradle for Java**는 작업 탐색 UI를 위한 권장 확장입니다. Moodle 명령을 사용하려면 동봉한 **Moodle VPL Practice 0.7.2 VSIX**를 별도로 설치합니다. Git clone이나 추천 확장 목록만으로 Moodle 확장이 자동 설치되지는 않습니다. Gradle은 동봉한 Wrapper를 사용하므로 전역 Gradle·Maven·Node.js·npm 설치는 필요하지 않습니다.

터미널에서 다음 명령을 실행하고 `java`와 `javac`가 모두 버전 26인지 확인합니다.

```text
git --version
java -version
javac -version
```

Windows에서는 환경 변수 `JAVA_HOME`을 본인 컴퓨터에 설치한 JDK 26 폴더로 지정하고, 사용자 `Path`에 `%JAVA_HOME%\bin`을 추가합니다. `JAVA_HOME`은 `bin`의 상위 JDK 폴더입니다. 환경 변수를 변경했다면 터미널과 VS Code를 완전히 닫았다가 다시 엽니다. 저장소는 Windows 로컬 드라이브에 clone합니다. 네트워크 공유의 UNC 경로는 실행 위치로 지원하지 않습니다.

명령 팔레트의 **Java: Configure Java Runtime**에서도 프로젝트 JDK를 확인합니다. 각 `build.gradle`이 Java 26을 지정하고, Gradle Wrapper가 Gradle 9.6.1을 사용합니다. 최초 실행에는 Gradle·JUnit 다운로드를 위한 인터넷 연결이 필요합니다.

사용자가 직접 처리할 수 있는 단계는 프로그램 설치 권한 확인, 작업을 저장한 뒤 VS Code 재시작, Workspace Trust 결정, 본인 수강 계정의 브라우저 로그인과 **Connect to VS Code**입니다. 구체적인 메뉴와 설치 완료 기준은 [INSTALL.md](INSTALL.md)에 있습니다.

## 2. Clone하고 워크스페이스 열기

Windows PowerShell, macOS 또는 Linux 터미널에서 실행합니다.

```text
git clone https://github.com/kaper-edward/pbp_2026_vscode.git
cd pbp_2026_vscode
code practice/week-02/lab-0201-sum-of-array
```

`code` 명령을 사용할 수 없으면 VS Code의 **File → Open Folder...**에서 `practice/week-02/lab-0201-sum-of-array`를 엽니다. 여러 실습을 함께 보려면 **File → Open Workspace from File...**에서 `pbp_2026.code-workspace`를 선택할 수 있습니다. 이 경우 Java 프로젝트 3개를 가져옵니다. 저장소와 실행할 코드를 확인한 뒤 Workspace Trust 안내를 처리합니다. Java 프로젝트를 가져오는 작업이 끝날 때까지 기다립니다.

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

동봉한 **Moodle VPL Practice 0.7.2**을 설치하면 VS Code에서 현재 실습 다운로드·공개 테스트·Moodle 원격 실행·제출·채점을 진행할 수 있습니다. 아래 절차는 VS Code와 브라우저를 같은 컴퓨터에서 사용하는 데스크톱 환경 기준입니다.

### 확장 설치: 처음 한 번

1. VS Code에서 **F1**을 누르고 `Install from VSIX`를 입력합니다.
2. **Extensions: Install from VSIX...**를 선택합니다. 메뉴가 번역되어 검색되지 않으면 왼쪽 **Extensions** 아이콘 → **…** → **Install from VSIX...**를 선택합니다.
3. 파일 선택 창에서 이 저장소의 [`tools/moodle-vpl-practice-0.7.2.vsix`](tools/moodle-vpl-practice-0.7.2.vsix)를 선택합니다.
4. 설치가 끝나면 F1 → **Developer: Reload Window**를 실행합니다. F1에서 `Moodle`을 검색하여 아래 명령이 나타나는지 확인합니다. Extensions 화면에서 **Moodle VPL Practice** 버전이 **0.7.2**인지 확인할 수 있습니다.

터미널을 선호하면 저장소 루트에서 `code --install-extension tools/moodle-vpl-practice-0.7.2.vsix --force`로 설치한 뒤 창을 다시 로드해도 됩니다.

학생이 주로 사용하는 명령은 **Open Current Practice, Run Public Tests, Submit and Run on Moodle, Submit and Grade, Login, Logout**입니다. **Open Current Practice**는 서버의 현재 문제를 확인해 내려받고 해당 폴더를 새 VS Code 창에서 엽니다. 문제 설명은 Explorer의 **Moodle VPL Practices**에서 실습 항목을 클릭하면 열립니다. 이전 버전 사용자는 새 VSIX 설치 후 창을 다시 로드해야 합니다.

### 구현 → 테스트 → 제출·채점

1. F1 → **Moodle VPL: Login**을 실행합니다. 열린 브라우저에서 본인 수강 계정으로 로그인하고 **Connect to VS Code**를 누릅니다. 키를 복사하거나 입력할 필요가 없습니다. Login을 다시 실행하면 이전 로그인 시도는 취소되고 새 연결만 적용됩니다.
2. F1 → **Moodle VPL: Open Current Practice**에서 문제를 선택합니다. 현재 문제가 내려받아지고 해당 폴더가 새 VS Code 창에서 열립니다. `src/main/java`의 TODO를 구현한 뒤 저장합니다. 이 저장소의 0201·0202·0203은 이미 Moodle 활동에 연결되어 있습니다.
3. F1 → **Moodle VPL: Run Public Tests**로 현재 파일의 프로젝트를 테스트합니다. 테스트는 매번 실행하며, 통과하면 PASSED, 출력 불일치로 실패하면 기대값과 실제 출력을 터미널에 표시합니다. 시작 코드는 미완성이므로 실패하는 것이 정상입니다.
4. 서버에서 입력하며 실행하려면 F1 → **Moodle VPL: Submit and Run on Moodle**을 선택합니다. 제출 확인 후 Moodle VPL을 거쳐 실행 서버에 연결되며 VS Code 터미널에 입력합니다. 이 명령은 코드를 제출하지만 채점하지 않습니다.
5. 채점받으려면 F1 → **Moodle VPL: Submit and Grade**를 선택하고 계정·문제·제출 파일을 확인합니다. 제출 검증 후 서버 채점까지 이어지며 결과는 Moodle VPL 출력 창에 표시됩니다. 실습 항목 우클릭 → **Open in Moodle**로 웹 제출 내역도 확인할 수 있습니다.

연결되지 않은 기존 실습 폴더는 제출 과정에서 문제를 선택하여 연결합니다. 별도로 연결하려면 실습 창 상단 **… → Connect Current Folder**를 사용합니다. 작성한 코드를 다른 폴더로 복사할 필요가 없습니다. 공개 테스트 통과만으로 제출되지는 않으며, 최종 결과는 서버 채점으로 확인합니다. 웹 편집기와 VS Code에서 동시에 제출하는 것은 피합니다.

### 새 문제와 기존 문제 변경

사이트 기본값은 `https://practice.leafmill.com`, 강좌 ID는 `4`입니다. F1 → **Moodle VPL: Open Current Practice**에서 추가로 공개된 문제를 선택합니다. 처음에는 실습 보관 폴더를 선택하며, 현재 문제를 내려받고 해당 폴더를 새 VS Code 창에서 엽니다. 교수가 외부 실습으로 등록한 문제 중 현재 계정으로 접근 가능한 문제만 표시됩니다. 이 저장소에 포함된 0201·0202·0203은 다시 다운로드할 필요가 없습니다.

실습 창 상단 새로고침 버튼(**Check for Updates**)은 새 문제와 기존 문제 변경을 수동으로 확인합니다. 자동 주기 알림은 없습니다. 문제가 변경되면 기존 폴더 전체를 같은 주차의 `.moodle-vpl-backups`로 옮기고 현재 문제를 새로 만듭니다. 시작 코드가 같으면 작성한 제출 소스를 현재 폴더에 유지하고, 시작 코드가 바뀌면 새 시작 코드를 사용합니다.

Java 파일이 `package edu.pnu.pbp;`처럼 패키지(package)를 선언하면 0.7.2부터 `src/main/java/edu/pnu/pbp/`처럼 패키지 이름과 같은 폴더에 받습니다. 제출할 때는 Moodle에 파일 이름만 보내므로 폴더 위치를 옮길 필요가 없습니다.

학생이 직접 기존 폴더를 삭제하거나 별도로 복사할 필요는 없습니다. **Open Current Practice**, 문제 설명 열기, 제출은 서버의 현재 문제를 확인합니다. 제출 직전에 변경을 발견하면 현재 문제를 먼저 만들고 제출을 중단하므로, 변경된 문제와 코드를 확인한 뒤 다시 제출합니다.

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
| 연결 토큰 만료 | **Moodle VPL: Login**에서 브라우저로 다시 연결 |
| 제출 계정 또는 버전 충돌 | 본인 계정과 Moodle의 현재 제출 확인 |

빌드 결과와 개인 제출 상태는 Git에서 제외됩니다. 토큰과 로그인 정보는 저장소에 넣지 않습니다. 과제 제출은 Moodle에서 수행하며 본인이 작성한 답안을 공개 저장소에 올리는 것은 수업의 제출·공유 규칙을 따릅니다.

[VS Code Java 프로젝트 관리](https://code.visualstudio.com/docs/java/java-project) · [제3자 구성 요소](THIRD_PARTY_NOTICES.md)
