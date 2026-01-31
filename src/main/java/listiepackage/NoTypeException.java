/**
 * The `NoTypeException` class captures a exception caused by unspecified types.
 */
package listiepackage;

public class NoTypeException extends Exception{
    public NoTypeException () {
        super("You need to specify a type of task to add.");
    }
}
