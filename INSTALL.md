# 실습환경 설치 안내

이 문서는 학생과 실습환경 구성을 돕는 에이전트가 함께 사용하는 설치 절차입니다. 저장소의 시작 코드와 공개 테스트를 보존하면서 **컴파일·실행 가능한 상태**까지 준비합니다. 문제 구현과 Moodle 제출은 설치 이후의 작업입니다.

## 1. 필요한 환경

| 구성 요소 | 필요 시점 | 설치·확인 방법 |
| --- | --- | --- |
| Git | 저장소 복제·갱신 | [Git 다운로드](https://git-scm.com/downloads), `git --version` |
| 데스크톱 VS Code | 편집·디버깅·확장 사용 | [VS Code 다운로드](https://code.visualstudio.com/download). Moodle 확장의 최소 버전은 1.96.0이며 Java 확장도 지원하는 버전을 사용 |
| **JDK 26** | 로컬 컴파일·실행·테스트 | `java -version`, `javac -version` 모두 26. JRE만 설치하거나 JDK 21·25로 대체하지 않음 |
| **Extension Pack for Java** | Java 편집·프로젝트 가져오기·디버깅 | 확장 ID `vscjava.vscode-java-pack` |
| Gradle for Java | Gradle 작업 탐색 UI 사용 시 권장 | 확장 ID `vscjava.vscode-gradle`. 터미널의 Wrapper 실행에는 필요하지 않음 |
| **Moodle VPL Practice 0.7.1** | VS Code의 Moodle 명령 사용 | 저장소의 [VSIX](tools/moodle-vpl-practice-0.7.1.vsix)를 별도 설치 |
| 인터넷 연결 | 최초 의존성 다운로드·Moodle 사용 | GitHub, VS Code Marketplace, Gradle 배포 서버, Maven Central, 수업 Moodle 접속 |
| 본인 수강 계정과 브라우저 | Moodle 로그인·제출·채점 | `https://practice.leafmill.com`의 해당 강좌 접근 권한 |

이 저장소에는 Gradle **9.6.1** Wrapper와 JUnit **6.1.3** 설정이 포함되어 있습니다. Gradle과 Maven을 전역 설치하거나 학생 PC에 Node.js·npm·Python을 설치할 필요는 없습니다. VSIX는 설치 가능한 완성 파일이며 학생이 확장을 빌드하지 않습니다. 터미널에서의 컴파일·실행·공개 테스트에는 Moodle 확장이나 로그인이 필요하지 않습니다.

JDK는 [Oracle의 Java 다운로드](https://www.oracle.com/java/technologies/downloads/#java26) 등 배포자의 공식 경로에서 **26 버전과 본인 OS·CPU 구조**를 선택합니다. Java 확장 설치만으로 수업에 필요한 JDK 26까지 준비되었다고 판단하지 말고 아래 명령으로 확인합니다. VS Code의 Java 지원 구성은 [공식 Java 시작 안내](https://code.visualstudio.com/docs/java/java-tutorial)를 참고합니다.

Moodle 브라우저 연결은 **VS Code와 브라우저가 같은 컴퓨터에서 실행되는 데스크톱 환경**을 기준으로 합니다. 처음 설치할 때는 Windows 로컬 폴더 또는 macOS·Linux 로컬 폴더를 사용합니다. WSL·SSH·Dev Container에서 실행되는 확장 호스트와 로컬 브라우저를 섞는 구성은 이 안내의 검증 대상이 아닙니다. Windows UNC 네트워크 공유 경로는 실행 위치로 지원하지 않습니다.

## 2. JDK와 명령 경로 설정

### Windows PowerShell

1. Git, VS Code, JDK 26을 설치합니다. VS Code 설치 시 PATH에 추가하는 옵션을 사용하면 `code` 명령을 쓸 수 있습니다.
2. Windows의 **환경 변수 편집 → 사용자 변수**에서 `JAVA_HOME`을 설치한 JDK 26 폴더로 지정합니다. 예를 들어 `C:\Program Files\Java\jdk-26`이며 실제 설치 폴더를 확인해야 합니다. 끝에 `\bin`을 붙이지 않습니다.
3. 사용자 `Path`에 `%JAVA_HOME%\bin`을 추가합니다. 기존 Path 전체를 지우거나 덮어쓰지 않습니다.
4. VS Code와 터미널을 완전히 종료하고 다시 엽니다. 실행 중이던 프로세스에는 변경한 환경 변수가 바로 반영되지 않습니다.
5. 새 PowerShell에서 실행합니다.

```powershell
git --version
code --version
$env:JAVA_HOME
Test-Path "$env:JAVA_HOME\bin\javac.exe"
Get-Command java,javac | Select-Object Name,Source
java -version
javac -version
```

`Test-Path`는 `True`, 두 Java 버전은 모두 `26`이어야 합니다. 다른 Java가 먼저 잡히면 `where.exe java`와 `where.exe javac`로 경로 순서를 확인합니다. `JAVA_HOME`만 바꿔도 Path에 남은 다른 Java가 실행될 수 있습니다.

현재 PowerShell에서만 JDK를 지정하여 진단하려면 다음처럼 실행할 수 있습니다. `C:\실제\JDK26경로`를 본인 설치 경로로 바꿉니다. 이 방법은 영구 설정이 아닙니다.

```powershell
$env:JAVA_HOME = 'C:\실제\JDK26경로'
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
java -version
javac -version
```

### macOS·Linux

OS·CPU에 맞는 JDK 26과 Git, VS Code를 설치합니다. macOS의 일반적인 JDK 설치 경로는 아래 명령으로 확인하고 선택합니다.

```bash
/usr/libexec/java_home -V
export JAVA_HOME=$(/usr/libexec/java_home -v 26)
export PATH="$JAVA_HOME/bin:$PATH"
```

Linux에서는 설치한 JDK의 실제 경로를 사용합니다. 아래 `/실제/JDK26경로`는 교체해야 하는 예시입니다.

```bash
export JAVA_HOME='/실제/JDK26경로'
export PATH="$JAVA_HOME/bin:$PATH"
```

사용 중인 셸의 시작 파일(예: `~/.zshrc` 또는 `~/.bashrc`)에 본인에게 맞는 설정을 반영하고 새 터미널에서 `git --version`, `java -version`, `javac -version`을 확인합니다. 다른 JDK를 사용하던 VS Code도 다시 시작합니다. macOS에서 `code`가 없으면 F1 → **Shell Command: Install 'code' command in PATH**를 사용합니다. [VS Code macOS 설치 안내](https://code.visualstudio.com/docs/setup/mac)

## 3. 저장소 복제와 확장 설치

아래 명령은 저장소를 둘 상위 폴더에서 시작합니다. 이미 클론한 폴더가 있다면 `git status --short`로 작업 내용을 먼저 확인하고 그 폴더를 사용합니다. 이름이 같다는 이유로 기존 폴더를 삭제하거나 덮어쓰지 않습니다.

```text
git clone https://github.com/kaper-edward/pbp_2026_vscode.git
cd pbp_2026_vscode
code --install-extension vscjava.vscode-java-pack
code --install-extension vscjava.vscode-gradle
code --install-extension tools/moodle-vpl-practice-0.7.1.vsix --force
```

`code`가 없으면 GUI로 설치할 수 있습니다. Extensions에서 Microsoft의 **Extension Pack for Java**와 **Gradle for Java**를 검색하고 설치합니다. Moodle 확장은 **F1 → Extensions: Install from VSIX...** 또는 **Extensions → … → Install from VSIX...**에서 `tools/moodle-vpl-practice-0.7.1.vsix`를 선택합니다. 저장소의 추천 확장 목록이나 Git clone만으로 Moodle VSIX가 자동 설치되지는 않습니다. [VS Code 확장 설치 안내](https://code.visualstudio.com/docs/configure/extensions/extension-marketplace)

이전 버전 사용자는 새 VSIX를 설치하여 갱신하고 **Developer: Reload Window**를 실행합니다. 기존 실습 폴더와 작성한 코드를 삭제할 필요는 없습니다. 여러 VS Code 프로필을 사용하면 실제 수업에 사용하는 프로필에서 설치했는지 확인합니다.

Extensions 화면에서 `Moodle VPL Practice`가 **0.7.1**인지 확인하거나 아래 명령의 목록에서 `leafmill.moodle-vpl-practice@0.7.1`을 찾습니다.

```text
code --list-extensions --show-versions
```

설치 파일 확인이 필요하면 저장소 루트에서 PowerShell의 `Get-FileHash tools/moodle-vpl-practice-0.7.1.vsix -Algorithm SHA256`을 실행하여 [SHA256SUMS.txt](tools/SHA256SUMS.txt)와 비교합니다. Linux에서는 `(cd tools && sha256sum -c SHA256SUMS.txt)`, macOS에서는 `(cd tools && shasum -a 256 -c SHA256SUMS.txt)`를 사용할 수 있습니다.

## 4. 실습 폴더와 프로젝트 JDK 확인

저장소 루트에서 다음 명령을 실행하거나 **File → Open Folder...**로 같은 폴더를 엽니다.

```text
code practice/week-02/lab-0201-sum-of-array
```

세 실습을 함께 열려면 **File → Open Workspace from File...**에서 `pbp_2026.code-workspace`를 선택합니다. 단일 `.java` 파일만 열지 말고 `build.gradle`이 있는 실습 폴더 또는 제공한 워크스페이스를 엽니다. 저장소 출처와 실행할 코드를 확인한 사용자가 Workspace Trust 여부를 결정합니다. Restricted Mode에서는 Moodle 확장이 활성화되지 않습니다.

Java 프로젝트 가져오기가 끝나면 F1 → **Java: Configure Java Runtime**에서 프로젝트가 JDK 26을 사용하는지 확인합니다. 터미널의 Java, Gradle의 Java, VS Code 프로젝트의 Java가 일치해야 합니다. JDK를 찾지 못하면 사용자 설정의 `java.import.gradle.java.home`을 실제 JDK 26 경로로 지정할 수 있습니다. Gradle의 toolchain 지정은 이미 `build.gradle`에 있으므로 버전을 낮추지 않습니다. PC 고유 절대 경로는 Git에 넣지 않습니다. [VS Code 프로젝트 JDK 설정](https://code.visualstudio.com/docs/java/java-project)

이 저장소의 0201·0202·0203은 이미 Moodle 문제에 연결되어 있습니다. 설치 과정에서 다시 다운로드하거나 `.moodle/project.json`을 바꿀 필요가 없습니다.

## 5. 최초 빌드와 설치 완료 확인

Windows에서는 저장소 루트에서 실행합니다.

```powershell
cd practice\week-02\lab-0201-sum-of-array
.\gradlew.bat --version
.\gradlew.bat --console=plain testClasses
.\gradlew.bat --quiet run
```

macOS·Linux에서는 다음 명령을 사용합니다.

```bash
cd practice/week-02/lab-0201-sum-of-array
./gradlew --version
./gradlew --console=plain testClasses
./gradlew --quiet run < examples/sample.in
```

Gradle 버전은 **9.6.1**, JVM은 **26**인지 확인합니다. 최초 실행은 Gradle과 JUnit을 내려받으므로 시간이 걸릴 수 있습니다. 프로젝트에는 JDK 자동 설치 설정이 없으므로 JDK 26을 먼저 설치해야 합니다. `testClasses`의 `BUILD SUCCESSFUL`은 시작 코드와 공개 테스트의 **컴파일 성공**을 뜻하며 정답 판정이 아닙니다. 나머지 두 `lab-*` 폴더에서도 같은 컴파일 명령을 실행합니다.

시작 코드의 `main()`은 미완성이어서 `run`이 출력 없이 종료될 수 있습니다. 구현 후에는 PowerShell에서 `.\gradlew.bat --console=plain test`, macOS·Linux에서 `./gradlew --console=plain test`로 공개 테스트를 실행합니다. **TODO 상태의 테스트 실패는 설치 실패와 구분합니다.** 설치를 완료하기 위해 답안을 작성하거나 테스트 기대값을 바꾸지 않습니다. Windows PowerShell에서는 Bash의 `< examples/sample.in` 대신 대화형 실행 후 입력을 직접 제공합니다.

VS Code에서도 Java 파일을 열고 **Run and Debug**에서 해당 실습을 선택한 뒤 F5 또는 Ctrl+F5로 실행합니다. F1의 **Moodle VPL: Run Public Tests**로 터미널에 테스트 결과가 나오는지 확인합니다. CLI 빌드만 수행했다면 GUI 실행까지 확인했다고 기록하지 않습니다.

## 6. Moodle 연결: 사용자가 직접 할 작업

로컬 환경이 준비되면 사용자가 F1 → **Moodle VPL: Login**을 실행합니다. 같은 컴퓨터의 브라우저에서 본인 수강 계정으로 로그인하고 **Connect to VS Code**를 누릅니다. 비밀번호·추가 인증·계정 선택은 사용자가 처리합니다. 연결 키를 복사하거나 에이전트에게 비밀번호를 전달하지 않습니다.

기본 사이트는 `https://practice.leafmill.com`, 강좌 ID는 `4`입니다. 다른 강좌를 사용하도록 안내받았다면 VS Code의 `moodleVpl.site`와 `moodleVpl.courseId`를 확인합니다. 로그인은 되지만 문제가 보이지 않으면 수강 등록과 문제 공개·접근 권한을 담당자에게 확인합니다.

학생이 주로 사용하는 Moodle 명령은 **Open Current Practice, Run Public Tests, Submit and Run on Moodle, Submit and Grade, Login, Logout**입니다. **Open Current Practice**는 서버의 현재 문제를 내려받고 해당 폴더를 새 VS Code 창에서 엽니다. 서버 문제가 바뀌면 이전 폴더를 `.moodle-vpl-backups`에 보존하고 현재 문제를 새로 만듭니다. 문제 설명은 Explorer의 **Moodle VPL Practices**에서 실습 항목을 클릭하여 확인합니다.

설치 확인에는 실제 제출·서버 실행·채점이 필요하지 않습니다. **Submit and Run on Moodle**도 서버에 코드를 제출하므로 사용자가 제출하려는 시점에 실행합니다. 구현 이후 절차는 [README의 Moodle 연결과 제출](README.md#5-moodle-연결과-제출)을 참고합니다.

## 7. 문제가 생겼을 때

| 증상 | 확인·조치 |
| --- | --- |
| `code`를 찾지 못함 | VS Code PATH 설정 후 터미널 재시작, 또는 GUI 설치·폴더 열기 사용 |
| `javac`가 없거나 버전이 26이 아님 | JDK 설치 여부, `JAVA_HOME`, 실행 경로 순서 확인 |
| Gradle이 JDK 26을 찾지 못함 | `gradlew --version`의 JVM, JDK 설치 경로, VS Code의 프로젝트 JDK 확인. `build.gradle`의 26을 낮추지 않음 |
| Gradle·JUnit 다운로드 실패 | 네트워크·프록시 설정과 오류에 표시된 다운로드 주소 확인 후 같은 명령 재실행. 인증서 검증을 끄지 않음 |
| macOS·Linux에서 `./gradlew` 권한 오류 | 실습 폴더에서 `chmod +x gradlew` 후 재실행 |
| Java 프로젝트·F5 구성을 찾지 못함 | 실습 폴더 또는 제공한 워크스페이스를 열었는지, Java 확장 설치와 프로젝트 가져오기가 완료되었는지 확인 |
| F1에 Moodle 명령이 없음 | 활성 프로필의 VSIX 설치·사용 여부, Workspace Trust, Reload Window 확인 |
| 이전 명령이나 화면이 계속 표시됨 | 설치 버전 0.7.1 확인 후 Reload Window. 저장소 갱신만으로 설치된 확장은 바뀌지 않음 |
| 로그인 연결이 완료되지 않음 | VS Code와 브라우저가 같은 컴퓨터인지 확인하고 Login을 다시 시작. 회사·학교의 loopback 통신 차단 여부 확인 |
| 토큰 만료·잘못된 계정 | Login 재실행 또는 Logout 후 본인 계정으로 다시 연결 |
| 컴파일 성공 후 공개 테스트 실패 | 미완성 TODO인지 먼저 확인. `build/reports/tests/test/index.html`의 기대값·실제 출력 확인 |

## 8. 에이전트의 작업 범위와 인계

실습환경 구성 요청을 받으면 다음 순서로 진행합니다.

1. 이 문서와 README를 읽고 OS, 셸, 현재 작업 경로, `git status --short`, 설치된 Git·VS Code·JDK·확장 버전을 확인합니다. 기존 설치와 학생 작업을 재사용합니다.
2. 부족한 구성 요소만 설치하고 JDK 26·PATH·프로젝트 가져오기를 설정합니다. 설치 위치는 실제 파일로 확인하며 예시 경로나 다른 PC 경로를 그대로 쓰지 않습니다.
3. VSIX 0.7.1 설치 상태를 확인하고 세 실습의 `testClasses`를 실행합니다. GUI를 사용할 수 있으면 프로젝트 JDK·실행 구성·Moodle 명령도 확인합니다.
4. OS 설치 권한 요청, 기존 작업을 저장한 뒤 VS Code 재시작, 저장소 신뢰 결정, 브라우저 로그인·Connect to VS Code는 사용자 조작이 필요할 수 있습니다. 필요한 작업과 이유를 짧게 안내합니다. 실행 중인 VS Code를 임의로 강제 종료하지 않습니다.
5. 설치 결과를 **버전·컴파일 결과·GUI 확인 여부·Moodle 연결 여부·남은 사용자 작업**으로 보고합니다. 미확인 항목을 완료로 표시하지 않습니다.

설치 작업에서는 학생 소스의 TODO를 구현하거나 공개 테스트·예제를 고치지 않습니다. 로그인 정보와 PC별 경로를 저장소에 커밋하지 않습니다. Moodle 제출·채점은 사용자가 별도로 요청한 경우에 진행합니다.

완료 보고 예시의 형식은 다음과 같습니다. 값은 실제 확인한 결과로 채웁니다.

```text
Git / VS Code / JDK / Moodle 확장: 확인한 버전
0201·0202·0203 testClasses: 각각 성공 또는 오류 요약
VS Code 프로젝트 JDK / F5 / Moodle 명령: 확인 결과 또는 미확인
Moodle 연결: 연결 확인 또는 사용자 로그인 대기
남은 사용자 작업: 구체적인 메뉴와 동작
```
