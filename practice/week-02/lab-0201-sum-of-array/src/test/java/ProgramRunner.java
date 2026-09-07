import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

final class ProgramRunner {
    static String run(String input) throws Exception {
        Path stdout = Files.createTempFile("practice-stdout-", ".txt");
        Path stderr = Files.createTempFile("practice-stderr-", ".txt");
        Process process = null;
        try {
            process = new ProcessBuilder(
                    Path.of(System.getProperty("java.home"), "bin", "java").toString(),
                    "-Duser.language=en", "-Duser.country=US", "-Dfile.encoding=UTF-8",
                    "-cp", System.getProperty("practice.classpath"),
                    System.getProperty("practice.mainClass"))
                    .redirectOutput(stdout.toFile()).redirectError(stderr.toFile()).start();
            try (var stdin = process.getOutputStream()) {
                stdin.write(input.getBytes(StandardCharsets.UTF_8));
            }
            assertTrue(process.waitFor(5, TimeUnit.SECONDS), "프로그램이 5초 안에 종료되어야 합니다.");
            assertEquals(0, process.exitValue(), () -> read(stderr));
            return Files.readString(stdout, StandardCharsets.UTF_8).replace("\r\n", "\n");
        } finally {
            if (process != null && process.isAlive()) {
                process.destroyForcibly();
                process.waitFor();
            }
            Files.deleteIfExists(stdout);
            Files.deleteIfExists(stderr);
        }
    }

    private static String read(Path file) {
        try {
            return Files.readString(file, StandardCharsets.UTF_8);
        } catch (java.io.IOException exception) {
            return exception.toString();
        }
    }
}
