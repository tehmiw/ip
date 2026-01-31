package listiepackage;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {

    @Test
    public void showTaskAddedTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        ToDo toDo = new ToDo("read book");
        Ui ui = new Ui();
        ui.showTaskAdded(toDo, 1);
        String capturedOutput = outputStream.toString().replaceAll("\r\n", "\n");
        assertEquals("Got it. I've added this task:\n  " + toDo.getLine() +
                "\nNow you have 1 tasks in the list.\n", capturedOutput);
    }

    @Test
    public void showTaskDeletedTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        ToDo toDo = new ToDo("read book");
        Ui ui = new Ui();
        ui.showTaskDeleted(toDo, 1);
        String capturedOutput = outputStream.toString().replaceAll("\r\n", "\n");
        assertEquals("Noted. I've removed this task:\n  " + toDo.getLine()
                + "\nNow you have 1 tasks in the list.\n", capturedOutput);
    }

}