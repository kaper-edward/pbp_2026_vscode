import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ArraySumCalculatorTest {
    @Test
    void firstPublicExample() throws Exception {
        assertEquals("Sum: 150\n",
                ProgramRunner.run("5\n10 20 30 40 50\n"));
    }

    @Test
    void secondPublicExample() throws Exception {
        assertEquals("Sum: 6\n",
                ProgramRunner.run("3\n1 2 3\n"));
    }

    @Test
    void minimumSize() throws Exception {
        assertEquals("Sum: 7\n",
                ProgramRunner.run("1\n7\n"));
    }

    @Test
    void negativeAndZero() throws Exception {
        assertEquals("Sum: -9\n",
                ProgramRunner.run("4\n-8 0 2 -3\n"));
    }

    @Test
    void zeroSum() throws Exception {
        assertEquals("Sum: 0\n",
                ProgramRunner.run("3\n-4 0 4\n"));
    }

    @Test
    void tokensAcrossLines() throws Exception {
        assertEquals("Sum: 10\n",
                ProgramRunner.run("4\n1\n2 3\n4\n"));
    }

}
