import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCompareTest {
    @Test
    void firstPublicExample() throws Exception {
        assertEquals("[equals]: false.\n[equalsIgnoreCase]: true.\n[toLowerCase]: true.\n",
                ProgramRunner.run("java is easy\njAvA is eAsy\n"));
    }

    @Test
    void secondPublicExample() throws Exception {
        assertEquals("[equals]: false.\n[equalsIgnoreCase]: true.\n[toLowerCase]: true.\n",
                ProgramRunner.run("hello world\nHELLO WORLD\n"));
    }

    @Test
    void equalContent() throws Exception {
        assertEquals("[equals]: true.\n[equalsIgnoreCase]: true.\n[toLowerCase]: true.\n",
                ProgramRunner.run("same text\nsame text\n"));
    }

    @Test
    void differentContent() throws Exception {
        assertEquals("[equals]: false.\n[equalsIgnoreCase]: false.\n[toLowerCase]: false.\n",
                ProgramRunner.run("Java\nPython\n"));
    }

    @Test
    void onlySecondStringLowercased() throws Exception {
        assertEquals("[equals]: true.\n[equalsIgnoreCase]: true.\n[toLowerCase]: false.\n",
                ProgramRunner.run("HELLO\nHELLO\n"));
    }

    @Test
    void preservesSpaces() throws Exception {
        assertEquals("[equals]: false.\n[equalsIgnoreCase]: false.\n[toLowerCase]: false.\n",
                ProgramRunner.run("hello world\nhelloworld\n"));
    }

}
