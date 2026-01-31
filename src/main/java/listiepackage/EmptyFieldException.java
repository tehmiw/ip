/**
 * The `EmptyFieldException` class captures a exception caused by unspecified fields.
 */
package listiepackage;

public class EmptyFieldException extends Exception {
    public EmptyFieldException(String itemtype) {
        super("The field(s) of a " + itemtype + " cannot be empty.");
    }
}
