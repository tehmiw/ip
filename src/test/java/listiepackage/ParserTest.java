package listiepackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void parseIndexTest(){
        assertEquals(1, Parser.parseIndex("test 2"));
    }

    @Test
    public void getCommandTest(){
        assertEquals("test", Parser.getCommand("test 2"));
    }
}
