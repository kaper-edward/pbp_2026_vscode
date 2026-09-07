import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DateTimePracticeTest {
    @Test
    void publicExample() throws Exception {
        assertEquals("Day difference: 2 days\nTime difference: 5 hours 15 minutes 0 seconds\nLater time: 2025-09-06T15:45\nNew York Time 1: 2025-09-03 21:30:00 EDT\nNew York Time 2: 2025-09-06 02:45:00 EDT\n",
                ProgramRunner.run("Asia/Seoul\n2025-09-04T10:30\n2025-09-06T15:45\n"));
    }

    @Test
    void winterUsesEst() throws Exception {
        assertEquals("Day difference: 0 days\nTime difference: 1 hours 15 minutes 0 seconds\nLater time: 2025-01-10T11:45\nNew York Time 1: 2025-01-09 20:30:00 EST\nNew York Time 2: 2025-01-09 21:45:00 EST\n",
                ProgramRunner.run("Asia/Seoul\n2025-01-10T10:30\n2025-01-10T11:45\n"));
    }

    @Test
    void secondsArePreserved() throws Exception {
        assertEquals("Day difference: 0 days\nTime difference: 0 hours 0 minutes 45 seconds\nLater time: 2025-09-04T10:30:55\nNew York Time 1: 2025-09-03 21:30:10 EDT\nNew York Time 2: 2025-09-03 21:30:55 EDT\n",
                ProgramRunner.run("Asia/Seoul\n2025-09-04T10:30:10\n2025-09-04T10:30:55\n"));
    }

    @Test
    void utcInputZone() throws Exception {
        assertEquals("Day difference: 0 days\nTime difference: 2 hours 0 minutes 0 seconds\nLater time: 2025-09-04T12:30\nNew York Time 1: 2025-09-04 06:30:00 EDT\nNew York Time 2: 2025-09-04 08:30:00 EDT\n",
                ProgramRunner.run("UTC\n2025-09-04T10:30\n2025-09-04T12:30\n"));
    }

    @Test
    void newYorkInputZone() throws Exception {
        assertEquals("Day difference: 0 days\nTime difference: 0 hours 30 minutes 0 seconds\nLater time: 2025-09-04T11:00\nNew York Time 1: 2025-09-04 10:30:00 EDT\nNew York Time 2: 2025-09-04 11:00:00 EDT\n",
                ProgramRunner.run("America/New_York\n2025-09-04T10:30\n2025-09-04T11:00\n"));
    }

    @Test
    void wholeDaysHaveZeroRemainder() throws Exception {
        assertEquals("Day difference: 2 days\nTime difference: 0 hours 0 minutes 0 seconds\nLater time: 2025-09-06T10:30\nNew York Time 1: 2025-09-03 21:30:00 EDT\nNew York Time 2: 2025-09-05 21:30:00 EDT\n",
                ProgramRunner.run("Asia/Seoul\n2025-09-04T10:30\n2025-09-06T10:30\n"));
    }

}
