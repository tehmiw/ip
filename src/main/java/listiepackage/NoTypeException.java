package listiepackage;

/**
 * The `NoTypeException` class captures a exception caused by unspecified types.
 */

public class NoTypeException extends Exception{
    public NoTypeException () {
        super("You need to specify a type of task to add.");
    }
}
