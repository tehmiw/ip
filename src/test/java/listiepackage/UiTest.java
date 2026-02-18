package listiepackage;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {

    @Test
    public void getTaskDeletedTest() {
        ToDo toDo = new ToDo("read book");
        Ui ui = new Ui();
        String capturedOutput = ui.getTaskDeleted(toDo, 1);
        assertEquals("Noted. I've removed this task:\n  " + toDo.getLine()
                + "\nNow you have 1 tasks in the list.", capturedOutput);
    }

    @Test
    public void getTaskAddedTest() {
        ToDo toDo = new ToDo("read book");
        Ui ui = new Ui();
        String capturedOutput = ui.getTaskAdded(toDo, 1);
        assertEquals("Got it. I've added this task:\n  " + toDo.getLine() +
                "\nNow you have 1 tasks in the list.", capturedOutput);
    }

}